package com.java.learning.algorithm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeDemo {

    public static void main(String[] args) {
        TreeNode treeNode = init(new int[]{1,2,3,4,5,6,7,8});
//        List<Integer> preList = new ArrayList<>();
//        preOrder(preList,treeNode);
//        System.out.println(preList);

        List<Integer> inList = new ArrayList<>();
        inOrder(inList,treeNode);
        System.out.println(inList);
        List<Integer> inNoneList = new ArrayList<>();
        inOrderNone(inNoneList,treeNode);
        System.out.println(inNoneList);

//        List<Integer> postList = new ArrayList<>();
//        postOrder(postList,treeNode);

//        System.out.println(postList);


    }

    /**
     * 初始化完全二叉树，
     * @param arr 数组，按照顺序初始化
     * @return 二叉树
     */
    public static TreeNode init(int[] arr){
        if (arr == null || arr.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        recursion(root,0,arr);
        return root;
    }

    /**
     * 前序遍历
     * @param list 存储顺序
     * @param root 树
     */
    public static void preOrder(List<Integer> list,TreeNode root){
        if (root == null){
            return;
        }
        list.add(root.val);
        if (root.left != null){
            preOrder(list,root.left);
        }
        if (root.right != null){
            preOrder(list,root.right);
        }
    }

    /**
     * 中序遍历
     * @param list 存储顺序
     * @param root 树
     */
    public static void inOrder(List<Integer> list,TreeNode root){
        if (root == null){
            return;
        }
        inOrder(list,root.left);
        list.add(root.val);
        inOrder(list,root.right);
    }

    /**
     * 中序遍历-非递归
     * @param list 存储顺序
     * @param root 树
     */
    public static void inOrderNone(List<Integer> list,TreeNode root){
        TreeNode predecessor = null;
        while (root != null){
            //如果 节点-x 无左孩子，先将 节点-x 的值加入答案数组，再访问 节点-x 的右孩子
            if (root.left == null){
                list.add(root.val);
                root = root.right;
            }else{
                //如果 节点-x 有左孩子，则找到 节点-x 左子树上最右的节点
                predecessor = root.left;
                while (predecessor.right !=null && predecessor.right != root){
                    predecessor = predecessor.right;
                }
                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    // 说明左子树已经访问完了，我们需要断开链接
                    list.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
        }
    }

    public static void inorderTraversal(List<Integer> list,TreeNode root) {
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            list.add(root.val);
            root = root.right;
        }
    }


    /**
     * 中序遍历
     * @param list 存储顺序
     * @param root 树
     */
    public static void postOrder(List<Integer> list,TreeNode root){
        if (root == null){
            return;
        }
        if (root.left != null){
            postOrder(list,root.left);
        }
        if (root.right != null){
            postOrder(list,root.right);
        }
        list.add(root.val);
    }

    private static void recursion(TreeNode root,int index,int[] arr){
        if (2*index+1 < arr.length){
            TreeNode left = new TreeNode(arr[2*index+1]);
            root.left = left;
            recursion(root.left,2*index+1,arr);
        }

        if (2*index+2 < arr.length){
            TreeNode right = new TreeNode(arr[2*index+2]);
            root.right = right;
            recursion(root.right,2*index+2,arr);
        }
    }

    /**
     * Definition for a binary tree node.
     */
    static class TreeNode{
        private  int  val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
}
