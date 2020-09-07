package com.java.learning.algorithm;

import java.util.PriorityQueue;
import java.util.Queue;

public class Heap {


    private static int getParent(int i){
        if (i==0 ){
            return -1;
        }
        return (i-1)>>1;
    }

    private static int getLeft(int i){
        return 2*i+1;
    }

    private static int getRight(int i){
        return 2*i+2;
    }

    public static void build(int[] arr){
        //从最后一个节点的父节点开始

        for(int i= getParent(arr.length-1);i>=0;i--){
            int start = i;
            while (getLeft(start) < arr.length){
                int min = 0;
                int left = getLeft(start);
                int right = getRight(start);
                if (right >= arr.length){//没有右孩子，则判断左孩子是否小于当前节点
                    if(arr[start] > arr[left]){
                        min = left;
                        //交换
                        int temp = arr[left];
                        arr[left] = arr[start];
                        arr[start] = temp;
                    }
                }else{ //有右孩子，取左右孩子中最小的值和当前节点交行
                    min = arr[left] > arr[right] ? right : left;
                    if(arr[start] > arr[min]){
                        int data = arr[min];
                        arr[min] = arr[start];
                        arr[start] = data;
                    }
                }

                if (min == 0){
                    break;
                }
                start = min;
            }
        }
    }

    public static int[] heapSort(int[] arr){
        Queue<Integer> queue = new PriorityQueue<>();
        for (int temp : arr){
            queue.add(temp);
        }
        int[] result = new int[arr.length];
        int i=0;
        for (int temp : queue){
            result[i++] = temp;
        }
        return result;
    }

    /**
     * 小顶堆排序
     * @param arr 数组
     * @param index 调整的下标
     */
    public static void minHeapSort(int[] arr,int index ){
        int left = 2*index+1;
        int right = 2*index+2;
        int min = index;

        if (right >= arr.length){
            if (left < arr.length && arr[min] < arr[left]){
                min = left;
            }
        }else{
            if(left < arr.length){
                min = arr[left] > arr[right] ? right :left;
                if (arr[index] <= arr[min]){
                    min = index;
                }
            }
        }
        if (min != index){
            int temp = arr[min];
            arr[min] = arr[index];
            arr[index] = temp;

            minHeapSort(arr,min);
        }
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0){
            return new int[0];
        }
        if(k == arr.length){
            return arr;
        }
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = arr[i];
        }
        for(int j=(k-2)/2;j>=0;j--){
            maxHeapSort(result,j);
        }

        for(int t= k;t<arr.length;t++){
            if(arr[t] < result[0]){
                result[0] = arr[t];
                maxHeapSort(result,0);
            }
        }
        return result;
    }

    public static void maxHeapSort(int[] arr,int index){
        int left = 2*index+1;
        int right  = 2*index+2;
        int max = index;
        if(right >= arr.length){
            if(left < arr.length && arr[index] < arr[left]){
                max = left;
            }
        }else{
            if(left < arr.length ){
                max = arr[left] > arr[right] ? left : right;
                if (arr[index] >= arr[max]){
                    max = index;
                }
            }
        }
        if(max != index){
            int temp = arr[max];
            arr[max] = arr[index];
            arr[index] = temp;

            maxHeapSort(arr,max);
        }
    }

    public static void main(String[] args){
        int[] tempArr = {0,1,1,2,4,4,1,3,3,2};
        int k =6;
//        build(tempArr);
//        for (int i= (tempArr.length-2)/2;i>=0;i--){
//            minHeapSort(tempArr,i);
//        }
        int[] arr= getLeastNumbers(tempArr,k);

        for(int temp : arr){
            System.out.print(temp+" ");
        }
    }


}
