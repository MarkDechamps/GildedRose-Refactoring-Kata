package com.gildedrose;

import static com.gildedrose.ProductType.*;

public class BackStagePasses extends Product {
    public BackStagePasses(int sellIn, int quality) {
        super(sellIn,quality,BACKSTAGE_PASSES);
    }

    @Override
    public boolean qualityIncreasesWithAge() {
        return true;
    }
}
