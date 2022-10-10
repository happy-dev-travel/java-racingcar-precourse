package racingcar.domain;

import racingcar.common.UserString;

public class CarName {
    private static final String ERROR_CAR_NAME_IS_WRONG = "자동차 이름은 1~5자를 입력할 수 있습니다";
    private static final int MAX_NAME_LENGTH = 5;
    private final UserString carName;

    public CarName(UserString carName) {
        validate(carName);
        this.carName = carName;
    }

    public static CarName of(UserString name) {
        return new CarName(name);
    }

    private void validate(UserString carName) {
        isOverMaxLength(carName);
    }

    private void isOverMaxLength(UserString carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_IS_WRONG);
        }
    }

    @Override
    public String toString() {
        return this.carName.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CarName)) {
            return false;
        }
        CarName obj1 = (CarName) obj;
        return this.toString().equals(obj1.toString());
    }
}
