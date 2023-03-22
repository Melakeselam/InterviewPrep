package com.mselam.java_interview.polymorphism;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<AnimalDo> performance = new ArrayList<>();
        for(int i = 1; i < 50; i ++){
            performance.add(getAnimalToPerform((int)(Math.random() * 3) + 1));
        }
        performance.stream().forEach(a -> randomAct(a));
    }

    private static void randomAct(AnimalDo a) {
        switch ((int)(Math.random() * 3) + 1){
            case 1: a.say(); break;
            case 2: a.sing(); break;
            default: a.move(); break;
        }
    }

    private static AnimalDo getAnimalToPerform(int v) {
        AnimalDo performer;
        switch (v){
            case 1: performer = new Cat(); break;
            case 2: performer = new Dog(); break;
            default: performer = new Horse(); break;
        }
        return performer;
    }


}
