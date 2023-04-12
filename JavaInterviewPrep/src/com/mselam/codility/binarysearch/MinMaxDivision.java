package com.mselam.codility.binarysearch;

import java.util.concurrent.AbstractExecutorService;

public class MinMaxDivision {
    public int solution(int K, int M, int[] A){
        // search for a mid sum that will be able to split A into K blocks.
        int max = 0;
        int min = 0;
        for(int a:A){
            max += a; //sum of all elements put into one block
            min = Math.max(min,a);//largest single element for blocks w/ one element only.
        }
        int bestAnswer = max;
        while(min<=max){
            int mid = (min + max)/2;
            int blocks = checkBlocks(A,mid);
            if(blocks > K){ //mid is low, collect elements into smaller number of containers.
                min = mid+1; //mid as lower bound
            }else{
                max = mid - 1;
                if(mid < bestAnswer){
                    bestAnswer = mid;
                }
            }
        }
        return bestAnswer;
    }

    private int checkBlocks(int[] A, int guessMax) {
        int blocks = 1;
        int blockSum = 0;
        for(int a:A){
            blockSum += a;
            if(blockSum > guessMax){
                blocks++; // add more blocks
                blockSum = a; //shift 'a' to the next block
            }
        }
        return blocks;
    }

    public static void main(String[] args) {
        System.out.println(new MinMaxDivision().solution(3,5,new int[]{
                2,1,5,1,2,2,2
        }));
    }
}
