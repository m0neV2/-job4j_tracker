package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("sadihsalahov7@gmail.com", "Sadih Salahov");
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("sadihsalahov7@gmail.com", "Aleksey Sobolev");
        map.put("para@yandex.ru", "Umagulov Michael");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " " + value);
        }
    }
}
