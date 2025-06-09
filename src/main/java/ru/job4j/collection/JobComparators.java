package ru.job4j.collection;

import java.util.Comparator;

public class JobComparators {
    public static class JobAscByName implements Comparator<Job> {
        @Override
        public int compare(Job left, Job right) {
            return left.getName().compareTo(right.getName());
        }
    }

    public static class JobAscByPriority implements Comparator<Job> {
        @Override
        public int compare(Job left, Job right) {
            return Integer.compare(left.getPriority(), right.getPriority());
        }
    }

    public static class JobDescByName implements Comparator<Job> {
        @Override
        public int compare(Job left, Job right) {
            return right.getName().compareTo(left.getName());
        }
    }

    public static class JobDescByPriority implements Comparator<Job> {
        @Override
        public int compare(Job left, Job right) {
            return Integer.compare(right.getPriority(), left.getPriority());
        }
    }
}
