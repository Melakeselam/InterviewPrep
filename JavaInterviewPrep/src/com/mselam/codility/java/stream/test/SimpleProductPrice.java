package com.mselam.codility.java.stream.test;

import java.math.BigDecimal;
import java.util.Objects;

public class SimpleProductPrice {

    private final long id;
    private final BigDecimal price;

    public SimpleProductPrice(long id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "SimpleProductPrice{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleProductPrice that = (SimpleProductPrice) o;
        return id == that.id && price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price);
    }
}
