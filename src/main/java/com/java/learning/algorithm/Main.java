package com.java.learning.algorithm;
import java.util.*;

public class Main{

    public static void main(String[] args){
        int[] arr = {2,1};
//        System.out.println(maxSubArray(arr));
//        System.out.println(maxSubArraySum(arr));
//        int[] temp = arr.clone();
//        Arrays.sort(temp);
        quickSort1(arr,0,arr.length-1);
        for(int temp:arr){
            System.out.print(temp+" ");
        }


    }

    /**
     * 求最大子序列和
     * @param arr 序列
     * @return 最大子序列的和
     */
    private static int maxSubArray(int[] arr){
        int sum = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {
            if (sum <=0) {
                sum = arr[i];
            } else {
                sum += arr[i];
            }
            maxValue = Math.max(sum,maxValue);
        }
        return maxValue;
    }

    private static int maxSubArraySum(int[] arr){
        int maxValue = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {
            int sum = 0;
            for (int j=i; j<arr.length; j++) {
                sum +=arr[j];
                maxValue = Math.max(sum,maxValue);
            }
        }
        return maxValue;
    }

    public int maxProfit (int[] prices) {
        int maxValue = Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            int value= prices[i];
            for(int j=i+1;j<prices.length;j++){
                value = prices[j]-value;
                maxValue = Math.max(maxValue,value);
            }
        }
        return maxValue;
    }

    private static void quickSort(int[] arr,int low,int high){
       if (low < high){
           int i = low,j = high,temp = arr[low];//认为第一个数是基数
           while (i < j){
               while(i < j && temp <=arr[j]){ //从右边开始找第一个比基数小的
                   j--;
               }
               if (i < j){
                   arr[i++] = arr[j];
               }
               while(i < j && temp > arr[i]){//从左边开始找第一个数比基数大的
                   i++;
               }
               if (i < j){
                  arr[j--] = arr[i];
               }
           }
           arr[i] = temp;

           quickSort(arr,low,i-1);
           quickSort(arr,i+1,high);
       }
    }

    public static void quickSort1(int[] nums, int low, int high){
        if(low < high){
            int i=low,j=high,temp = nums[high];
            while(i<j){
                while(nums[i] <= temp && i<j){
                    i++;
                }
                if(i<j){
                    nums[j--] = nums[i];
                }
                while(nums[j] >= temp && i<j){
                    j--;
                }
                if(i<j){
                    nums[i++] = nums[j];
                }
            }
            nums[j] = temp;
            quickSort1(nums,j+1,high);
            quickSort1(nums,low,j-1);
        }
    }

    /**
     *
     */

    /**
     * 一组需要修复的机器，对应需要花的时间为一组整形数组，修复机器总耗时为T；可以跳过一次，在T时间内修改的机器数最多，求跳过的机器。
     * 输入：A={2,9,4,3,16,1}、B=11
     * 输出：2（代表第二台机器）
     */
    private int method(){
        return 0;
    }
}
