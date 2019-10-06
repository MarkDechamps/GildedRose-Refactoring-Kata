package com.gildedrose;

import static com.gildedrose.ProductType.*;

public class Product {
    private static final int MAX_QUALITY = 50;

    private int sellIn;
    private int quality;
    private final ProductType type;

    public Product(int sellIn, int quality, ProductType type) {

        this.sellIn = sellIn;
        this.quality = quality;
        this.type = type;
    }

    public boolean is(ProductType type) {
        return this.type.equals(type);
    }

    public boolean qualityCanChange() {
        return !is(SULFURAS) && quality > 0;
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
        quality = 0;
    }

    public void increaseQuality() {
        if (quality < MAX_QUALITY) {
            quality = quality + 1;
        }
    }

    public boolean qualityIncreasesWithAge() {
        return false;
    }

    public void age() {
        sellIn = sellIn - 1;
        handleOverAge();

    }

    protected void handleOverAge() {
        if (isOverAge()) {
            if (!is(AGED_BRIE)) {
                if (!is(BACKSTAGE_PASSES)) {
                    decreaseQuality();
                } else {
                    nullifyQuality();
                }
            }
        }
    }

    public boolean isOverAge() {
        return sellIn < 0;
    }

    public boolean approachesHoldableLimit() {
        return sellIn < 11;
    }

    public boolean approachesHoldableLimitFast() {
        return sellIn < 6;
    }

    public int getSellIn() {
        return sellIn;
    }
}
