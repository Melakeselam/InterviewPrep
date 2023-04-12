package com.mselam.codility.binarysearch;

import java.util.Arrays;

public class Search {
    private static int find(int x, int[] A, int l, int r){
        if(l>r) return -1;
        int mid = (l + r ) /2;
        if(A[mid] == x) return mid;
        if(A[mid] < x) return find(x,A,mid+1,r);
        return find(x,A,l,mid-1);
    }
    public static int findSorted(int x, int[]A){
        Arrays.sort(A);
        if(A.length == 0) return -1;
        return find(x,A,0,A.length-1);
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,5,8,9};
        int index = findSorted(7,A);
        System.out.println("located @:"+index+", "+Arrays.toString(A));
    }
}
