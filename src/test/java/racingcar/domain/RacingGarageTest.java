package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RacingGarageTest {

    private RacingGarage garage;

    @BeforeEach
    void setUp() {
        garage = new RacingGarage();
    }

    @Test
    @DisplayName("자동차는 20대를 초과할 수 없음")
    void test6() {
        assertThatThrownBy(() -> garage.prepareCars("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("비어있는 문자열이 입력되면 IllegalArgumentException이 발생함")
    void test5(String value) {
        assertThatThrownBy(() -> garage.prepareCars(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("null 이 입력되면 IllegalArgumentException이 발생함")
    void test4() {
        assertThatThrownBy(() -> garage.prepareCars(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 하나일 때도 정상적으로 생성됨")
    void test3() {
        RacingCars car1 = garage.prepareCars("car1");

        assertThat(car1.getCarCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("이름 목록에 콤마가 아닌 구분자를 사용하면 IllegalArgumentException 이 발생함")
    void test2() {
        assertThatThrownBy(() -> garage.prepareCars("car1:car2:car3")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름의 목록을 입력받아 경주 자동차들의 일급컬렉션인 RacingCars를 반환")
    void test1() {
        RacingCars racingCars = garage.prepareCars("car1,car2,car3");

        assertThat(racingCars.getCarCount()).isEqualTo(3);
    }
}