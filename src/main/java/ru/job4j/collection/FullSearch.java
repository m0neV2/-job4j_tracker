package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {

    public Set<String> extractNumber(List<Task> tasks) {
        HashSet<String> unique = new HashSet<>();
        for (Task num : tasks) {
            unique.add(num.getNumber());
        }
        return unique;
    }
}