package racingcar.domain;

import racingcar.common.UserString;

public class CarName {

    private final static int MAX_NAME_LENGTH = 5;
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
            throw new IllegalArgumentException();
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
