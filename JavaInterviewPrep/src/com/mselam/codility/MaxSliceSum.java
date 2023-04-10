package com.mselam.codility;

public class MaxSliceSum {
    public int solution(int[] A) {
        // previous sum ceiling is the heighest value between the previous sum and the current value
        // track the maximum of the previous sum ceilings
        // return the maximum
        // [1,2,3] -> all positive values
        // -INF + 1 | 1 -> 1
        // 1 + 2 | 2 -> 3
        // 3 + 3 | 3 -> 6
        // 2 + 3 | 6 -> 6
        // [-1,2,3] -> with negative values
        // -INF + -1 | -1 -> -1
        // -1 + 2 | 2 -> 2
        // 2 + 3 | 3 -> 5
        // 2 + 3 | 5 -> 5

        long prevSumCeil = Integer.MIN_VALUE;
        long maxSum = Integer.MIN_VALUE;

        for(int a : A){
            prevSumCeil = Math.max(prevSumCeil + a, a);
            maxSum = Math.max(maxSum, prevSumCeil);
        }

        return (int)maxSum;
    }

    public static void main(String[] args) {
        MaxSliceSum app = new MaxSliceSum();
        System.out.println(app.solution(new int[]{-2, -2, 1}));
        System.out.println(app.solution(new int[]{2}));
        System.out.println(app.solution(new int[]{-2}));
        System.out.println(app.solution(new int[]{3, 2, -6, 4, 0}));
    }
}
