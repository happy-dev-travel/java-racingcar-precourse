package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import racingcar.common.NaturalNumber;
import racingcar.common.UserString;
import racingcar.domain.RacingCars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class RaceManagerTest {

    @Mock
    private UserRequest userRequest;

    @InjectMocks
    private RaceManager raceManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("사용자는 자동차의 목록을 전달받아 자동차를 생성함.")
    void test1() {
        given(userRequest.getCarNames()).willReturn(UserString.of("car1,car2"));

        RacingCars cars = raceManager.readyCars();

        assertThat(cars.getCarCount().isSame(NaturalNumber.of(2))).isTrue();
    }
}