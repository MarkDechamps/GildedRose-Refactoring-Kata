package com.gildedrose;

public class ProductFactory {

    public static Product of(Item item) {
        ProductType type = toType(item.name);
        Product product;
        switch (type) {
            case AGED_BRIE:
                product = new AgedBrie(item.sellIn, item.quality);
                break;
            case BACKSTAGE_PASSES:
                product = new BackStagePasses(item.sellIn, item.quality);
                break;
            case SULFURAS:
                product = new Sulfuras(item.sellIn, item.quality);
                break;
            default:
                product = new Product(item.sellIn, item.quality, type);
                break;
        }
        return product;
    }

    private static ProductType toType(String name) {
        return ProductType.withName(name);
    }
}
