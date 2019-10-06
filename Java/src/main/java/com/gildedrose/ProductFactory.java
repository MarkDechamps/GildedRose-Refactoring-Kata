package com.gildedrose;

import static com.gildedrose.ProductType.AGED_BRIE;
import static com.gildedrose.ProductType.BACKSTAGE_PASSES;

public class ProductFactory {

    public static Product of(Item item) {
        ProductType type = toType(item.name);
        if(type==AGED_BRIE)
        {
            return new AgedBrie(item.sellIn,item.quality);
        }
        if(type==BACKSTAGE_PASSES){
            return new BackStagePasses(item.sellIn,item.quality);

        }

        return new Product(item.sellIn,item.quality, type);
    }

    private static ProductType toType(String name) {
        return ProductType.withName(name);
    }
}
