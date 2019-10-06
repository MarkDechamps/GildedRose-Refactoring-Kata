package com.gildedrose;

import static com.gildedrose.ProductType.SULFURAS;

public class Product {
    private static final int MAX_QUALITY = 50;

    private int sellIn;
    private int quality;
    private final ProductType type;

    Product(int sellIn, int quality, ProductType type) {

        this.sellIn = sellIn;
        this.quality = quality;
        this.type = type;
    }

    boolean qualityCanChange() {
        return quality > 0;
    }

    private void decreaseQuality() {
        if (qualityCanChange()) {
            quality = quality - 1;
        }
    }

    int getQuality() {
        return quality;
    }

    void nullifyQuality() {
        quality = 0;
    }

    void increaseQuality() {
        if (quality < MAX_QUALITY) {
            quality = quality + 1;
        }
    }

    public boolean qualityIncreasesWithAge() {
        return false;
    }

    public void updateSellInDays() {
        sellIn = sellIn - 1;
    }

    private void doOverAgeQualityUpdates() {
        if (isOverAge()) {
            doOverAgeAction();
        }
    }

    protected void doOverAgeAction() {
        decreaseQuality();
    }

    private boolean isOverAge() {
        return sellIn < 0;
    }

    boolean approachesHoldableLimit() {
        return sellIn < 11;
    }

    boolean approachesHoldableLimitFast() {
        return sellIn < 6;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void doIncreaseQualityUpdates() {
        increaseQuality();
    }

    private void doQualityUpdates() {
        if (qualityIncreasesWithAge()) {
            doIncreaseQualityUpdates();
        } else {
            decreaseQuality();
        }
    }

    void age() {
        doQualityUpdates();
        updateSellInDays();
        doOverAgeQualityUpdates();
    }
}
