package com.gildedrose;

import java.util.Arrays;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(item-> {
            Product product = ProductFactory.of(item);
            product.age();
            item.quality = product.getQuality();
            item.sellIn = product.getSellIn();
        });
    }
}