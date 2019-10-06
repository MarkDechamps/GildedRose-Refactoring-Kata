package com.gildedrose;

import static com.gildedrose.ProductType.*;

public class Sulfuras extends Product {
    public Sulfuras(int sellIn, int quality) {
        super(sellIn, quality, SULFURAS);
    }

    @Override
    public void age() {
        //Sulfuras doesn't age!
    }
}
