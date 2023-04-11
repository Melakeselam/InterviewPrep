package com.mselam.codility.sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Triangle {

    public static int solution(int[] A){
        // to find 3 lengths of a triangle in the array, that fulfill the criteria A+B>C && A+C>B && B+C>A
        // this will be easily determined if the array is sorted since if the sum of two consecutive numbers is
        // greater than the third, it will fulfill the criteria: A+B>C it can be reasoned that A+C>B, since C is greater than B
        // 1, 2, 3, 7, 8  here A=2 + B=3 is less than C=7 but let say there is some number 'B' not necessarily next to 'A' that
        // will make the condition true; for example B=7 -> 2 + B=7 is greater than C=8 ().
        // if this is so (meaning there is a triangle in the set), then any value in the set from the current 'A' upto 'B' will
        // also fulfill the condition: eg. let A=3, 3+7 is greater than 8, proving if there are any two non-contiguous values of 'A' and 'B'
        // that fit the condition, then there will necessarily be three contiguous values for A,B,and C that fulfill as well.

        if(A.length < 3)
            return 0;

        Arrays.sort(A);

        for(int i = 0; i < A.length -2; i++){
            if((long)A[i] + (long)A[i+1] > (long)A[i+2])
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{10,2,5,1,8,20}));
        System.out.println(solution(new int[]{10,50,5,1}));
        System.out.println(solution(new int[]{}));
        int[] test4 = randomInts(100000, 20);
        long t1 = System.currentTimeMillis();
        System.out.println(solution(test4));
        long t2 = System.currentTimeMillis();
        System.out.println("time elapsed:"+(t2-t1));
        System.out.println(solution(new int[]{Integer.MAX_VALUE -2,Integer.MAX_VALUE-1,Integer.MAX_VALUE}));
    }

    private static int[] randomInts(int i,int negsPercent) {

       return IntStream
               .generate(()->(int)(Math.random()*Integer.MAX_VALUE))
               .map(x -> x * (Math.random() < negsPercent/100.0? -1:1))
               .limit(i).toArray();
    }
}
