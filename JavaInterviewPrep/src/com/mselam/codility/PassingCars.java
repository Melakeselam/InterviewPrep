package com.mselam.codility;

public class PassingCars {
    public static int solution(int[] A){
        int[] westBound = new int[A.length];
        if(A[A.length-1] == 1) westBound[A.length-1]=1;
        for(int i = westBound.length-2; i >= 0; i--){
            int w = westBound[i+1];
            if(A[i] == 1) westBound[i] = w + 1;
            else westBound[i] = w;
        }
        int totalPasses = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] == 0)
                totalPasses+=westBound[i];
        }
        return totalPasses;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0,1,0,1,1}));
    }
}
