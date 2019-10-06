package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            Product product = ProductFactory.of(item);
            product.doQualityUpdates();
            product.age();
            product.doOverAgedQualityUpdates();

            /*copy value */
            item.quality = product.getQuality();
            item.sellIn = product.getSellIn();
        }
    }
}