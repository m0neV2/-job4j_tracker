package ru.job4j.tracker;

import java.util.Comparator;

public class ItemComparators {

    public static class AscByName implements Comparator<Item> {
        @Override
        public int compare(Item left, Item right) {
            return left.getName().compareTo(right.getName());
        }
    }

    public static class DescByName implements Comparator<Item> {
        @Override
        public int compare(Item left, Item right) {
            return right.getName().compareTo(left.getName());
        }
    }
}
