package com.gildedrose;

import static com.gildedrose.ProductType.BACKSTAGE_PASSES;

public class BackStagePasses extends Product {
    public BackStagePasses(int sellIn, int quality) {
        super(sellIn, quality, BACKSTAGE_PASSES);
    }

    @Override
    public boolean qualityIncreasesWithAge() {
        return true;
    }

    @Override
    protected void doOverAgeAction() {
        nullifyQuality();
    }

    @Override
    public void doIncreaseQualityUpdates() {
        super.doIncreaseQualityUpdates();
        if (approachesHoldableLimit()) {
            increaseQuality();
        }
        if (approachesHoldableLimitFast()) {
            increaseQuality();
        }
    }
}
