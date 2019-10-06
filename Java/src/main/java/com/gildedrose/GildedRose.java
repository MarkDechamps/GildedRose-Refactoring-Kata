package com.gildedrose;

import static com.gildedrose.ProductType.*;

class GildedRose {

    private static final int MAX_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            Product product = ProductFactory.of(item);

            if (!product.is(AGED_BRIE)
                    && !nameIs(product, BACKSTAGE_PASSES)) {
                if (item.quality > 0) {
                    if (!nameIs(product, SULFURAS)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < MAX_QUALITY) {
                    item.quality = item.quality + 1;

                    if (nameIs(product, BACKSTAGE_PASSES)) {
                        if (item.sellIn < 11) {
                            increaseQualityFrom(item);
                        }

                        if (item.sellIn < 6) {
                            increaseQualityFrom(item);
                        }
                    }
                }
            }

            if (!nameIs(product, SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!nameIs(product, AGED_BRIE)) {
                    if (!nameIs(product, BACKSTAGE_PASSES)) {
                        if (item.quality > 0) {
                            if (!nameIs(product, SULFURAS)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    increaseQualityFrom(item);
                }
            }
        }
    }

    private boolean nameIs(Product item, ProductType backstagePasses) {
        return item.is(backstagePasses);
    }

    private void increaseQualityFrom(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality = item.quality + 1;
        }
    }
}