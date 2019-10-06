package com.gildedrose;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class TexttestFixture {
    private static List<String> msgs;
    private final int days = 10;


    @Test
    public void goldenMaster(){
        msgs = new ArrayList<>();
        log("OMGHAI!");

        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            log("-------- day " + i + " --------");
            log("name, sellIn, quality");
            for (Item item : items) {
                log(item.toString());
            }
            log("");
            app.updateQuality();
        }

        assertWithGoldenMaster();
    }

    private static void assertWithGoldenMaster() {
        Path gm = Paths.get("src/test/goldenmaster.txt");
        try {
            List<String> lines = Files.readAllLines(gm);
            assertEquals(msgs.size(), lines.size());
            IntStream.range(0, msgs.size()).forEach(i -> {
                assertEquals(msgs.get(i), lines.get(i));

            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void log(String msg) {
        msgs.add(msg);
    }

}
