package racingcar.domain;

import racingcar.constant.Move;
import racingcar.util.AccelGenerator;

public class Car {

    private final Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public Move drive() {
        AccelValue value = AccelGenerator.generate();
        return this.engine.accel(value);
    }
}
