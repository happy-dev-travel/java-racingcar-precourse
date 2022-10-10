package racingcar.domain;

import racingcar.common.UserString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RaceGarage {
    private static final int MAX_CAR_COUNT = 20; //F1 2022시즌 출전 차량수 = 팀(10EA) * 2대 = 20대, https://namu.wiki/w/%ED%8F%AC%EB%AE%AC%EB%9F%AC%201

    public RaceCars createCars(UserString s) {
        UserString[] carNames = s.split();
        validate(carNames);
        return RaceCars.of(getCars(carNames));
    }

    private void validate(UserString[] carNames) {
        validateCarNameCount(carNames);
        validateDuplicateName(carNames);
    }

    private void validateDuplicateName(UserString[] carNames) {
        if (carNames.length != new HashSet<>(Arrays.asList(carNames)).size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarNameCount(UserString[] carNames) {
        if (carNames.length > MAX_CAR_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private List<Car> getCars(UserString[] userCarNames) {
        List<Car> cars = new ArrayList<>();
        for (UserString carName : userCarNames) {
            cars.add(Car.of(carName));
        }
        return cars;
    }
}
