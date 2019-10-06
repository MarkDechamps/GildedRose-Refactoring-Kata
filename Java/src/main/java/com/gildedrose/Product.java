package com.gildedrose;

import static com.gildedrose.ProductType.SULFURAS;

public class Product {
    private static final int MAX_QUALITY = 50;

    private final String name;
    private final int sellIn;
    private int quality;
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
        return !is(SULFURAS) && quality>0;
    }

    public void decreaseQuality() {
        if (qualityCanChange()) {
            quality = quality - 1;
        }
    }

    public int getQuality() {
        return quality;
    }

    public void nullifyQuality() {
        quality=0;
    }

    public void increaseQuality() {
        if (quality < MAX_QUALITY) {
            quality = quality + 1;
        }
    }
}
