package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingGarage {

    private static final String delimiter = ",";
    private static final int MAX_CAR_COUNT = 20; //F1 2022시즌 출전 차량수 = 팀(10EA) * 2대 = 20대, https://namu.wiki/w/%ED%8F%AC%EB%AE%AC%EB%9F%AC%201

    public RacingCars prepareCars(String s) {
        validate(s);
        String[] carNames = s.split(delimiter);
        validateCarNameCount(carNames);
        return RacingCars.of(getCars(carNames));
    }

    private void validate(String s) {
        if (StringUtils.isBlank(s)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarNameCount(String[] carNames) {
        if (carNames.length > MAX_CAR_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private List<Car> getCars(String[] userCarNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : userCarNames) {
            cars.add(Car.of(carName));
        }
        return cars;
    }
}
