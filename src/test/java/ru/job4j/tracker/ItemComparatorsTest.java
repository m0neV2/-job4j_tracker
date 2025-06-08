package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemComparatorsTest {

    @Test
    void whenSortAscByName() {
        List<Item> items = Arrays.asList(
                new Item("Banana"),
                new Item("Apple"),
                new Item("Carrot")
        );

        List<Item> expected = Arrays.asList(
                new Item("Apple"),
                new Item("Banana"),
                new Item("Carrot")
        );

        Collections.sort(items, new ItemComparators.AscByName());

        assertEquals(expected, items);
    }

    @Test
    void whenSortDescByName() {
        List<Item> items = Arrays.asList(
                new Item("Banana"),
                new Item("Apple"),
                new Item("Carrot")
        );

        List<Item> expected = Arrays.asList(
                new Item("Carrot"),
                new Item("Banana"),
                new Item("Apple")
        );

        Collections.sort(items, new ItemComparators.DescByName());

        assertEquals(expected, items);
    }
}
