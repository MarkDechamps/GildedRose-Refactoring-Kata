package com.gildedrose;

import static com.gildedrose.ProductType.SULFURAS;

public class Product {
    private final String name;
    private final int sellIn;
    private final int quality;
    private final ProductType type;

    public Product(String name, int sellIn, int quality, ProductType type) {

        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.type = type;
    }

    public boolean is(ProductType type) {
        return this.type.equals(type);
    }

    public boolean qualityCanChange() {
        return is(SULFURAS);
    }
}
