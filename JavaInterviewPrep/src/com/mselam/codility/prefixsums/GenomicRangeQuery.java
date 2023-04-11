package com.mselam.codility.prefixsums;

import java.util.Arrays;

public class GenomicRangeQuery {

    /*
    * Task: perform multiple sub-range ( P[i] - Q[i] queries on a nucleotide sequence (S) to find
    *       the minimum impact value of each sub-range.
    * Approach:
    *   1. map separately the presence of each nucleotide of the type (leave the last as a default) by counting over
    *       the whole sequence.
    *       Add additional index of zero count at the beginning each counter to test the presence of the specific type
    *           at the start [index 1] of the sequence. This will shift the map 1 index to the right. To use this later
    *           for checking a specific sequence range [x1..y1], shift 'y1' once to the right. Actual sequence range
    *           being checked (P[i]..Q[i]) will be  P[i] = x1 + 1 && Q[i] = y1 on the map. This will make sure to
    *           check if the count of the nucleotide changed between P[i]-1 and P[i], the beginning of the test range.
    *       eg. CGACTCAAGCG
    *           A -> [0,0,1,1,1,1,2,3,3,3,3]
    *           C -> [1,1,1,2,2,3,3,3,3,4,4]
    *           G -> [0,1,1,1,1,1,1,1,2,2,3]
    *   2. Execute the sub-range queries, making decision based on the criteria by checking if there were any changes
    *       between the starting index and ending index of each map of the nucleotide type. Here the criteria for the
    *       minimum impact is type 'A' then type 'C' then type 'G' else type 'T'. Store it in the result array for
    *       each query index.
    *   3. return the query result array.
    * */
    public static int[] solution(String S, int[] P, int[] Q){

        //1. setup counter map
        int[][] countMap = new int[3][S.length()+1]; //index 0 will be left with 0 value for all
        int aCounter = 0;
        int cCounter = 0;
        int gCounter = 0;
        int i = 1; // skip index 0
        for(char n: S.toCharArray()){
            switch(n){
                case 'A': aCounter++; break;
                case 'C': cCounter++; break;
                case 'G': gCounter++; break;
                default:break;
            }
            //map by priority, a being highest -> index = 0;
            countMap[0][i] =aCounter;
            countMap[1][i] =cCounter;
            countMap[2][i] =gCounter;
            i++;
        }

        int[] result = new int[P.length]; //query set result

        //2. execute querys
        for(int k = 0; k < result.length; k++ ){
            //indices to use on the countMap
            int start = P[k];
            int end = Q[k]+1;

            int minImpactFactor = 4; // if none of the other types are found, we assume the default type 'T' = 4

            //decide based on criteria
            for(int j = 0; j < 3; j++){
                if(countMap[j][start] != countMap[j][end]) { //means counter increased for the type
                    minImpactFactor = j + 1; // impact: A=1,C=2,G=3
                    break;
                }
            }
            result[k] = minImpactFactor;
        }

        //3. return
        return result;
    }

    public static void main(String[] args) {
        String S = "CGACTCAAGCG";
        int[] P = new int[]{2,4,0,6};
        int[] Q = new int[]{4,4,S.length()-1,7};
        System.out.println(Arrays.toString(solution(S,P,Q)));
    }
}
