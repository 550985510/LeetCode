package com.test.tree;

import com.test.model.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 崔航
 * @date 2020/7/7 11:51
 * 112. 路径总和
 */
@Slf4j
public class HasPathSum {

    private static final List<Integer> LIST = new ArrayList<>(16);

    private static int SUM = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
//        boolean exist = solutionOne(root, 22);
        root = new TreeNode(1);
        root = new TreeNode(1,
                new TreeNode(-2, new TreeNode(1, new TreeNode(-1), null), new TreeNode(3)),
                new TreeNode(-3, new TreeNode(-2), null));
        boolean exist = solutionOne(root, 3);
        log.info("{}", exist);
    }

    private static boolean solutionOne(TreeNode root, int sum) {
        if (root == null && sum == 0) {
            return false;
        }
        getChild(root);
        System.out.print(LIST);
        return LIST.contains(sum);
    }

    private static void getChild(TreeNode node) {
        if (node != null) {
            SUM += node.val;
            if (node.left == null && node.right == null) {
                LIST.add(SUM);
            } else {
                if (node.left != null) {
                    getChild(node.left);
                }
                if (node.right != null) {
                    getChild(node.right);
                }
            }
            SUM -= node.val;
        }
    }
}
