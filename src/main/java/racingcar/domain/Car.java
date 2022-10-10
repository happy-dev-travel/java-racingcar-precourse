package racingcar.domain;

import racingcar.common.UserString;
import racingcar.constant.Move;
import racingcar.util.AccelGenerator;

public class Car {

    private final Engine engine;
    private final CarName carName;

    private Car(Engine engine, CarName carName) {
        this.engine = engine;
        this.carName = carName;
    }

    public static Car of(UserString carName) {
        return new Car(new Engine(), new CarName(carName));
    }

    public Move drive() {
        AccelValue value = AccelGenerator.generate();
        return this.engine.accel(value);
    }

    public CarName getCarName() {
        return this.carName;
    }
}
