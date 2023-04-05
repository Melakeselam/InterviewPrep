package com.mselam.codility;

public class ZeroGaps {
    public static void main(String[] args) {
        String s = Integer.toBinaryString(2147383647);
        int maxZeros = 0;
        int count = 0;
        char prev = '0';
        boolean beginCount = false;
        for(int i = 0; i < s.length(); i++){
            char bit = s.charAt(i);
            if(bit == '1' && prev == '0') {
                maxZeros = Math.max(maxZeros,count);
                count = 0;
            }else if(bit == '0')
                    count++;
            prev = bit;
        }
        System.out.println("max gap: " + maxZeros);
    }
}
