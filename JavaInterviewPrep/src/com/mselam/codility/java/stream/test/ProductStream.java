package com.mselam.codility.java.stream.test;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Stream;

public class ProductStream {
    private long nextId = 1L;
    private String randCurrency(){
        int rInt = (int)Math.ceil(Math.random() * 4);
        switch (rInt){
            case 1: return "USD";
            case 2: return "ETB";
            case 3: return "YEN";
            case 4: return "UKP";
            default: return "EURO";
        }
    }
    public Stream<Product> newStream(int size){
        return Stream
                .generate(() -> new Product(nextId,
                        String.format("Product%d",nextId++),
                        BigDecimal.valueOf(Math.random()*1000),
                        randCurrency()))
                .limit(size);
    }
}
