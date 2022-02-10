package com.cheny.leetcode;

import java.util.*;

public class LeetCode_752 {

    public int openLock(String[] deadends, String target) {

        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        List<String> deadList = Arrays.asList(deadends);
        queue.offer("0000");
        visited.add("0000");
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if(deadList.contains(cur)) {
                    continue;
                }
                if(target.equals(cur)) {
                    return depth;
                }
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if(!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if(!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            depth++;
        }
        return -1;
    }

    private String plusOne(String str, int idx) {
        char[] arr = str.toCharArray();
        if(arr[idx] == '9') {
            arr[idx] = '0';
        } else {
            arr[idx] += 1;
        }
        return new String(arr);
    }

    private String minusOne(String str, int idx) {
        char[] arr = str.toCharArray();
        if(arr[idx] == '0') {
            arr[idx] = '9';
        } else {
            arr[idx] -= 1;
        }
        return new String(arr);
    }
}
