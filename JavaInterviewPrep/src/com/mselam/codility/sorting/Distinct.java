package com.mselam.codility.sorting;

import java.util.HashSet;
import java.util.Set;

public class Distinct {

    public int solution(int[] A){
        Set<Integer> distinct = new HashSet<>();
        for(int a:A) distinct.add(a);
        return distinct.size();
    }

    public static void main(String[] args) {
        System.out.println(new Distinct().solution(new int[]{2,1,1,2,3,1}));
    }
}
