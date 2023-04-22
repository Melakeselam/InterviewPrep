package com.mselam.codility.java.stream.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class EuroService {
    private Map<String, BigDecimal> rates = new HashMap<>();
    public EuroService(){
        rates.put("USD", BigDecimal.valueOf(1.23));
        rates.put("ETB", BigDecimal.valueOf(53.45));
        rates.put("YEN", BigDecimal.ZERO);
        rates.put("UKP", null);
    }

    public BigDecimal rate(String currency){
        return rates.get(currency);
    }
}
