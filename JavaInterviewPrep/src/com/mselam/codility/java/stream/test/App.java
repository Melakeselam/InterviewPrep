package com.mselam.codility.java.stream.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.isNull;

public class App {

    private final EuroService euroService;
    private static ProductStream productStream = new ProductStream();

    public App(){
        euroService = new EuroService();
    }
    public ProductPriceAggregator aggregateProducts(Stream<Product> products){
        AtomicReference<BigDecimal> total = new AtomicReference<>(BigDecimal.valueOf(0.0));
        List<Product> beforeFilter = new ArrayList<>();
        List<Product> afterFilter = new ArrayList<>();
        List<SimpleProductPrice> afterMap = products.filter(product -> {
            beforeFilter.add(product);
            BigDecimal rate = euroService.rate(product.getCurrency());
            if(isNull(rate) || rate.doubleValue() <= 0.0) return false;
            return true;
        }).map(p ->{
            afterFilter.add(p);
            total.set(total.get().add(p.getPrice()));
            return new SimpleProductPrice(p.getId(),p.getPrice().multiply(euroService.rate(p.getCurrency())));
        }).collect(Collectors.toList());

        System.out.println("before filter: "+beforeFilter);
        System.out.println("after filter: "+afterFilter);
        System.out.println("after map: "+afterMap);
        System.out.println("total price: "+total);
        return new ProductPriceAggregator(afterMap, total.get());
    }

    public static void main(String[] args) {
        App app = new App();

        System.out.println(app.aggregateProducts(productStream.newStream(100)));
    }
}
