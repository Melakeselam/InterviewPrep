package com.mselam.codility.prefixsums;

public class MinAvgTwoSlice {

    public static int solution(int[] A){

        int minIndexOf2 = -1;
        int minIndexOf3 = -1;
        int minSumOf2 = Integer.MAX_VALUE;
        int minSumOf3 = Integer.MAX_VALUE;

        for(int i = 0; i < A.length - 1; i++){
            int val1 = A[i];
            int val2 = A[i+1];
            int sumOf2 = val1 + val2;
            if(sumOf2 < minSumOf2){
                minSumOf2 = sumOf2;
                minIndexOf2 = i;
            }

            if(i < A.length-2){
                int sumOf3 = sumOf2 + A[i+2];
                if(sumOf3 < minSumOf3){
                    minSumOf3 = sumOf3;
                    minIndexOf3 = i;
                }
            }
        }

        if(minIndexOf3 == -1){
            return minIndexOf2;
        }
        double avg2 = minSumOf2 / 2.0;
        double avg3 = minSumOf3 / 3.0;

        if(avg2 < avg3)
            return minIndexOf2;

        if(avg3 < avg2)
            return minIndexOf3;

        return Math.min(minIndexOf2,minIndexOf3);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,2}));
        System.out.println(solution(new int[]{4,2,2,5,1,5,8}));
        System.out.println(solution(new int[]{4,2,2,5,1,-5,8}));
    }
}
