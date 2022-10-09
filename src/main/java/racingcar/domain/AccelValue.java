package racingcar.domain;

import racingcar.constant.AccelRange;

public class AccelValue {

    private final int accel;

    private AccelValue(int accel) {
        this.accel = accel;
    }

    public static AccelValue of(Integer accel) {
        validate(accel);
        return new AccelValue(accel);
    }

    private static void validate(Integer accel) {
        isNull(accel);
        isInValidRange(accel);
    }

    private static void isInValidRange(Integer accel) {
        if (accel < AccelRange.MIN_ACCEL_VALUE || accel > AccelRange.MAX_ACCEL_VALUE) {
            throw new IllegalArgumentException();
        }
    }

    private static void isNull(Integer accel) {
        if (accel == null) {
            throw new IllegalArgumentException();
        }
    }

    public Integer get() {
        return accel;
    }
}
