package com.mselam.codility.java.stream.test;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private final long id;
    private final String name;
    private final BigDecimal price;
    private final String currency;

    public Product(long id, String name, BigDecimal price, String currency) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && name.equals(product.name) && price.equals(product.price) && currency.equals(product.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, currency);
    }
}
