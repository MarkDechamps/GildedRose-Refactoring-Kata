package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void theNameIsPreserved() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    public void once_sell_date_is_past_quality_degrades_twice_as_fast(){
        Item pastSelldate = createItemPastSellDate();
        int expectedQuality = pastSelldate.quality - 2;
        Item[] items = new Item[] { pastSelldate };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(pastSelldate.quality,expectedQuality);
    }
    @Test
    public void if_sell_date_is_not_past_quality_degrades_by_one(){
        Item pastSelldate = createItem();
        int expectedQuality = pastSelldate.quality - 1;
        Item[] items = new Item[] { pastSelldate };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(pastSelldate.quality,expectedQuality);
    }

    private Item createItem() {
        return new Item("tst",1,10);
    }

    private Item createItemPastSellDate() {
        return new Item("tst",0,10);
    }
}
