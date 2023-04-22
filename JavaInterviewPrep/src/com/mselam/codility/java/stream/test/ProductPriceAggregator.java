package com.mselam.codility.java.stream.test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ProductPriceAggregator {

    private final List<SimpleProductPrice> list;
    private final BigDecimal totalPrice;

    public ProductPriceAggregator(List<SimpleProductPrice> list, BigDecimal totalPrice) {
        this.list = list;
        this.totalPrice = totalPrice;
    }

    public List<SimpleProductPrice> getList() {
        return list;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "ProductPriceAggregator{" +
                "list=" + list +
                ", totalPrice=" + totalPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPriceAggregator that = (ProductPriceAggregator) o;
        return list.equals(that.list) && totalPrice.equals(that.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list, totalPrice);
    }
}
