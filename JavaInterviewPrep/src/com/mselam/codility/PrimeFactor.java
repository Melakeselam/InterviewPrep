package com.mselam.codility;

public class PrimeFactor {
    public int solution(int N) {
        if(N == 1) return 1;
        int count = 2;
        for(int i = (int)Math.sqrt(N); i > 1; i--){
            double M = (double)N / i;
            if(M == N/i){ // M is a whole number
                if(M == i) //i is sqrt of N
                    count++;
                else
                    count += 2;//factor less than sqrt paired with factor btn sqrt and half of N
            }
        }
        return count;
    }

    public static void main(String[] args) {
        PrimeFactor app = new PrimeFactor();
        System.out.println(app.solution(1));
        System.out.println(app.solution(2));
        System.out.println(app.solution(3));
        System.out.println(app.solution(24));
        System.out.println(app.solution(25));
        System.out.println(app.solution(27));
    }
}
