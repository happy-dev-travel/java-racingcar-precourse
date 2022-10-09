package racingcar.domain;


import org.junit.platform.commons.util.StringUtils;

public class CarName {

    private final static int MAX_NAME_LENGTH = 5;
    private final String carName;

    public CarName(String carName) {
        validate(carName);
        this.carName = carName;
    }

    private void validate(String carName) {
        isBlank(carName);
        isOverMaxLength(carName);
    }

    private void isBlank(String carName) {
        if (StringUtils.isBlank(carName)) {
            throw new IllegalArgumentException();
        }
    }

    private void isOverMaxLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return this.carName;
    }
}