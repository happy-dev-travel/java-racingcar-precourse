package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.PositiveNumber;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RaceResultTest {

    @Test
    @DisplayName("공동 우승자가 함께 반환됨.")
    void test2() {

        List<DriveRecord> driveRecords = Arrays.asList(
                new DriveRecord(new CarName("car2"), new CarPosition(10)),
                new DriveRecord(new CarName("car3"), new CarPosition(1)),
                new DriveRecord(new CarName("car1"), new CarPosition(10))
        );

        RaceResult result = new RaceResult(driveRecords);

        List<DriveRecord> winners = result.getWinner();

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).isAt(PositiveNumber.of(10))).isTrue();
        assertThat(winners.get(0).hasName(CarName.of("car1")) || winners.get(0).hasName(CarName.of("car2"))).isTrue();
    }

    @Test
    @DisplayName("우승자가 1명일 때 한명의 결과만 반환됨")
    void test1() {

        List<DriveRecord> driveRecords = Arrays.asList(
                new DriveRecord(new CarName("car2"), new CarPosition(8)),
                new DriveRecord(new CarName("car3"), new CarPosition(1)),
                new DriveRecord(new CarName("car1"), new CarPosition(10))
        );

        RaceResult result = new RaceResult(driveRecords);

        List<DriveRecord> winners = result.getWinner();

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).isAt(PositiveNumber.of(10))).isTrue();
        assertThat(winners.get(0).hasName(CarName.of("car1"))).isTrue();
    }
}