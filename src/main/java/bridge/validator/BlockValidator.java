package bridge.validator;

public class BlockValidator {
    private final static String INVALID_TYPE_ERROR_MESSAGE = "[ERROR] 이동할 칸은 U와 D로만 입력할 수 있습니다.";
    private final static String INVALID_RETRY_TYPE_ERROR_MESSAGE = "[ERROR] 게임 재시작 여부는 R과 Q로만 입력할 수 있습니다.";

    public static void validateInvalidType(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(INVALID_TYPE_ERROR_MESSAGE);
        }
    }

    public static void validateInvalidRetryType(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException(INVALID_RETRY_TYPE_ERROR_MESSAGE);
        }
    }
}
