package com.java.learning.algorithm;


import java.util.Stack;

/**
 * 单例表相关的算法操作
 * 1.奇偶链表
 * 2.判断回文链表
 * 3.链表反转
 */
public class SingleLinkedList {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //初始化
        int[] values = {9};
        int[] value2 = {1,9,9,9,9,9,9,9,9,9};

        ListNode listNode = singleLinkedList.initNode(values);
        ListNode listNode2 = singleLinkedList.initNode(value2);
////        ListNode[] result = singleLinkedList.splitListToParts(listNode,3);
//        ListNode result = singleLinkedList.addTwoNumbers(listNode,listNode2);
//
//        singleLinkedList.print(result);
        System.out.println(singleLinkedList.addTwoNumbers(listNode,listNode2));

        //打印
//        for (int i=0;i<result.length;i++)
//        singleLinkedList.print(result[i]);
//        singleLinkedList.print(singleLinkedList.reverseList(listNode));

    }



    //******************************************************************************************************************
    /**
     * 1.奇偶链表
     * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
     * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
     * @param head 链表
     * @return 处理后的链表
     */
    private ListNode dealListNode(ListNode head){
        if (head == null){
            return head;
        }

        ListNode ood = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while (even !=null && even.next !=null){
            ood.next = even.next;
            ood = ood.next;
            even.next = ood.next;
            even = even.next;
        }
        ood.next = evenHead;

        return head;
    }


    /**
     * 2.判断是否为回文链表
     * @param head 链表
     * @return true/false
     */
    private boolean isPalindromeList(ListNode head){
        Stack<Integer> nodeStack = new Stack<>();
        ListNode temp = head;
        while (temp !=null) {
            nodeStack.push(temp.value);
            temp = temp.next;
        }
        ListNode listNode = head;
        while (listNode !=null) {
            if (listNode.value != nodeStack.pop()){
                return false;
            }
            listNode = listNode.next;
        }
        return true;
    }

    /**
     * 3.反转链表
     * 将一个链表进行反转。
     * @param head 正向链表
     * @return 逆向链表
     */
    private ListNode reverseList(ListNode head){
        ListNode pointerA =  null;
        ListNode pointerB = null;
        while(head !=null){
            pointerA = head.next;
            head.next = pointerB;
            pointerB = head;
            head = pointerA;
        }
        return pointerB;
    }

    /**
     * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
     *
     * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
     *
     * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
     *
     * 返回一个符合上述规则的链表的列表。
     *
     * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
     *
     * 输入:
     * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
     * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        int length =0;
        ListNode temp = root;
        while(temp !=null){
            length++;
            temp = temp.next;
        }
        if(k >= length){
            int i=0;
            ListNode tempNode = root;
            while(tempNode !=null){
                ListNode oneNode = new ListNode(tempNode.value);
                result[i++] = oneNode;
                tempNode = tempNode.next;
            }
            for(int j=i; j<k; j++){
                result[j] =null;
            }
        }else{
            int nums = length/k;
            int lastNums = length%k;
            int[] nodeNums = new int[k];
            for(int i=0;i<k;i++){
                nodeNums[i] = nums;
            }
            for(int i=0;i<lastNums;i++){
                nodeNums[i]++;
            }
            ListNode head = root;
            for(int j=0;j<k;j++){
                ListNode newNode = head;
                for (int t=0; t<nodeNums[j]-1; t++){
                    if (head !=null){
                        head = head.next;
                    }
                }
                if (head !=null){
                    ListNode prev = head;
                    head = head.next;
                    prev.next =null;
                }
                result[j] = newNode;
            }

        }

        return result;
    }


    /**
     * 两数相加，
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param l1 (2 -> 4 -> 3)
     * @param l2  (5 -> 6 -> 4)
     * @return 7 -> 0 -> 8
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headResult = new ListNode(0);
        int temp = 0;
        ListNode curr= headResult;
        while(l1 !=null || l2 !=null || temp !=0){
            if(l1 != null){
                temp += l1.value;
                l1 = l1.next;
            }
            if(l2 != null){
                temp += l2.value;
                l2 = l2.next;
            }
            curr.next = new ListNode(temp%10);
            curr = curr.next;
            temp = temp/10;
        }
        return headResult.next;
    }





    public String getStringValue(ListNode l1){
        String a = "";
        while(l1 !=null){
            a += l1.value+"";
            l1 = l1.next;
        }
        return a;
    }








    //******************************************************************************************************************


    /**
     * 初始化单链表
     * @param values 数组
     * @return 链表
     */
    private ListNode initNode(int[] values){
        return new ListNode(values);
    }

    /**
     * 打印链表
     * @param listNode 链表
     */
    public void print(ListNode listNode){
        ListNode next = listNode;
        StringBuilder stringBuilder = new StringBuilder();
        while (next != null) {
            stringBuilder.append(next.value);
            next = next.next;
            if (next != null){
                stringBuilder.append(" > ");
            }
        }
        System.out.println(stringBuilder.toString());
    }

    /**
     * 单链表的数据结构
     */
    class ListNode {
        private int value;

        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode(int arr[]) {
            if (arr == null || arr.length == 0) {
                throw new IllegalArgumentException("arr can not be empty");
            }
            this.value = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }

        }
    }
}
