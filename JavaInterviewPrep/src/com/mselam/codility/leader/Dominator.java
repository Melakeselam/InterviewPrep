package com.mselam.codility.leader;

import java.util.HashMap;
import java.util.Map;

public class Dominator {
    public int solution(int[] A){
        Map<Integer,int[]> counts = new HashMap<>();
        int i = 0;
        for(int a:A){
            if(counts.containsKey(a)){
                counts.get(a)[1]++;
            }else {
                counts.put(a,new int[]{i,1});
            }
            i++;
        }
        for(int[] v:counts.values()){
            if(v[1] > A.length/2){
                return v[0];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Dominator().solution(
                new int[]{3,4,3,2,3,-1,3,3}
        ));
        System.out.println(new Dominator().solution(
                new int[]{1,2,3,4,5,6}
        ));
        System.out.println(new Dominator().solution(
                new int[]{}
        ));
    }
}
