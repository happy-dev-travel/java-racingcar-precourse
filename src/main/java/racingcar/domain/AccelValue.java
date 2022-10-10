package racingcar.domain;

import racingcar.constant.AccelRange;

public class AccelValue {
    private static final String ERROR_ACCEL_IS_NOT_IN_RANGE = "accel 값이 설정 범위를 벗어났습니다";
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
            throw new IllegalArgumentException(getNotInRangeErrorMessage());
        }
    }

    private static String getNotInRangeErrorMessage() {
        return String.format("%s(%s~%s)", ERROR_ACCEL_IS_NOT_IN_RANGE, AccelRange.MIN_ACCEL_VALUE, AccelRange.MAX_ACCEL_VALUE);
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
