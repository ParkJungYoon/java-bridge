package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

import static bridge.validator.NumberValidator.validateNonNumeric;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        OutputView.printBridgeLengthInputMessage();
        String input = Console.readLine();

        validateNonNumeric(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}