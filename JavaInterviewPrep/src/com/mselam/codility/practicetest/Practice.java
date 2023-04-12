package com.mselam.codility.practicetest;

import java.util.*;

public class Practice {
    public int solution(int[] A) {
        Set<Integer> exist = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int a:A){
            exist.add(a);
            max = Math.max(max, a);
        }
        int minPos = max > 0?0:1;
        if(minPos == 0)
            for(int i = 1; i <= max; i++){
                if(!exist.contains(i)){
                    minPos = i;
                    break;
                }
            }
        if(minPos == 0) return max + 1;
        return minPos;
    }

    public static void main(String[] args) {
        System.out.println(new Practice().solution(new int[]{1000000}));
    }
}
