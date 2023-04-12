package com.mselam.codility.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class FibBasics {
    private Map<Integer,Long> fibMap = new HashMap<>();
    private int lastMapped = 2;
    {
        fibMap.put(0, 0L);
        fibMap.put(1, 1L);
        fibMap.put(2, 1L);
    }

    public long kth(int k){

        for(int i = lastMapped+1; i <= k; i++){
            long fib = fibMap.get(i-1) + fibMap.get(i-2);
            fibMap.put(i,fib);
        }
        System.out.println(fibMap.values());
        lastMapped = k;
        return fibMap.get(k);
    }

    public static void main(String[] args) {
        FibBasics app = new FibBasics();
        System.out.println(app.kth(6));
        System.out.println(app.kth(5));
    }

}
