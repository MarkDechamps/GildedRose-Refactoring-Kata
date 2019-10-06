package com.gildedrose;

import org.junit.Test;

import java.util.stream.IntStream;

import static com.gildedrose.ProductType.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GildedRoseTest {

    private static final int MAX_QUALITY = 50;
    private final String NAME = DEXTERITY_VEST.name;

    @Test
    public void the_name_doesnt_change() {
        Item item = new Item(NAME, 0, 0);
        updateQualityFrom(item);
        assertEquals("the name doesn't change by update", NAME, item.name);
    }

    @Test
    public void the_quality_cant_be_negative() {
        Item item = new Item(NAME, 0, 0);
        GildedRose app = createApp(item);
        assertEquals(0, app.items[0].quality);
        app.updateQuality();
        assertEquals("the quality can't be negative", 0, item.quality);
    }

    @Test
    public void sellin_days_can_be_negative() {
        Item item = new Item(NAME, 0, 0);
        updateQualityFrom(item);
        assertEquals("sellin days can be negative", -1, item.sellIn);
    }

    private void updateQualityFrom(Item item) {
        GildedRose app = createApp(item);
        app.updateQuality();
    }


    @Test
    public void once_sell_date_is_past_quality_degrades_twice_as_fast() {
        Item pastSelldate = createItemPastSellDate();
        int expectedQuality = pastSelldate.quality - 2;
        updateQualityFrom(pastSelldate);
        assertEquals("once sell date is past quality degrades twice as fast", pastSelldate.quality, expectedQuality);
    }

    @Test
    public void if_sell_date_is_not_past_quality_degrades_by_one() {
        Item pastSelldate = createItem();
        int expectedQuality = pastSelldate.quality - 1;
        updateQualityFrom(pastSelldate);
        assertEquals("if sell date is not past, quality degrades by one", pastSelldate.quality, expectedQuality);
    }

    @Test
    public void brie_quality_gets_better_by_aging() {
        Item brie = createBrie();
        int before = brie.quality;
        updateQualityFrom(brie);
        assertTrue(brie.quality > before);
    }

    @Test
    public void quality_is_never_above_max() {
        Item brie = createBrie();
        brie.quality = MAX_QUALITY;
        int before = brie.quality;
        IntStream.range(0, 10).forEach(i -> updateQualityFrom(brie));
        assertEquals("Quality doesn't get above 50", before, brie.quality);
    }

    @Test
    public void sulfuras_never_changes_quality() {
        Item sulfuras = sulfuras();
        int before = sulfuras.quality;
        IntStream.range(0, 10).forEach(i -> updateQualityFrom(sulfuras));
        assertEquals("Quality doesn't change", before, sulfuras.quality);
    }

    @Test
    public void backstage_passes_increase_quality_by_2_between_10_and_5_days(){
        testBackstagePasses(10, 5, 2);
    }

    @Test
    public void backstage_passes_increase_quality_by_3_between_5_and_0_days(){
        testBackstagePasses(5, 0, 3);
    }
    @Test
    public void backstage_passes_quality_drops_to_0_when_sellinday_reaches_0(){
        Item backstage = backstagePass(0);
        assertTrue(backstage.quality>0);
        updateQualityFrom(backstage);
        assertEquals("After sellindays quality drops to 0",backstage.quality,0);
    }

    private void testBackstagePasses(int fromSellinDays, int toSellinDays, int qualityIncreasesBy) {
        Item backstage = backstagePass(fromSellinDays);
        while (backstage.sellIn > toSellinDays) {
            int before = backstage.quality;
            updateQualityFrom(backstage);
            assertEquals(before + qualityIncreasesBy, backstage.quality);
        }
    }


    private Item backstagePass(int sellInDays) {
        return new Item("Backstage passes to a TAFKAL80ETC concert",sellInDays,10);
    }


    private Item sulfuras() {
        return new Item("Sulfuras, Hand of Ragnaros",10,10);
    }


    private Item createBrie() {
        Item brie = createItem();
        brie.name = "Aged Brie";
        return brie;
    }


    private Item createItem() {
        return new Item(NAME, 1, 10);
    }

    private Item createItemPastSellDate() {
        return new Item(NAME, 0, 10);
    }

    private GildedRose createApp(Item item) {
        Item[] items = new Item[]{item};
        return new GildedRose(items);
    }
}
