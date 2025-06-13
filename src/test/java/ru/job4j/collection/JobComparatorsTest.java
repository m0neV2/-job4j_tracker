package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class JobComparatorsTest {

    @Test
    void whenSortAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Refactor code", 3),
                new Job("Add feature", 2)
        );
        Collections.sort(jobs, new JobAscByName());

        List<Job> expected = Arrays.asList(
                new Job("Add feature", 2),
                new Job("Fix bug", 1),
                new Job("Refactor code", 3)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenSortDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Refactor code", 3),
                new Job("Add feature", 2)
        );
        Collections.sort(jobs, new JobDescByName());

        List<Job> expected = Arrays.asList(
                new Job("Refactor code", 3),
                new Job("Fix bug", 1),
                new Job("Add feature", 2)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenSortAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 5),
                new Job("Refactor code", 2),
                new Job("Add feature", 3)
        );
        Collections.sort(jobs, new JobAscByPriority());

        List<Job> expected = Arrays.asList(
                new Job("Refactor code", 2),
                new Job("Add feature", 3),
                new Job("Fix bug", 5)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenSortDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Refactor code", 9),
                new Job("Add feature", 3)
        );
        Collections.sort(jobs, new JobDescByPriority());

        List<Job> expected = Arrays.asList(
                new Job("Refactor code", 9),
                new Job("Add feature", 3),
                new Job("Fix bug", 1)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenSortDescByNameThenPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        Collections.sort(jobs, new JobDescByName()
                .thenComparing(new JobDescByPriority()));

        List<Job> expected = Arrays.asList(
                new Job("X task", 0),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("Fix bug", 1)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenSortAscByNameThenPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 4),
                new Job("Fix bug", 1),
                new Job("Add feature", 2),
                new Job("Fix bug", 2)
        );
        Collections.sort(jobs, new JobAscByName()
                .thenComparing(new JobAscByPriority()));

        List<Job> expected = Arrays.asList(
                new Job("Add feature", 2),
                new Job("Fix bug", 1),
                new Job("Fix bug", 2),
                new Job("Fix bug", 4)
        );
        assertThat(jobs).isEqualTo(expected);
    }
}

