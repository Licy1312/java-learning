package com.java.learning.abc;

import com.java.learning.abc.simple.Student;

import java.math.BigDecimal;
import java.net.ConnectException;
import java.text.MessageFormat;
import java.util.*;

/**
 * Description:
 *
 * @Author:Jinmu
 * Date: 2018/6/7
 */
public class Abc {

    //byte 数据类型是8位、有符号的，以二进制补码表示的整数；byte 类型用在大型数组中节约空间，主要代替整数，因为 byte 变量占用的空间只有 int 类型的四分之一；
    //最小值是 -128（-2^7）；最大值是 127（2^7-1）；默认值是 0；
    byte a=-128;

    //short 数据类型是 16 位、有符号的以二进制补码表示的整数;Short 数据类型也可以像 byte 那样节省空间。一个short变量是int型变量所占空间的二分之一；
    //最小值是 -32768（-2^15）；最大值是 32767（2^15 - 1）； 默认值是 0；
    short b=200;

    //int 数据类型是32位、有符号的以二进制补码表示的整数；一般地整型变量默认为 int 类型；
    //最小值是 -2,147,483,648（-2^31）；最大值是 2,147,483,647（2^31 - 1）； 默认值是 0；
    int c=2400;

    //long 数据类型是 64 位、有符号的以二进制补码表示的整数；这种类型主要使用在需要比较大整数的系统上；
    //最小值是 -9,223,372,036,854,775,808（-2^63）；最大值是 9,223,372,036,854,775,807（2^63 -1）； 默认值是 0L；
    long d=3000L;

    //float 数据类型是单精度、32位、符合IEEE 754标准的浮点数；float 在储存大型浮点数组的时候可节省内存空间；
    //默认值是 0.0f；浮点数不能用来表示精确的值，如货币；
    float e=300.45f;

    //double 数据类型是双精度、64 位、符合IEEE 754标准的浮点数；double类型同样不能表示精确的值，如货币；
    //浮点数的默认类型为double类型； 默认值是 0.0d；
    double f=2000.10;

    //boolean数据类型表示一位的信息；这种类型只作为一种标志来记录 true/false 情况；
    //只有两个取值：true 和 false；默认值是 false；
    boolean g=false;

    //char类型是一个单一的 16 位 Unicode 字符；char 数据类型可以储存任何字符；
    //最小值是 \u0000（即为0）；最大值是 \uffff（即为65,535）；
    char h='s';

    private  static Map<Integer,List<String>> map = new HashMap<Integer,List<String>>();

    private static Student student;



    public static void main(String[] args) {

//        testList();
//        student = new Student();
//
//        People people = new MiddleStudent();
//        Integer a = Integer.valueOf(0);
//        if(a==0){
//            System.out.println(true);
//        }
//        testList(null);
//        try {
//            exceptionTest();
//        }catch (Exception e){
//            if (e instanceof ConnectException && e.getMessage().equals("Connection timed out")){
//                System.out.println("OK");
//            }
//        }

//        int[] a={5};
//
//        simpleDigest(a);
//        HashMap<String,Student> availableMap = new HashMap<String,Student>();
//        availableMap.put("10",new Student(1000));
//        availableMap.put("11",new Student(1011));
//        availableMap.put("20",new Student(1020));
////        realLineRate(availableMap);
//        Student temp = availableMap.get("10");
//        temp.setId(6666);
//
//        HashMap<String,Student> tempMap = new HashMap<String,Student>();
//
//        tempMap.putAll(availableMap);
//        availableMap.clear();
//
//
//        System.out.println(availableMap);
//        System.out.print(tempMap);

//        testLog();

        Abc abc = new Abc();
//        System.out.println(tryCatchFinally());
//        test();
//        System.out.println(abc.f>=abc.c);
//        System.out.println((-1/1.1)*100 <= 100);
//        System.out.println((0/1.1)*100 <= 100);

        double a =new BigDecimal((double)11/10).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()*100;
        double b=(new BigDecimal((double)9/10).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue())*100;
        System.out.println(a);
        System.out.println(b);

        System.out.println(a <= 100);
        System.out.println(b <=100 );

    }

    public static void exceptionTest() throws Exception{
        throw new ConnectException("Connection timed out");
    }

    public static void testList(List<String> list,String[] a,int[] b){
        for(String str: list){

        }
    }

