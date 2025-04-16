package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new MockInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName()).isEqualTo(expected.getName());
    }

    @Test
    void whenReplaceItemThenSuccess() {
        Tracker tracker = new Tracker();
        Item item = new Item("Original Item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId()), "Updated Item"};
        StartUI.replaceItem(new MockInput(answers), tracker);
        Item updated = tracker.findById(item.getId());
        assertThat(updated.getName()).isEqualTo("Updated Item");
    }

    @Test
    void whenReplaceItemWithInvalidIdThenFail() {
        Tracker tracker = new Tracker();
        Item item = new Item("Original Item");
        tracker.add(item);

        String[] answers = {"999", "Updated Item"};

        StartUI.replaceItem(new MockInput(answers), tracker);

        Item notUpdated = tracker.findById(item.getId());
        assertThat(notUpdated.getName()).isEqualTo("Original Item");
    }

    @Test
    void whenDeleteExistingItemThenSuccess() {
        Tracker tracker = new Tracker();
        Item item = new Item("Test Item");
        tracker.add(item);

        Input input = new MockInput(new String[]{String.valueOf(item.getId())});

        StartUI.deleteItem(input, tracker);

        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    void whenDeleteNonExistingItemThenFail() {
        Tracker tracker = new Tracker();

        Input input = new MockInput(new String[]{"999"});

        StartUI.deleteItem(input, tracker);

        assertThat(tracker.findAll()).isEmpty();
    }
}