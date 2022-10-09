package racingcar.domain;

import racingcar.constant.Move;

public class Engine {
    private static final int MIN_FORWARD_ACCEL = 4;

    public Move accel(AccelValue accelValue) {
        if (accelValue.get() < MIN_FORWARD_ACCEL) {
            return Move.STOP;
        }
        if (accelValue.get() >= MIN_FORWARD_ACCEL) {
            return Move.FORWARD;
        }
        return Move.STOP;
    }
}
