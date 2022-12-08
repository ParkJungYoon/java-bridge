package bridge.validator;

import bridge.MoveCommand;

public class CommandValidator {
    private final static String RETRY = "R";
    private final static String QUIT = "Q";
    private final static String INVALID_MOVE_COMMAND_ERROR_MESSAGE = "[ERROR] U또는 D로 이루어진 리스트여야합니다.";;
    private final static String INVALID_RETRY_COMMAND_ERROR_MESSAGE = "[ERROR] R또는 Q로 이루어진 리스트여야합니다.";;

    public static void validateMoveCommand(String input) {
        if (!input.equals(MoveCommand.TOP.getMoveCommand()) && !input.equals(MoveCommand.BOTTOM.getMoveCommand())) {
            throw new IllegalArgumentException(INVALID_MOVE_COMMAND_ERROR_MESSAGE);
        }
    }

    public static void validateRetryCommand(String input) {
        if (!input.equals(RETRY) && !input.equals(QUIT)) {
            throw new IllegalArgumentException(INVALID_RETRY_COMMAND_ERROR_MESSAGE);
        }
    }
}
