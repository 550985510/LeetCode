package com.test.model;

import lombok.Data;
/**
 * @author 崔航
 * @date 2020/7/3 10:51
 */
@Data
public class TreeNode {

    public Integer val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
