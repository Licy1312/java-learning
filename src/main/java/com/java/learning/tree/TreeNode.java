package com.java.learning.tree;

import java.util.List;

/**
 * @author Lee
 * @description:
 * @date:2019-07-09
 */
public class TreeNode {

    //节点值
    private String nodeValue;

    //父节点
    private TreeNode parent;

    //孩子节点
    public List<TreeNode> children;

    public TreeNode(String value){
        this.nodeValue = value;
    }

    public String getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(String nodeValue) {
        this.nodeValue = nodeValue;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

}
