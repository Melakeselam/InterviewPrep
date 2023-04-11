package com.mselam.codility.stackandqueues;

import java.util.Stack;

public class Brackets {

    public static int solution(String S){
        //watch out for the edge cases. follow the instructions to the letter. made mistake here of not reading the whole
        // conditions:
        //      1. write efficient algorithm: i wrote junky, unnecessary initializations, storage and testing.
        //      2. only opening and closing characters existed: no need to test for others
        //      3. know your tools: stack.pop() throws exception when empty causing the program to fail unexpected.
        //      4. don't forget to test for all edge cases: I forgot to test if the stack was empty while in the loop and
        //          after the loop. This mean't there was an open bracket(s) that needed to be closed.
        Stack<Character> expected = new Stack<>();

        for(char c:S.toCharArray()){
            switch(c){
                case '(': expected.push(')');break;
                case '{': expected.push('}');break;
                case '[': expected.push(']');break;
                case '<': expected.push('>');break;
                default: if(expected.isEmpty() || c != expected.pop()) return 0;
            }
        }
        if(!expected.isEmpty()) return 0;

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(solution("{[()()]}"));//1
        System.out.println(solution("([)()]"));//0
        System.out.println(solution("{[()()]}}"));//0
        System.out.println(solution("{[()()]}}"));//0

        System.out.println(solutionAllChars("(5+6[9-1]{2})"));//1
        System.out.println(solutionAllChars("(5+6[9-1]{2})>"));//0
        System.out.println(solutionAllChars("5(5+6[9-1]{2})"));//1
        System.out.println(solutionAllChars("(5+6[9-1]{2])"));//0
        System.out.println(solutionAllChars("(5+6[9-1]{2)"));//0
    }

    public static int solutionAllChars(String S) {
        Stack<Character> expected = new Stack<>();
        for(char c: S.toCharArray()){
            switch(c){
                case '(': expected.push(')'); break;
                case '{': expected.push('}'); break;
                case '[': expected.push(']'); break;
                case '<': expected.push('>'); break;
                default:
                    if(!"(){}[]<>".contains(c+"")) break; //ignore all other characters
                    if(expected.isEmpty() // nothing opened
                            || c != expected.pop() // not expected closing
                    ) return 0;
            }
        }
        if(!expected.isEmpty()) return 0;
        return 1;
    }

}
