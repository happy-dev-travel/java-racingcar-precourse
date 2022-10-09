package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("CarName 이 공백이거나 비어있으면 IllegalArgumentException 발생")
    void test1(String name) {
        assertThatThrownBy(() -> new CarName(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("CarName 이 5글자 초과이면 IllegalArgumentException")
    void test2() {
        assertThatThrownBy(() -> new CarName("한글도사용가")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("CarName 을 조회할 수 있음")
    void test3() {
        CarName carName = new CarName("이름");

        assertThat(carName.toString()).isEqualTo("이름");
    }
}