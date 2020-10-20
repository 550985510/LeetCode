package com.test.tree;

import com.test.model.FinalVal;
import com.test.model.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author 崔航
 * @date 2020/7/3 10:57
 * 升序数组转二叉树，递归寻找中间值作为结点
 */
@Slf4j
public class ArrayToBalanceTree {

    public static void main(String[] args) {
        int[] nums = FinalVal.ARRAY;
        TreeNode treeNode;
        treeNode = solutionOne(nums);
        treeNode = solutionTwo(nums, 0, nums.length - 1);
        log.info("{}", treeNode);
    }

    private static TreeNode solutionTwo(int [] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = (left + right + 1) >> 1;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = solutionTwo(nums, left, middle - 1);
        node.right = solutionTwo(nums, middle + 1, right);
        return node;
    }

    private static TreeNode solutionOne(int[] nums) {
        int middle = new Double(Math.ceil(nums.length >> 1)).intValue();
        TreeNode rootNode = new TreeNode(nums[middle]);
        int[] left = Arrays.copyOf(nums, middle);
        int[] right = Arrays.copyOfRange(nums, middle + 1, nums.length);
        solutionOneSetLeftChild(rootNode, left);
        solutionOneSetRightChild(rootNode, right);
        return rootNode;
    }

    private static void solutionOneSetLeftChild(TreeNode node, int[] nums) {
        if (nums.length > 0) {
            if (nums.length == 1) {
                node.setLeft(new TreeNode(nums[0]));
            } else {
                int middleLength = nums.length >> 1;
                int middleVal = nums[middleLength];
                TreeNode leftNode = new TreeNode(middleVal);
                node.setLeft(leftNode);
                int[] leftChildren = Arrays.copyOf(nums, middleLength);
                int[] rightChildren = Arrays.copyOfRange(nums, middleLength + 1, nums.length);
                solutionOneSetLeftChild(leftNode, leftChildren);
                solutionOneSetRightChild(leftNode, rightChildren);
            }
        }
    }


    private static void solutionOneSetRightChild(TreeNode node, int[] nums) {
        if (nums.length > 0) {
            if (nums.length == 1) {
                node.setRight(new TreeNode(nums[0]));
            } else {
                int middleLength = nums.length >> 1;
                int middleVal = nums[middleLength];
                TreeNode rightNode = new TreeNode(middleVal);
                node.setRight(rightNode);
                int[] leftChildren = Arrays.copyOf(nums, middleLength);
                int[] rightChildren = Arrays.copyOfRange(nums, middleLength + 1, nums.length);
                solutionOneSetLeftChild(rightNode, leftChildren);
                solutionOneSetRightChild(rightNode, rightChildren);
            }
        }
    }

}
