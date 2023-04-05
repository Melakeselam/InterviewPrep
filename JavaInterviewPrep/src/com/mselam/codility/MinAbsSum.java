package com.mselam.codility;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MinAbsSum {

    public static int solution(int[] A){
        int absMinSum=0;
        for(int a: A){
            absMinSum = Math.abs(absMinSum+a)<Math.abs(absMinSum-a)?absMinSum+a:absMinSum-a;
        }
        return absMinSum;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 3, 3, 4, 5}));;
    }
}
