package com.mselam.codility.fibonacci;

import com.mselam.codility.timecomplexity.FrogJmp;

import java.util.*;

public class FibFrog {
    private List<Integer> fibs= new ArrayList();
    private List<Integer> positions = new ArrayList<>();
    private int[] A;
    private int target;
    {
        fibs.add(0);
        fibs.add(1);
    }
    public int soluton(int[] A){
        this.A = A;
        target = A.length;
        for(int i = 0; i < A.length; i++){
            int nextFib = fibs.get(i) + fibs.get(i+1);
            if(nextFib <= A.length+1)
                fibs.add(nextFib);
            else break;
        }

        positions.add(-1);
        int steps = 0;
        while(!positions.isEmpty()){
            steps++;
            if(makeJumps()){
                return steps;
            }
        }

        return -1;
    }

    private boolean makeJumps() {
        List<Integer> newPositions = new ArrayList<>();
        for(int position:positions){
            for(int i= fibs.size()-1; i>=2; i--){
                int fib = fibs.get(i);
                if(position + fib == target){
                    return true;
                }
                if(position + fib < target){
                    if(A[position + fib] == 1){
                        A[position + fib] = 0;
                        newPositions.add(position + fib);
                    }
                }
            }
        }
        positions = newPositions;
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(app.soluton(new int[]{1,0,1,1,0,0,0,1,0}));
        System.out.println(new FibFrog().soluton(new int[]{0,0,0,1,1,0,1,0,0,0,0}));
    }
}
