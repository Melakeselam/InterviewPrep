package com.mselam.codility.arrays;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {
    public static int sollution(int[] A){
        Set<Integer> unpaired = new HashSet<>();
        for(int a:A){
            boolean paired = unpaired.remove(a);
            if(!paired) unpaired.add(a);
        }
        return (int)unpaired.toArray()[0];
    }

    public static void main(String[] args) {
        System.out.println(sollution(new int[]{9,3,9,3,9,7,9}));
    }
}
