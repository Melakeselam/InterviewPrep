package com.mselam.codility;

public class MinSumOfTwoSections {
    public static int solution(int[] A){
        int total = 0;
        for(int a:A)
            total +=a;//total = 4;
        int[] prevSums = new int[A.length];
        prevSums[0] = A[0];//prevSums={3,0}
        int minSum = Integer.MAX_VALUE; // minSum = INF
        for(int p = 1; p < A.length; p++){ //p = 2, A.length=2
            int leftSum = prevSums[p-1]; //leftSum = 3
            int rightSum = total - leftSum; //rightSum = 1
            minSum = Math.min(minSum,Math.abs(leftSum - rightSum)); //minSum = 2
            prevSums[p] = leftSum + A[p]; //prevSums={3,4}
        }
        return minSum;//2
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,1,-100,75,23,99,5,3}));
    }
}
