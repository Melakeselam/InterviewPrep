package com.mselam.codility.stackandqueues;

import java.util.Stack;

public class Nesting {
    public int solution(String S){
        int closing = 0;
        for(char b:S.toCharArray()){
            if(b == '(') closing++;
            else if(closing == 0)
                return 0;
            else closing --;
        }
        if(closing>0) return 0;
        return 1;
    }

    public static void main(String[] args) {
        Nesting app = new Nesting();
        System.out.println(app.solution("(()(())())"));
        System.out.println(app.solution("(()(())()"));
        System.out.println(app.solution("(()(())()))"));
    }
}
