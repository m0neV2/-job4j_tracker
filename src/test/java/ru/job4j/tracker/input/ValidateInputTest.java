package ru.job4j.tracker.input;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"5"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(5);
    }

    @Test
    void whenMultipleValidInputs() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"3", "7", "9"}
        );
        ValidateInput input = new ValidateInput(output, in);

        int firstSelected = input.askInt("Enter menu:");
        assertThat(firstSelected).isEqualTo(3);

        int secondSelected = input.askInt("Enter menu:");
        assertThat(secondSelected).isEqualTo(7);

        int thirdSelected = input.askInt("Enter menu:");
        assertThat(thirdSelected).isEqualTo(9);
    }

    @Test
    void whenNegativeInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"-5"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-5);
    }
}
