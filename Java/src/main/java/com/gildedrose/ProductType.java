package com.gildedrose;

import java.util.Arrays;

public enum ProductType {
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    DEXTERITY_VEST("+5 Dexterity Vest"),
    ELEXIR("Elixir of the Mongoose"),
    CONJURED_CAKE("Conjured Mana Cake");

    String name;

    ProductType(String name) {
        this.name = name;
    }

    public static ProductType withName(String name) {
        return Arrays.stream(values())
                .filter(t -> t.hasName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(name + " is not a valid product"));
    }

    private boolean hasName(String name) {
        return this.name.equals(name);
    }
}
