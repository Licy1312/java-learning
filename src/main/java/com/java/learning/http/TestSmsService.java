package com.java.learning.http;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * java的Http请求使用 HttpClient
 */
public class TestSmsService {

    // 测试环境
    private static final List<String> EXCEPT_SIGN_PARAMS
            = Arrays.asList("_appid", "_timestamp", "_sign");

    private String  _appid = "";
    private String  strSignKey = "";

    private int sms_type = 4;
    private int dest_type = 2;
    private int content_type = 2;
    private int toler_level = 11;

    // 获得秒级别时间戳
    public static Long getCurrentTimeStamp() {
        Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        return second;
    }



    /**
     *  根据传入参数生成短信平台签名
     * @param content
     *          发送内容
     * @param dest
     *          发送地址
     * @param timeStamp
     *          时间戳，秒级
     */
    public String smsSign(String content, String dest, long timeStamp) {

        Map<String, String> params = new HashMap<String, String>();
        params.put("_appid", _appid);
        // 时间戳(秒)
        params.put("_timestamp", String.valueOf(timeStamp));
        params.put("dest", dest);
        params.put("content", content);
        params.put("sms_type", String.valueOf(sms_type));
        params.put("dest_type", String.valueOf(dest_type));
        params.put("content_type", String.valueOf(content_type));

        return this.getSignForSendPayload(params);
    }



    private String getSignForSendPayload(Map<String, String> params) {
        StringBuilder signPrams = new StringBuilder(StringUtils.EMPTY);

        List<String> signKeys = params.keySet().stream().filter(key -> !EXCEPT_SIGN_PARAMS.contains
                (key)).collect(Collectors.toList());

        // 对参数字典排序
        Collections.sort(signKeys);
        for (int i = 0; i < signKeys.size(); i++) {
            signPrams.append(signKeys.get(i)).append("=").append(params.get(signKeys.get(i))).append("&");
        }

        // 去掉最后1个&
        signPrams = new StringBuilder(signPrams.substring(0, signPrams.length() - 1));
        // 拼接_appid, _timestamp, key
        signPrams.append(".").append(params.get("_appid")).append(".").append(params.get("_timestamp"))
                .append(".").append(strSignKey);

        System.out.println("排序 " + signPrams.toString());
        // 执行sha1签名,并转化为小写
        return DigestUtils.sha1Hex(signPrams.toString()).toLowerCase();
    }

    /**
     * 发送Http的Post请求，
     * form形式，
     * 'Content-Type': "application/x-www-form-urlencoded"
     *
     * @param url     发送的请求的url地址
     * @param content 发送短信的内容
     * @param dest    发送短信的目的地（手机号或者passportID）
     */
    public void postHttpRequest(String url, String content, String dest) {
        try {
            long timeStamp = this.getCurrentTimeStamp();
            System.out.println("timeStamp :" + timeStamp);
            String sign = this.smsSign(content, dest, timeStamp);
            System.out.println("签名 " + sign);

            HttpPost httpPost = new HttpPost(url);

            // payload
            List<NameValuePair> params = new ArrayList<NameValuePair>();

            params.add(new BasicNameValuePair("_appid", _appid));
            params.add(new BasicNameValuePair("_timestamp", String.valueOf(timeStamp)));
            params.add(new BasicNameValuePair("_sign", sign));
            params.add(new BasicNameValuePair("dest", dest));
            params.add(new BasicNameValuePair("content", content));
            params.add(new BasicNameValuePair("dest_type", String.valueOf(dest_type)));
            params.add(new BasicNameValuePair("sms_type", String.valueOf(sms_type)));
            params.add(new BasicNameValuePair("content_type", String.valueOf(content_type)));

            System.out.println("params len " + params.size());
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            httpPost.setHeader("Host","");
            System.out.println("Entity string " + httpPost.getEntity().toString());
            System.out.println("Entity string " + httpPost.getEntity().getContent().toString());
            CloseableHttpClient client = HttpClients.createDefault();
            CloseableHttpResponse response = client.execute(httpPost);

            System.out.println("response status " + response.getStatusLine());

            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            System.out.println(responseString);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        String url = "";
        String apiPath = "";

        String fullUrl = url + apiPath;

        System.out.println("full url " + fullUrl);
        String content=")";
        String dest = ",";

        TestSmsService testSmsService = new TestSmsService();

        testSmsService.postHttpRequest(fullUrl, content, dest);

    }

}