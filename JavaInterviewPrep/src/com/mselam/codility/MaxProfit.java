package com.mselam.codility;

public class MaxProfit {

    public int solution(int[] A){
        int[] maxPriceToTheRight = new int[A.length];
        int max = Integer.MIN_VALUE;
        for(int i = A.length -1; i >= 0; i--){
            max = Math.max(max, A[i]);
            maxPriceToTheRight[i] = max;
        }
        int i = 0;
        int maxProfit = Integer.MIN_VALUE;
        for(int p:A){
            maxProfit = Math.max(maxProfit,maxPriceToTheRight[i] - p);
            i++;
        }
        return Math.max(maxProfit, 0);
    }

    public static void main(String[] args) {
        MaxProfit app = new MaxProfit();
        System.out.println(app.solution(new int[]{
                23171,21011,21123,21366,21013,21367
        }));
        System.out.println(app.solution(new int[]{}));
        System.out.println(app.solution(new int[]{5,4,3,2,1}));
    }

}
