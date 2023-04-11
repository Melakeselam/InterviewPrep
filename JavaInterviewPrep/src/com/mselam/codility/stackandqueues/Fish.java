package com.mselam.codility.stackandqueues;

import java.util.Stack;

public class Fish {
    public static int solution(int[] A, int[] B) {
        // upstream fish are not moving only downstream ones
        // B -> 0 1 never meat because they have passed each other
        // river moves to the right
        // larger one eats smaller on if they are adjacent to each other with direction 1 0
        // at least one fish
        // sizes are unique, 0 - 1000000000
        // eg: <4 6> 3> <2 <1 <5
        /*
        sU -> 4,2,1,5
        sD -> 6, 3,
        q -> 0,1,1,0,0,0
        l -> 0
        r -> 1

        2> 4> <3 5> not only the largest to the right matter here, also each larger fish affect the outcome
        approach would be:
        1. pick fish and check its direction
        2. if fish is downstream, add to stack,
        3. if fish is upstream peek from stack and match. If it is bigger pop from stack until it is killed or stack is empty. reduce fish count each time one dies.
        4. iterate over all the list
        5. return fish count
        */
        Stack<Integer> downstreamSizeStack = new Stack<>();

        int fishesCount = A.length;
        for(int i = 0; i < A.length; i++){
            if(B[i] == 1) downstreamSizeStack.push(A[i]);
            else while( !downstreamSizeStack.isEmpty()){
                if(A[i]<downstreamSizeStack.peek()){
                    fishesCount--;
                    break;
                }else{
                    downstreamSizeStack.pop();
                    fishesCount--;
                }
            }
        }

        return fishesCount;
    }

    public static void main(String[] args) {
        System.out.println(solution(
                new int[]{4,3,2,1,5},
                new int[]{0,1,0,0,0}
        ));
        System.out.println(solution(
                new int[]{4,6,3,2,1,5},
                new int[]{0,1,1,0,0,0}
        ));
        System.out.println(solution(
                new int[]{4},
                new int[]{0}
        ));
    }
}
