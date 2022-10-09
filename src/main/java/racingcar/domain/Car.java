package racingcar.domain;

import racingcar.constant.Move;
import racingcar.util.AccelGenerator;

public class Car {

    private final Engine engine;
    private final CarName carName;

    private Car(Engine engine, CarName carName) {
        this.engine = engine;
        this.carName = carName;
    }

    public static Car of(String carName) {
        return new Car(new Engine(), new CarName(carName));
    }

    public Move drive() {
        AccelValue value = AccelGenerator.generate();
        return this.engine.accel(value);
    }

    public String getCarName() {
        return this.carName.toString();
    }
}
