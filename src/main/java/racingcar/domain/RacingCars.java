package racingcar.domain;

import racingcar.common.NaturalNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCars {

    private final Map<Car, DriveRecord> carRecord;

    private RacingCars(List<Car> cars) {
        carRecord = new HashMap<>();
        for (Car car : cars) {
            carRecord.put(car, new DriveRecord(car.getCarName()));
        }
    }

    public static RacingCars of(List<Car> cars) {
        return new RacingCars(cars);
    }

    public NaturalNumber getCarCount() {
        return NaturalNumber.of(this.carRecord.size());
    }

    public void raceOneTime() {
        for (Map.Entry<Car, DriveRecord> entry : carRecord.entrySet()) {
            Car car = entry.getKey();
            DriveRecord driveRecord = entry.getValue();
            driveRecord.record(car.drive());
        }
    }

    public RacingResult getDriveRecords() {
        return new RacingResult(new ArrayList<>(this.carRecord.values()));
    }
}
