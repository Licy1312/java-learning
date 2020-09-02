package com.java.learning.image;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

public class ImageBase64 {

    private static String localFilePath = "/Users/Lee/work/day/notes/test1.jpg";

    private static String savePath = "/Users/Lee/work/day/notes/cs2.jpg";

    public static void main(String[] args) throws  Exception{
        String imageBase64 = imageToBase64(localFilePath);

//        System.out.println(imageBase64);

        testBase64ToImage(imageBase64,savePath);
//        testByte();
    }


    private static String imageToBase64(String imagePath){
        InputStream in = null;
        byte[] data = null;
        String encode = null; // 返回Base64编码过的字节数组字符串
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            // 读取图片字节数组
            in = new FileInputStream(imagePath);
            data = new byte[in.available()];
            in.read(data);
            encode = encoder.encode(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return encode;
    }

    private static void base64ToImage(String imageContent,String savePath){

        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try {
            out = new FileOutputStream(savePath);
            // Base64解码
            byte[] b = decoder.decodeBuffer(imageContent);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            out.write(b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testBase64ToImage(String imageContent,String savePath){
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try {

            // Base64解码
            byte[] b = decoder.decodeBuffer(imageContent);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            String content = new String(b,"ISO-8859-1");
            out = new FileOutputStream(savePath);
            out.write(content.getBytes("ISO-8859-1"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void testByte() throws Exception{
        byte[] a ={1,2,3,4,5,6,7,89,0,51,1};
        String content = new String(a,"utf-8");
        byte[] c = content.getBytes("utf-8");
        for (int j=0;  j < c.length; ++j){
            System.out.print(c[j]+',');
        }

    }


    private static String base64ToString(String imageContent) throws Exception{
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] b = decoder.decodeBuffer(imageContent);
        for (int i = 0; i < b.length; ++i) {
            if (b[i] < 0) {// 调整异常数据
                b[i] += 256;
            }
        }
        return new String(b,"ISO-8859-1");
    }

    private static String testImage2Str(String filePath) throws Exception{
        InputStream inputStream = null;
        String result = "";
        try {
            File file = new File(filePath);
            inputStream = new FileInputStream(file);
//            result = IOUtils.toString(inputStream, "utf-8");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static boolean testStr2Image(String imgStr, String filePath) {

        if (imgStr == null) {
            return false;
        }
        try {

            byte[] b = imgStr.getBytes("GBK");
            // 处理数据
            for(int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(filePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

    // 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
    private static String getImageStr(String imgPath) {
        String imgFile = imgPath;// 待处理的图片
        InputStream in = null;
        byte[] data = null;
        String encode = null; // 返回Base64编码过的字节数组字符串
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            // 读取图片字节数组
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            encode = encoder.encode(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return encode;
    }

    // 对字节数组字符串进行Base64解码并生成图片
    private static boolean generateImage(String imgData, String imgFilePath) throws IOException {
        if (imgData == null) // 图像数据为空
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try {
            out = new FileOutputStream(imgFilePath);
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgData);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            out.write(b);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
            return true;
        }
    }

    private static boolean generateImageTest(String imgData, String imgFilePath) throws IOException {
        OutputStream out = null;
        try {
            out = new FileOutputStream(imgFilePath);
            out.write(imgData.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
            return true;
        }
    }


//    public static void main(String[] args) throws Exception{
//
////        uploadImage();
////        uploadFile();
////        uploadOneImage();
//        downloadOneImage();
////        downloadFile();
////        downloadImage();
//    }


    private static void uploadImage() throws Exception {
        String hostName = "";
        String hostPort = "";
        String userName = "";
        String password = "";
        String localFilePath = "/Users/lee/work/day/notes/test1.jpg";

        //图片转成Base64字符串
        String imageContent = getImageStr(localFilePath);

        String content = base64ToString(imageContent);
        //ftp 上传
//        String result = uploadFileBySftp(hostName,hostPort,userName,password,"","test_image/100330/20200606","test20.jpg",content,"ISO-8859-1");
//        System.out.println(result);

//        BASE64Decoder decoder = new BASE64Decoder();
//        // Base64解码
//        byte[] b = decoder.decodeBuffer(imageContent);
//        for (int i = 0; i < b.length; ++i) {
//            if (b[i] < 0) {// 调整异常数据
//                b[i] += 256;
//            }
//        }
//        InputStream input = new ByteArrayInputStream(b);
//        String result = uploadFileInputSteamBySftp(hostName,hostPort,userName,password,"","test_image/100330/20200606","test11.jpg",input);
//        System.out.println(result);


    }


    private static void downloadImage() throws IOException {
        //sftp下载
        String savePath = "/Users/lee/work/day/notes/cs3.jpg";
        String hostName = "";
        String hostPort = "";
        String userName = "";
        String password = "";

//        Map<String,String> result1 = downloadFileBySftp(hostName,hostPort,userName,password,"", "test_image/100330/20200606","test3.jpg",
//                "utf-8");
//        System.out.println(result1);

        //需要base64转换
//        generateImage(result1.get("message"),savePath);

        //不需要base64转换
//        generateImageTest(result1.get("message"),savePath);
    }




    private static void downloadFile() throws Exception {
        String hostName = "113.57.167.50";
        String hostPort = "28999";
        String userName = "ifp";
        String password = "ifp";
        String savePath = "/Users/lee/work/day/notes/cs5.jpg";

//        Map<String,String> result1 = downloadFileBySftp(hostName,hostPort,userName,password,"", "test_image/100330/20200606","test5.jpg",
//                "utf-8");
//        System.out.println(result1);

//        generateImageTest(result1.get("message"),savePath);
    }

    private static void uploadOneImage() throws Exception {


        String hostName = "113.57.167.50";
        String hostPort = "28999";
        String userName = "ifp";
        String password = "ifp";
        String localFilePath = "/Users/lee/work/day/notes/test1.jpg";

//        //初始化sftp客户端，
//        SftpClient sftpClient = new SftpClient(hostName,28999,"ifp","ifp","");
//        sftpClient.login();
//
//        InputStream in = new FileInputStream(localFilePath);
//
//        String result = uploadFileInputSteamBySftp(hostName,hostPort,userName,password,"","test_image/100330/20200606","test10.jpg",in);
//
//        System.out.println(result);
//        //上传文件
//        sftpClient.upload("test_image/100330/20200606","test6.jpg",in);
//
//        sftpClient.logout();
    }


    private static void downloadOneImage() throws Exception {


        String hostName = "";
        String hostPort = "";
        String userName = "";
        String password = "";
        String savePath = "/Users/lee/work/day/notes/cs1.jpg";

//        //初始化sftp客户端，
//        SftpClient sftpClient = new SftpClient(hostName,28999,"ifp","ifp","");
//        sftpClient.login();
//
//        String directory = "test_image/100330/20200606";
//        sftpClient.downloadAndSave(directory,"test20.jpg",savePath);
//        sftpClient.logout();
    }

    private String imageContent(String imageBase64) throws Exception{
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] b = decoder.decodeBuffer(imageBase64);
        for (int i = 0; i < b.length; ++i) {
            if (b[i] < 0) {
                b[i] += 256;
            }
        }
        return new String(b,"ISO-8859-1");
    }






    private static void uploadFile() throws Exception {
        String hostName = "";
        String hostPort = "";
        String userName = "";
        String password = "";
        String charset = "utf-8";
        String remoteFilePath = "/100330/20200606";
        String remoteFileName = "test5.jpg";
        String localFilePath = "/Users/lee/work/day/notes/test1.jpg";

//        //图片转成Base64字符串
//        InputStream inputStream = new FileInputStream(localFilePath);
//        String content = IOUtils.toString(inputStream, charset);
//        //ftp 上传
//        String result = uploadFileBySftp(hostName,hostPort,userName,password,"",
//                remoteFilePath,remoteFileName,content,charset);
//        System.out.println(result);
    }

    private static void downloadFile1(){
        OutputStream out =null;
        try {
            String hostName = "127.0.0.1";
            String hostPort = "";
            String userName = "";
            String password = "";
            String remoteFilePath = "images";
            String remoteFileName = "front.jpg";
            String charset = "utf-8";
            String saveLocalPath = "/Users/lee/work/day/notes/cs4.jpg";


//            byte result[] = downloadFileByFtp(hostName,hostPort,userName,password,remoteFilePath,remoteFileName);

//            if (result !=null){
//                out= new FileOutputStream(saveLocalPath);
//                out.write(result);
//            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (out !=null){
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
