package com.mselam.codility;

import java.sql.Array;
import java.util.*;
import java.util.stream.IntStream;

public class IncrementCounters {
    public static int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int maxValue = 0, allMaximizeTo = 0;
        int i = 0;
        for (int a : A) {
            if (a <= N) {
                counters[a - 1] = counters[a - 1] < allMaximizeTo ? allMaximizeTo + 1 : counters[a - 1] + 1;
                maxValue = Math.max(maxValue, counters[a - 1]);
            } else {
                allMaximizeTo = maxValue;
            }

//            System.out.println(String.format("%d: %s", i++, Arrays.toString(counters)));
        }
        for (int c = 0; c < counters.length; c++) {
            counters[c] = allMaximizeTo > counters[c] ? allMaximizeTo : counters[c];
        }


        return counters;
    }

    public static void main(String[] args) {
        int[] extLarge = new int[50];
        for (int i = 0; i < 50; i++) {
            double x = Math.random();
            if (x > 0.1 && x <= 0.2)
                extLarge[i] = 50 + (int) (10 * x);
            else
                extLarge[i] = (int) (Math.ceil(Math.random() * 50));
        }
        long t1 = System.currentTimeMillis();
        System.out.println(Arrays.toString(solution(5,new int[]{3,4,4,6,1,4,4})));
//        System.out.println(Arrays.toString(solution(50, extLarge)));
        long t2 = System.currentTimeMillis();
        System.out.println("time elapsed (sec) : " + (t2 - t1));
    }
}
