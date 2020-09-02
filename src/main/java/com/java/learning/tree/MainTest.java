package com.java.learning.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lee
 * @description:
 * @date:2019-07-09
 */
public class MainTest {

    public static void main(String args[]){
        //根节点
        TreeNode treeNode0 = new TreeNode("上海市");

        //子节点
        List<TreeNode> children1 = new ArrayList<TreeNode>();
        TreeNode treeNode1 = new TreeNode("杨浦区");
        treeNode1.setParent(treeNode0);
        TreeNode treeNode2 = new TreeNode("浦东新区");
        treeNode2.setParent(treeNode0);
        children1.add(treeNode1);
        children1.add(treeNode2);
        treeNode0.setChildren(children1);

        //叶子节点
        List<TreeNode> children2 = new ArrayList<TreeNode>();
        TreeNode treeNode3 = new TreeNode("北蔡镇");
        treeNode3.setParent(treeNode2);
        TreeNode treeNode4 = new TreeNode("张江镇");
        treeNode4.setParent(treeNode2);
        TreeNode treeNode5 = new TreeNode("金桥镇");
        treeNode5.setParent(treeNode2);
        treeNode2.setChildren(children2);
        System.out.println();

    }

}
