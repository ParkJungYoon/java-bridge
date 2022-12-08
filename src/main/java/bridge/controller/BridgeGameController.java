package bridge.controller;

import bridge.*;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.validator.CommandValidator.validateMoveCommand;
import static bridge.validator.CommandValidator.validateRetryCommand;
import static bridge.validator.NumberValidator.validateBrideOverSize;
import static bridge.validator.NumberValidator.validateNonNumeric;

public class BridgeGameController {
    private final static String RETRY = "R";
    private static Bridge correctBridge;

    public void startGame() {
        int size = initBridgeSize();
        initBridge(size);
        BridgeGame bridgeGame = new BridgeGame();
        boolean isSuccess = false;
        while (true) {
            isSuccess = oneRound(bridgeGame, size);
            if (isSuccess) break;
            if (!initRetryCommand()) break;
            bridgeGame.retry();
        }

        printFinalResult(bridgeGame, isSuccess);
    }

    private void printFinalResult(BridgeGame bridgeGame, boolean isSuccess) {
        OutputView.printResultMessage();
        OutputView.printMap(bridgeGame);
        OutputView.printResult(bridgeGame, isSuccess);
    }

    private boolean oneRound(BridgeGame bridgeGame, int size) {
        do {
            boolean moveSuccess = bridgeGame.move(correctBridge, initMoveCommand());
            OutputView.printMap(bridgeGame);
            if (!moveSuccess) return false;
        } while (!bridgeGame.success(size));

        return true;
    }

    private boolean initRetryCommand() {
        String retryCommand;
        try {
            retryCommand = InputView.readGameCommand();
            validateRetryCommand(retryCommand);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initRetryCommand();
        }
        return retryCommand.equals(RETRY);
    }

    private String initMoveCommand() {
        String moveCommand;
        try {
            moveCommand = InputView.readMoving();
            validateMoveCommand(moveCommand);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initMoveCommand();
        }
        return moveCommand;
    }

    private void initBridge(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        correctBridge = new Bridge(bridgeMaker.makeBridge(size));
    }

    private int initBridgeSize() {
        String size;
        try {
            size = InputView.readBridgeSize();
            validateNonNumeric(size);
            validateBrideOverSize(Integer.parseInt(size));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return initBridgeSize();
        }
        return Integer.parseInt(size);
    }
}
