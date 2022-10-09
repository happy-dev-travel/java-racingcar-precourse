package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import racingcar.constant.AccelRange;
import racingcar.constant.Move;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.of("test");
    }

    @Test
    @DisplayName("Car는 이름을 가질 수 있음")
    void name() {
        Car car = Car.of("차이름");

        assertThat(car.getCarName()).isEqualTo("차이름");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("accel이 4가 발생하면 Car는 FORWARD를 반환홤")
    void test1(int accel) {
        try (MockedStatic<Randoms> random = mockStatic(Randoms.class)) {
            given(Randoms.pickNumberInRange(AccelRange.MIN_ACCEL_VALUE, AccelRange.MAX_ACCEL_VALUE)).willReturn(accel);

            Move move = car.drive();

            assertThat(move).isEqualTo(Move.FORWARD);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("0~3 사이의 값을 입력받으면 Car는 STOP을 반환홤")
    void test2(int accel) {
        try (MockedStatic<Randoms> random = mockStatic(Randoms.class)) {
            given(Randoms.pickNumberInRange(AccelRange.MIN_ACCEL_VALUE, AccelRange.MAX_ACCEL_VALUE)).willReturn(accel);

            Move move = car.drive();

            assertThat(move).isEqualTo(Move.STOP);
        }
    }
}