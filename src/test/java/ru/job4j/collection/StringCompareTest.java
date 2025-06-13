package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCompareTest {
    @Test
    public void whenStringsAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenFirstCharDifferentThenResultDependsOnIt() {
        StringCompare compare = new StringCompare();
        int result = compare.compare("Abramov", "Ivanov");
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenLeftIsEmptyAndRightNotEmptyThenNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare("", "Ivanov");
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenRightIsEmptyAndLeftNotEmptyThenPositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare("Ivanov", "");
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenBothStringsEmptyThenZero() {
        StringCompare compare = new StringCompare();
        int result = compare.compare("", "");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void whenStringsDifferByCaseThenCheck() {
        StringCompare compare = new StringCompare();
        int result = compare.compare("ivanov", "Ivanov");
        // 'i' (105) > 'I' (73) в Unicode, значит >0
        assertThat(result).isGreaterThan(0);
    }
}