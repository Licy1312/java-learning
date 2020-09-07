package com.java.learning.algorithm;

public class Array {

    public static void main(String[] args){
//        int[][] a={{1,2,3},{4,5,6},{7,8,9}};
//        printMatrix(a);
        System.out.println(divide1(-2147483648,-3));
    }

    private static void printMatrix(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();

        }
    }

    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE&&divisor==-1)
            return Integer.MAX_VALUE;

        boolean k=(dividend>0&&divisor>0)||(dividend<0&&divisor<0);
        int result=0;
        dividend=-Math.abs(dividend);
        divisor=-Math.abs(divisor);
        while(dividend<=divisor) {
            int temp=divisor;
            int c=1;
            while(dividend-temp<=temp) {
                temp=temp<<1;
                c=c<<1;
            }
            dividend-=temp;
            result+=c;
        }
        return k?result:-result;
    }

    public static int divide1(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        boolean flag = (dividend^divisor)<0;
        int result = count(dividend,divisor);
        return flag ? -result : result;
    }

    public static int count(int dividend, int divisor){
        int a = -Math.abs(dividend);
        int b = -Math.abs(divisor);
        int i=0;
        while(a<=b){
            a -=b;
            i++;
        }
        return i;
    }
}
