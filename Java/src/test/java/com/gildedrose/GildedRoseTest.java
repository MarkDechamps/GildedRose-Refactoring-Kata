package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void the_name_doesnt_change() {
        Item item = new Item("foo", 0, 0);
        updateQualityFrom(item);
        assertEquals("the name doesn't change by update","foo",item.name);
    }

    private GildedRose createApp(Item item) {
        Item[] items = new Item[]{item};
        return new GildedRose(items);
    }

    @Test
    public void the_quality_cant_be_negative() {
        Item item = new Item("foo", 0, 0);
        GildedRose app = createApp(item);
        assertEquals(0, app.items[0].quality);
        app.updateQuality();
        assertEquals("the quality can't be negative",0,item.quality);
    }
    @Test
    public void sellin_days_can_be_negative() {
        Item item = new Item("foo", 0, 0);
        updateQualityFrom(item);
        assertEquals("sellin days can be negative",-1, item.sellIn);
    }

    private void updateQualityFrom(Item item) {
        GildedRose app = createApp(item);
        app.updateQuality();
    }


    @Test
    public void once_sell_date_is_past_quality_degrades_twice_as_fast(){
        Item pastSelldate = createItemPastSellDate();
        int expectedQuality = pastSelldate.quality - 2;
        updateQualityFrom(pastSelldate);
        assertEquals("once sell date is past quality degrades twice as fast",pastSelldate.quality,expectedQuality);
    }
    @Test
    public void if_sell_date_is_not_past_quality_degrades_by_one(){
        Item pastSelldate = createItem();
        int expectedQuality = pastSelldate.quality - 1;
        updateQualityFrom(pastSelldate);
        assertEquals("if sell date is not past, quality degrades by one",pastSelldate.quality,expectedQuality);
    }

    private Item createItem() {
        return new Item("tst",1,10);
    }

    private Item createItemPastSellDate() {
        return new Item("tst",0,10);
    }
}
