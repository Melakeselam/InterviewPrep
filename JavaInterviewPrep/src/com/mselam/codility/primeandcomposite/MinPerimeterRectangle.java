package com.mselam.codility.primeandcomposite;

public class MinPerimeterRectangle {
    public int solution(int N) {
        if(N == 1) return 4;
        int perimeter = 0;
        int A = 1, B = N;
        for(int i = (int)Math.sqrt(N); i > 1; i--){
            double M = (double)N / i;
            if(M == N/i){ // M is a whole number
                A = (int)M;
                B = i;
                break;
            }
        }
        perimeter = 2 * (A + B);
        return perimeter;
    }

    public static void main(String[] args) {
        MinPerimeterRectangle app = new MinPerimeterRectangle();
        System.out.println(app.solution(1));
        System.out.println(app.solution(2));
        System.out.println(app.solution(6));
        System.out.println(app.solution(25));
    }
}
