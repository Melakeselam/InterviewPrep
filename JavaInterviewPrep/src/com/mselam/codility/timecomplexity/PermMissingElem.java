package com.mselam.codility.timecomplexity;

import java.util.HashSet;
import java.util.Set;

public class PermMissingElem {
    public int solution(int[] A){

        Set<Integer> existing = new HashSet<>();
        for(int a:A) existing.add(a);
        int x = A.length+1;
        for(int i = 1; i <= A.length+1; i++) if(!existing.contains(i)) {
            x = i;
            break;
        };
        return x;
    }

    public static void main(String[] args) {
        System.out.println(new PermMissingElem().solution(new int[]{2,3,1,5}));
    }
}
