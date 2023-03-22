package com.mselam.java_interview.java8.functional_interface;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.format;

public class BuiltInFunctionalInterface {
    public static void main(String[] args) {
        Supplier<Integer> randomInt100 = () -> (int)(Math.random() * 100);
        IntStream.range(1,10).map((i) -> randomInt100.get()).forEach(System.out::println);

        BiConsumer<String,String> formalName = (first, last) -> System.out.println(format("%s, %s", last.toUpperCase(), first.substring(0,1).toUpperCase() + first.substring(1).toLowerCase()));
        formalName.accept("melakeselam","mengistu");

        Function<String,String> morseCode = (alphanumeric) -> IntStream.range(0,alphanumeric.length()).map(alphanumeric::charAt).mapToObj(c->convertToMorse((char)c)+" ").collect(Collectors.joining()); ;
        System.out.println(morseCode.apply("melakeselam moges mengistu"));

    }

    private static String convertToMorse(char alphanumeric) {
        String dash = "-";
        String dot = "*";
//        String dash = "\u2796";
//        String dot = "\u25CF";
        switch (alphanumeric){
            case 'a': return format("%s%s",dot,dash);
            case 'b': return format("%s%s%s%s",dash,dot,dot,dot);
            case 'c': return format("%s%s%s%s",dash,dot,dash,dot);
            case 'd': return format("%s%s%s",dash,dot,dot);
            case 'e': return format("%s",dot);
            case 'f': return format("%s%s%s%s",dot,dot,dash,dot);
            case 'g': return format("%s%s%s",dash,dash,dot);
            case 'h': return format("%s%s%s%s",dot,dot,dot,dot);
            case 'i': return format("%s%s",dot,dot);
            case 'j': return format("%s%s%s%s",dot,dash,dash,dash);
            case 'k': return format("%s%s%s",dash,dot,dash);
            case 'l': return format("%s%s%s%s",dot,dash,dot,dot);
            case 'm': return format("%s%s",dash,dash);
            case 'n': return format("%s%s",dash,dot);
            case 'o': return format("%s%s%s",dash,dash,dash);
            case 'p': return format("%s%s%s%s",dot,dash,dash,dot);
            case 'q': return format("%s%s%s%s",dash,dash,dot,dash);
            case 'r': return format("%s%s%s",dot,dash,dot);
            case 's': return format("%s%s%s",dot,dot,dot);
            case 't': return format("%s",dash);
            case 'u': return format("%s%s%s",dot,dot,dash);
            case 'v': return format("%s%s%s%s",dot,dot,dot,dash);
            case 'w': return format("%s%s%s",dot,dash,dash);
            case 'x': return format("%s%s%s%s",dash,dot,dot,dash);
            case 'y': return format("%s%s%s%s",dash,dot,dash,dash);
            case 'z': return format("%s%s%s%s",dash,dash,dot,dot);
            case '1': return format("%s%s%s%s%s",dot,dash,dash,dash,dash);
            case '2': return format("%s%s%s%s%s",dot,dot,dash,dash,dash);
            case '3': return format("%s%s%s%s%s",dot,dot,dot,dash,dash);
            case '4': return format("%s%s%s%s%s",dot,dot,dot,dot,dash);
            case '5': return format("%s%s%s%s%s",dot,dot,dot,dot,dot);
            case '6': return format("%s%s%s%s%s",dash,dot,dot,dot,dot);
            case '7': return format("%s%s%s%s%s",dash,dash,dot,dot,dot);
            case '8': return format("%s%s%s%s%s",dash,dash,dash,dot,dot);
            case '9': return format("%s%s%s%s%s",dash,dash,dash,dash,dot);
            case '0': return format("%s%s%s%s%s",dash,dash,dash,dash,dash);
            default: return " ";
        }
    }
}
