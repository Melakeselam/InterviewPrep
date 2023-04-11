package com.mselam.codility.euclidean;

public class ChocolatesByNumbers {
    private long lcm(long A, long B){
        long x = Math.max(A,B);
        while(x < A*B){
            if(x%A==0 && x%B==0)
                return x;
            x++;
        }
        return A*B;
    }
    private int gcd(int A, int B){
        int diff = Math.abs(A-B);
        int min = Math.min(A,B);
        if(diff == 0)
            return min;
        return gcd(min,diff);
    }
    private int gcd2(int A, int B, int res){
        if(A == B) return res * A;
        else if(A % 2 == 0 && B % 2 == 0)
            return gcd2(A/2,B/2,2*res);
        else if(A % 2 == 0 )
            return gcd2(A/2,B,res);
        else if(B % 2 == 0)
            return gcd2(A, B/2,res);
        else if(A > B)
            return gcd2(A-B, B, res);
        else
            return gcd2(A, B-A, res);
    }

    public int solution(int N, int M){
//        return (int)(lcm(N,M)/M);
        int gcf = gcd2(N,M,1);
        System.out.println(gcf);
        return N / gcd2(N,M,1);
    }

    public static void main(String[] args) {
        System.out.println(new ChocolatesByNumbers().solution(10, 7));
        System.out.println(new ChocolatesByNumbers().solution(24, 18));
    }

}
