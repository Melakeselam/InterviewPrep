package com.mselam.codility;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxProductTripplets {

    private static int[] smallest = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE};
    private static int[] largest = new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};

    private static void considerLargest(int a){
        if(a > largest[0]){
            largest[2] = largest[1];
            largest[1] = largest[0];
            largest[0] = a;
        }else if( a > largest[1]){
            largest[2] = largest[1];
            largest[1] = a;
        }else if( a > largest[2]){
            largest[2] = a;
        }
    }
    private static void considerSmallest(int a){
        if(a < smallest[0]){
            smallest[1] = smallest[0];
            smallest[0] = a;
        }else if( a < smallest[1]){
            smallest[1] = a;
        }
    }
    public static int solution(int[] A){

        for(int a: A){
            considerLargest(a);
            considerSmallest(a);
        }
        int product1 = largest[0]*largest[1]*largest[2];
        int product2 = largest[0]*smallest[0]*smallest[1];

        return Math.max(product1,product2);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{-5, 5, -5, 4}));
    }
}
