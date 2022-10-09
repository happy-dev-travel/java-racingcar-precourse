package racingcar.domain;

import java.util.List;

public class RacingCars {

    private final List<Car> racingCars;

    private RacingCars(List<Car> cars) {
        this.racingCars = cars;
    }

    public static RacingCars of(List<Car> cars) {
        return new RacingCars(cars);
    }

    public Integer getCarCount() {
        return racingCars.size();
    }
}
