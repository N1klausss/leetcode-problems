package com.cheny.leetcode;

import javax.xml.transform.Templates;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树最小深度
 */
public class LeetCode_111 {
    public static int minDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(cur.left == null && cur.right == null) {
                    return depth;
                }
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }


    public static void main(String[] args) {

    }



     static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
