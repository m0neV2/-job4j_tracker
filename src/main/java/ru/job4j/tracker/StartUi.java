package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUi {

    public static void main(String[] args) {
        Item item = new Item();

        LocalDateTime created = item.getCreated();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String formattedDate = created.format(formatter);
        System.out.println(item);
        System.out.println("Текущее дата и время после форматирования: " + formattedDate);
    }
}