package com.mselam.codility;

public class CountDiv {
    public static int solution(int A, int B, int K) {

        int lBound = A % K == 0 ? A: A + (K - A % K);
        int rBound = B % K == 0 ? B: B - B % K;
        int diff = rBound - lBound;
        int numInts = diff / K + 1;
        return numInts;
    }

    public static void main(String[] args) {
        System.out.println(solution( 6,11,2));
    }
}
