package bridge.view;

import bridge.BridgeGame;

import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final static String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final static String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private final static String INPUT_MOVE_COMMAND = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final static String INPUT_RETRY_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final static String RESULT_MESSAGE = "최종 게임 결과";
    private final static String GAME_SUCCESS_RESULT = "게임 성공 여부: %s";
    private final static String TRY_COUNT_RESULT = "총 시도한 횟수: %d";
    private final static String SUCCESS = "성공";
    private final static String FAIL = "실패";

    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printInputBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
    }

    public static void printInputMoveCommand() {
        System.out.println(INPUT_MOVE_COMMAND);
    }

    public static void printInputRetryCommand() {
        System.out.println(INPUT_RETRY_COMMAND);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(BridgeGame bridgeGame) {
        List<String> topBridge = bridgeGame.getCurrentTopBridge();
        List<String> bottomBridge = bridgeGame.getCurrentBottomBridge();
        System.out.println(changeMap(topBridge));
        System.out.println(changeMap(bottomBridge));
    }

    private static String changeMap(List<String> bridge) {
        StringJoiner sj = new StringJoiner(" | ", "[ ", " ]");
        for (String map : bridge) {
            sj.add(map);
        }
        return sj.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResult(BridgeGame bridgeGame, boolean isSuccess) {
        String result = FAIL;
        if (isSuccess) result = SUCCESS;

        System.out.printf((GAME_SUCCESS_RESULT) + "%n", result);
        System.out.printf((TRY_COUNT_RESULT) + "%n", bridgeGame.getTryCount());
    }

    public static void printErrorMessage(String e) {
        System.out.println(e);
    }

}
