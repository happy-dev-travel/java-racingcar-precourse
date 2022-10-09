package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCars {

    private final Map<Car, DriveRecord> carRecord;

    private RacingCars(List<Car> cars) {
        carRecord = new HashMap<>();
        for (Car car : cars) {
            carRecord.put(car, new DriveRecord());
        }
    }

    public static RacingCars of(List<Car> cars) {
        return new RacingCars(cars);
    }

    public Integer getCarCount() {
        return this.carRecord.size();
    }
}
