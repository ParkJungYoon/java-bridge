package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리 길이가 숫자가 아닌 경우에 대한 예외 처리")
    @CsvSource({"k","&&","f4j"})
    @ParameterizedTest
    void NonNumericBridgeLength(String string) {
        InputStream in = generateUserInput(string);
        System.setIn(in);

        assertThatThrownBy(() -> InputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}