package com.gildedrose;

import static com.gildedrose.ProductType.AGED_BRIE;

public class AgedBrie extends Product {
    public AgedBrie(int sellIn, int quality) {
        super(sellIn, quality, AGED_BRIE);
    }

    @Override
    public boolean qualityIncreasesWithAge() {
        return true;
    }

    @Override
    protected void handleOverAge() {
        if (isOverAge()) {
            increaseQuality();
        }
    }
}