    public static void testTempList(){
        List<String> tempList = map.get(1);
        if(tempList == null){
            tempList = new ArrayList<>();
            map.put(1,tempList);
        }

        tempList.add("lee");
        System.out.print("111");
    }

    public static void testCharset() throws Exception{
        int a = "张燕欣".getBytes("GBK").length;
        int b = "张燕欣".getBytes("UTF-8").length;
        System.out.println("a的长度："+a);
        System.out.println("b的长度："+b);
    }



    public static void simpleDigest(int input[]){
        int temp = input[0],x=0,y=0;
        System.out.println(Arrays.toString(input));
        for(int i=0;i<input.length-1;i++){
            x=temp;
            y=input[i+1];
            temp = commonDivisor(x,y);
        }
        System.out.println("最大公约数:"+temp);

        int[] result = new int[input.length];
        for(int i=0;i<input.length;i++){
            result[i]=input[i]/temp;
        }
        System.out.println(Arrays.toString(result));
    }

    /**
     * 简化可用专线的比例
     * @param configLineList 可以使用的专线
     * @return 化简后的最简比例
     */
    private static Map<String,Integer> availableLine(List<String> configLineList){
        Map<String,Integer> availableMap = new HashMap<>();
        for(String lineNumber:configLineList){
            if(availableMap.containsKey(lineNumber)){
                availableMap.put(lineNumber,availableMap.get(lineNumber)+1);
            }else{
                availableMap.put(lineNumber,1);
            }
        }

        List<Integer> numberList = new ArrayList<>();
        for(String lineNumber:availableMap.keySet()){
            lineNumber.toCharArray();
            numberList.add(availableMap.get(lineNumber));
        }

        int temp = numberList.get(0),x = 0,y = 0;
        for(int i=0;i<numberList.size()-1;i++){
            x=temp;
            y=numberList.get(i+1);
            temp = commonDivisor(x,y);
        }
        Map<String,Integer> resultMap = new HashMap<>();
        for(String lineNumber:availableMap.keySet()){
            resultMap.put(lineNumber,availableMap.get(lineNumber)/temp);
        }
        return resultMap;
    }

    private static void realLineRate(Map<String,Integer> availableMap){
        List<Integer> numberList = new ArrayList<>();
        for(String lineNumber:availableMap.keySet()){
            numberList.add(availableMap.get(lineNumber));
        }

        int temp = numberList.get(0),x = 0,y = 0;
        for(int i=0;i<numberList.size()-1;i++){
            x=temp;
            y=numberList.get(i+1);
            temp = commonDivisor(x,y);
        }
        for(String lineNumber:availableMap.keySet()){
            availableMap.put(lineNumber, (Integer)(availableMap.get(lineNumber)/temp));
        }
    }

    //计算2个整数的最大公约数
    private static  int commonDivisor(int a,int b){
        int temp=0;
        while(b!=0){
            temp = a%b;
            a=b;
            b=temp;
        }
        return a;
    }

    private static void testList(){
        List<String> list = new ArrayList<>();
        list.add("channelCode");
        list.add("");
        list.add("bankCode");
        list.add("");
        list.add("bankCode");
        System.out.println(list.toString());
        System.out.println(list.size());
        System.out.println((String[]) list.toArray());
    }

    private static void testLog(){

         String DIFFERENT_LOG_PATTERN = "{0},{1},{2},{3},{4},{5}";
        String differentLog = MessageFormat.format(DIFFERENT_LOG_PATTERN,
                "12345667","4001",String.valueOf(1000),"-","-","-,-");
        System.out.println(differentLog);
    }


    private static int tryCatchFinally(){
        int a=0;
        try {
            a=1;
            int b= 1/0;
            return a;
        }catch (Exception e){
            a=2;
            e.printStackTrace();
            return a;
        }finally {
            a++;
        }
    }


    private static void test(){
        int a=3;
        int b=5;
        a=a+b;
        b=a-b;
        a=a-b;

        int c=11;
        int d=15;
        c= c^d;
        d= c^d;
        c= c^d;


        int e=-10;
        int f=13;

        e=e*f;
        f=e/f;
        e=e/f;

        System.out.println(a+","+b);
        System.out.println(c+","+d);
        System.out.println(e+","+f);
    }

}
