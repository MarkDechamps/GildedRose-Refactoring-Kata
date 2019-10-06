package com.gildedrose;

import static com.gildedrose.ProductType.*;

public class Sulfuras extends Product {
    public Sulfuras(int sellIn) {
        super(sellIn, 80, SULFURAS);
    }

    @Override
    public void updateSellInDays() {
        //Sulfuras doesn't age!
    }

    @Override
    boolean qualityCanChange() {
        return false;
    }
}
