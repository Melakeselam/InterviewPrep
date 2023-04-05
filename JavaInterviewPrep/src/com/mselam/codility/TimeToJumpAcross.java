package com.mselam.codility;

import java.util.HashSet;
import java.util.Set;

public class TimeToJumpAcross {

    public static int solution(int X, int[] A){
        Set<Integer> emptyPos = new HashSet<>();
        for(int x=1;x<=X;x++){
            emptyPos.add(x);
        }
        int time = -1;
        for(int t=0;t<A.length;t++){
            emptyPos.remove(A[t]);
            if(emptyPos.isEmpty()){
                time = t;
                break;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        System.out.println(solution(5,new int[]{1,3,1,4,2,3,5,4}));
    }
}
