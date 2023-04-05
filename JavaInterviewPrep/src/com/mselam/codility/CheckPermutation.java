package com.mselam.codility;

import java.util.HashSet;
import java.util.Set;

public class CheckPermutation {
    public static int solution(int[] A) {
        Set<Integer> elements = new HashSet<>();
        for(int i = 1; i <= A.length; i++){
            elements.add(i);
        }
        for(int a:A){
            elements.remove(a);
        }
        if(elements.isEmpty())
            return 1;
        else return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,1,3,2}));
        System.out.println(solution(new int[]{4,1,3}));
        System.out.println(solution(new int[]{4}));
        System.out.println(solution(new int[]{1}));
    }
}
