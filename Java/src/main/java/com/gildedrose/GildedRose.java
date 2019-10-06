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

            if (!product.is(AGED_BRIE) && !product.is(BACKSTAGE_PASSES)) {
                    product.decreaseQuality();
            } else {
                product.increaseQuality();

                if (product.is(BACKSTAGE_PASSES)) {
                    if (item.sellIn < 11) {
                        product.increaseQuality();
                    }

                    if (item.sellIn < 6) {
                        product.increaseQuality();
                    }
                }

            }

            if (!product.is(SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!product.is(AGED_BRIE)) {
                    if (!product.is(BACKSTAGE_PASSES)) {
                        product.decreaseQuality();
                    } else {
                        product.nullifyQuality();
                    }
                } else {
                    product.increaseQuality();
                }
            }
            /*copy value */
            item.quality = product.getQuality();
        }


    }

}