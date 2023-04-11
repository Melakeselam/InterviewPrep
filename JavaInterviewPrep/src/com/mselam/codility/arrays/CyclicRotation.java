package com.mselam.codility.arrays;

import java.util.Arrays;

public class CyclicRotation {
    public static int[] solution(int[] A, int K){
        if(A.length == 0) return A;
        if(K > A.length) K = K % A.length;
        if(K == A.length || K == 0) return A;
        int P = A.length - K;
        int[] shifted = new int[A.length];
        System.arraycopy(A,P,shifted,0,K);
        System.arraycopy(A,0,shifted,K,P);
        return shifted;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{3, 8, 9, 7, 6},6)));
        System.out.println(Arrays.toString(solution(new int[]{3, 8, 9, 7, 6},10)));
        System.out.println(Arrays.toString(solution(new int[]{3, 8, 9, 7, 6},13)));
        System.out.println(Arrays.toString(solution(new int[]{},13)));
    }
}
