package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.validator.NumberValidator.validateBrideOverSize;
import static bridge.validator.NumberValidator.validateNonNumeric;

public class BridgeGameController {

    public int initBridgeSize() {
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
