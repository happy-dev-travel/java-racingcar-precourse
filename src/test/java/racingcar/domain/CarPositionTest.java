package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarPositionTest {

    @Test
    void plus() {
        CarPosition position = CarPosition.of(0);

        position.plus(CarPosition.of(2));

        assertThat(position.isAt(CarPosition.of(2))).isTrue();
    }

    @Test
    void test2() {
        assertThatThrownBy(() -> CarPosition.of(-1)).isInstanceOf(IllegalArgumentException.class);
    }
}