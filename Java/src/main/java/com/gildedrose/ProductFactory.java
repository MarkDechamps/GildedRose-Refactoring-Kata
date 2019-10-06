package com.gildedrose;

public class ProductFactory {

    public static Product of(Item item) {
        return new Product(item.name,item.sellIn,item.quality, toType(item.name));
    }

    private static ProductType toType(String name) {
        return ProductType.withName(name);
    }
}
