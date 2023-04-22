package com.mselam.codility.practicetest;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {
    public int solution(int[] A) {
        Set<Integer> exist = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int a:A){
            exist.add(a);
            max = Math.max(max, a);
        }
        int minPos = max > 0?0:1;
        if(minPos == 0)
            for(int i = 1; i <= max; i++){
                if(!exist.contains(i)){
                    minPos = i;
                    break;
                }
            }
        if(minPos == 0) return max + 1;
        return minPos;
    }

    public static void main(String[] args) {
//        System.out.println(new Practice().solution(new int[]{1000000}));
        List<Integer> entryTimeHM = Stream.of("10:00".split(":")).map(t -> Integer.parseInt(t)).collect(Collectors.toList());
        List<Integer> exitTimeHM = Stream.of("10:00".split(":")).map(t -> Integer.parseInt(t)).collect(Collectors.toList());
        LocalTime entryTime = LocalTime.of(entryTimeHM.get(0),entryTimeHM.get(1));
        LocalTime exitTime = LocalTime.of(exitTimeHM.get(0),exitTimeHM.get(1));
        Duration stayDuration = Duration.between(entryTime,exitTime);
        long overHrs = Math.max(0L,stayDuration.toHoursPart() - 1L);
        long overMin = stayDuration.toMinutesPart();

        System.out.println(5 + (int)(overHrs * 4) + (stayDuration.toHoursPart()>0 && overMin > 0?4:0));
    }
}
