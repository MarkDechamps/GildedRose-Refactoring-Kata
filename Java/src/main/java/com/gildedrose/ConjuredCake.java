package com.gildedrose;

import static com.gildedrose.ProductType.*;

public class ConjuredCake extends Product {

  public ConjuredCake(int sellIn, int quality) {
    super(sellIn,quality, CONJURED_CAKE);
  }

  @Override
  protected void decreaseQuality() {
    super.decreaseQuality();
    super.decreaseQuality();
  }
}
