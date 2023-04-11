package com.mselam.codility.stackandqueues;

import java.util.Stack;

public class StoneWall {

    private Stack<Integer> blocks = new Stack<>();

    private int currHeight(){
        return !blocks.isEmpty()? blocks.peek():0;
    }
    public int solution(int[] H){
        int count = 0;

        for(int h:H){
            while( currHeight() > h ){
                blocks.pop();
                count++;
            }

            if(currHeight() == h){
                continue;
            }
            blocks.push(h);
        }
        count += blocks.size();
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new StoneWall().solution(new int[]{8,8,5,7,9,8,7,4,8}));
    }
}
