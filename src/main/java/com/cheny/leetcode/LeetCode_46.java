package com.cheny.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列问题
 */
public class LeetCode_46 {

    static List<List<Integer>> res = new LinkedList<List<Integer>>();

    public static void main(String[] args) {
        int [] num = new int[]{1, 2, 3, 5};
        System.out.println(permute(num));
    }

    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<Integer>();
        backTranverse(nums, track);
        return res;
    }

    public static void backTranverse(int [] nums, LinkedList<Integer> track) {
        if(track.size() == nums.length ) {
            res.add(new LinkedList<Integer>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backTranverse(nums, track);
            track.removeLast();
        }
    }
}
