package racingcar.domain;

import racingcar.common.UserString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RaceGarage {
    private static final String ERROR_CAR_NAME_DUPLICATED = "중복된 자동차 이름이 존재합니다";
    private static final String ERROR_CAR_COUNT_IS_OVER_MAX_COUNT = "입력한 자동차 이름이 최대치를 넘었습니다:Max";
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
            throw new IllegalArgumentException(ERROR_CAR_NAME_DUPLICATED);
        }
    }

    private void validateCarNameCount(UserString[] carNames) {
        if (carNames.length > MAX_CAR_COUNT) {
            throw new IllegalArgumentException(String.format("%s%s", ERROR_CAR_COUNT_IS_OVER_MAX_COUNT, MAX_CAR_COUNT));
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
