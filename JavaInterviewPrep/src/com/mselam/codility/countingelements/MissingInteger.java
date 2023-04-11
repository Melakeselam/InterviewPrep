package com.mselam.codility.countingelements;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {
    public static int solution(int [] A){
        Set<Integer> unique = new HashSet<>();
        int max = 0;
        for(int a:A){
            unique.add(a);
            max = Math.max(max,a);
        }

        int minPos = 1;
        boolean found = false;
        for(int i = 1; i <= max; i++){
            if(!unique.contains(i)){
                minPos = i;
                found = true;
                break;
            }
        }
        if(!found && minPos <= max) minPos = max +1;
        return minPos;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println(solution(new int[]{1, 3, 2}));
        System.out.println(solution(new int[]{-3, -2}));
    }
}
