package bridge.validator;

public class NumberValidator {
    private final static int MIN_RANGE = 3;
    private final static int MAX_RANGE = 20;
    private final static String NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자로만 이루어진 값을 입력해주세요.";
    private final static String OUT_RANGE_ERROR_MESSAGE = "[ERROR] 3부터 20 사이의 숫자여야 합니다.";


    public static void validateNonNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }

    public static void validateBrideOverSize(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException(OUT_RANGE_ERROR_MESSAGE);
        }
    }
}
