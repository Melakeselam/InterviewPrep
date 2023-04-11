package com.mselam.codility.leader;
import java.util.Map;
import java.util.HashMap;
public class EquiLeader {
        public int solution(int[] A) {
            // find the dominator and its count over all
            // iterate over the list and check if the dominator is the leader on the left as well as on the right segment. if so count it as an equileader

            Map<Integer,Integer> counters = new HashMap<>();
            int dominator = Integer.MIN_VALUE;
            int dominatorCount = 0;
            for(int a: A){
                if(!counters.containsKey(a))
                    counters.put(a,1);
                else
                    counters.put(a,counters.get(a)+1);
                int count = counters.get(a);
                if(count >A.length/2){
                    dominator = a;
                    dominatorCount = count;
                }
            }

            int equiLeaders = 0;
            int leadersOnRightCount = dominatorCount;
            int leadersOnLeftCount = 0;
            int countRight = A.length;
            int countLeft = 0;
            System.out.println(dominator);
            System.out.println(dominatorCount);
            for(int i = 0; i < A.length; i++){
                if(A[i] == dominator){
                    leadersOnLeftCount++;
                    leadersOnRightCount--;
                }
                countLeft++;
                countRight--;
                if(leadersOnLeftCount > countLeft/2 && leadersOnRightCount>countRight/2)
                    equiLeaders++;
            }

            return equiLeaders;
        }

        public static void main(String[] args) {
            System.out.println(new EquiLeader().solution(new int[]{4, 3, 4, 4, 4, 2}));
        }
}
