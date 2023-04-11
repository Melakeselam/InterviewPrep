package com.mselam.codility.timecomplexity;

public class FrogJmp {

    public int solution(int X, int  Y, int D){
        int gap = Y-X;
        return gap % D > 0? gap / D + 1: gap/D;
    }

    public static void main(String[] args) {
        FrogJmp app = new FrogJmp();
        System.out.println(app.solution(10,85,30));
        System.out.println(app.solution(10,100,30));
        System.out.println(app.solution(1,1,30));
        System.out.println(app.solution(1,2,30));
    }
}
