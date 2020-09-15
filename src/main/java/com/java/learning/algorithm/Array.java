package com.java.learning.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Array {

    public static void main(String[] args){
//        int[][] a={{1,2,3},{4,5,6},{7,8,9}};
//        printMatrix(a);
//        System.out.println(divide1(-2147483648,-3));
        int[] arr = {10,1,2,7,6,1,5};

        System.out.println(combinationSum2(arr,8));
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

    /**
     * 组合：求从1-n中选择K个数的所有组合情况，例如：n=3，k=2；输出：
     * [
     * [1,2]
     * [1,3]
     * [2,3]
     * ]
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {
        if (n < k || k <= 0) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>(); // 用于存储 总结果集
        List<Integer> path = new ArrayList<>(); // 用于存储 当前结果
        dfs(n, k, 1, path, result);
        return result;
    }

    private static void dfs(int n, int k, int index, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) { // 长度合适，增加当前结果，并 结束本轮递归
            result.add(new ArrayList<>(path));
            return;
        }
        /*
            i 从 index 开始，保证 在当前循环中，不会重复遍历 之前遍历过的数字
            n - (k - path.size()) + 1 表示 当前循环，起点所能达到的最大的数(保证最后一个数字加入时，正好能组成长度为k的结果)
         */
        for (int i = index; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);    // 将新元素 添加至 尾部，照应后面的处理
            dfs(n, k, i + 1, path, result);
            path.remove(path.size() - 1);   // 移除 最后添加进去的元素
        }
    }

    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用一次。
     *
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     *   [1, 7],
     *   [1, 2, 5],
     *   [2, 6],
     *   [1, 1, 6]
     * ]
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>(); // 用于存储 总结果集
        List<Integer> path = new ArrayList<>(); // 用于存储 当前结果
        Arrays.sort(candidates);
        calculate(path, result, 0,0,target, candidates);
        return result;
    }

    public static void calculate(List<Integer> path,List<List<Integer>> combinList,int total,int index,int target,int[] candidates){
        //符合解的条件
        if(total == target){
            combinList.add(new ArrayList<>(path));
            return;
        }
        if(total > target){
//            path.add()
            return;
        }

        for(int i=index;i<candidates.length;i++){
            if (i > index && candidates[i] == candidates[i - 1]) {  // 剪枝 + 处理 “重复结果问题”
                continue;
            }
            path.add(candidates[i]);
            calculate(path,combinList,total+candidates[i],i+1,target,candidates);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // 用于存储 总结果集
        List<String> temp = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            //去重
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            int target = 0-nums[i];
            int right = nums.length -1; //尾指针

            //转换成两个数相加求合问题
            for(int j=i+1;j<nums.length;j++){

                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                while(j < right && nums[j]+nums[right] > target){
                    --right;
                }
                if(j == right){
                    break;
                }
                if(nums[j]+nums[right] == target){
                    List<Integer> tempList =new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    tempList.add(nums[right]);
                    result.add(tempList);
                }
            }
        }
        return result;
    }

}
