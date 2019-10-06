package com.gildedrose;

import static com.gildedrose.ProductType.*;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            Product product = ProductFactory.of(item);

            if (!product.qualityIncreasesWithAge()) {
                product.decreaseQuality();
            } else {
                product.increaseQuality();
                if (product.is(BACKSTAGE_PASSES)) {
                    if (product.approachesHoldableLimit()) {
                        product.increaseQuality();
                    }

                    if (product.approachesHoldableLimitFast()) {
                        product.increaseQuality();
                    }
                }

            }
            product.age();

            /*copy value */
            item.quality = product.getQuality();
            item.sellIn = product.getSellIn();
        }


    }

}