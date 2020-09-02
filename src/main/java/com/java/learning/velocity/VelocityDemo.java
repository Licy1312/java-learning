package com.java.learning.velocity;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;

import java.io.StringWriter;
import java.io.Writer;

/**
 * Description:
 * User:Lee
 * Date:2018/6/30
 */
public class VelocityDemo {
    private final static String VM_CONTENT = "#set($page=3)\n" +
            "#set($pageCount=10)##�ɹ���\n" +
            "#set($pageContent='|@|1002|@|1006|@|50003409305|@|')##�ɹ���\n" +
            "#set($pageIndex=((($!page - 1) * $!pageCount) + 1))\n" +
            "#set($length=$pageContent.getBytes(\"GBK\").length())\n" +
            "$!length";


    public static void main(String[] args) throws Exception{
//        VelocityContext context = new VelocityContext();
//        context.put("m",VM_CONTENT);
//        Writer writer = new StringWriter();
//        Velocity.evaluate(context, writer, "", VM_CONTENT);
//
//        System.out.println(writer.toString());
//        String content ="|@|1002|@|1006|@|500167817|@|20190918|@|120003|@|6227000340930525806|@|����|@|01|@|140729199301060131|@|13546633124|@|20190918000200437485|@|";
//        System.out.println(content.getBytes("GBK").length);


//        test1Match();
        testContains();
    }

    private static void testMatch(){
        String test_content = "#set($bizType='1017')\n" +
                "#if($!bizType.matches('100[1-3]'))\n" +
                "#set($result='lee')\n"+
                "#elseif($!bizType.matches('100[4-5]|1011'))\n" +
                "#set($result='123456')\n" +
                "#end\n"+
                "$!result";
        VelocityContext context = new VelocityContext();
        context.put("m",test_content);
        Writer writer = new StringWriter();
        Velocity.evaluate(context, writer, "", test_content);
        System.out.println(writer.toString());
    }

    private static void test1Match(){
        FtpUtil ftpUtil = new FtpUtil();
        String test_content = "#set($name='lee')\n" +
                "#set($age='28')\n" +
                "#set($address='shanghai')\n" +
                "#set($people=[$name,$age,$address])\n"+
                "#set($result=$ftpUtil.getResult($name,$age,$address))\n"+
                "$!result";
        VelocityContext context = new VelocityContext();
        context.put("ftpUtil",ftpUtil);
        context.put("m",test_content);

        Writer writer = new StringWriter();
        Velocity.evaluate(context, writer, "", test_content);
        System.out.println(writer.toString());
    }

    private static void testContains(){

        String template = "";
        try
        {
            VelocityContext context = new VelocityContext();
            context.put("m",template);

            Writer writer = new StringWriter();
            Velocity.evaluate(context, writer, "", template);
        } catch( ParseErrorException pee )
        {
            //ģ�����﷨���󣬱���
            System.out.println("���﷨�������޸�");
        }
        catch( Exception e )
        {
            //��������
            System.out.println("��������");
        }
    }




}
