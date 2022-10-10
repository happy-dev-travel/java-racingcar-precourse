package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.NaturalNumber;
import racingcar.common.UserString;
import racingcar.constant.Move;

import static org.assertj.core.api.Assertions.assertThat;

class DriveRecordTest {

    private DriveRecord driveRecord;

    @BeforeEach
    void setUp() {
        driveRecord = new DriveRecord(new CarName(UserString.of("test")));
    }

    @Test
    @DisplayName("정지하면 drive record 가 증가하지 않는다")
    void test2() {
        driveRecord.record(Move.FORWARD);
        driveRecord.record(Move.STOP);

        assertThat(driveRecord.isAt(NaturalNumber.of(1))).isTrue();
    }

    @Test
    @DisplayName("한번 이동하면 drive record 가 1 증가함")
    void test1() {
        driveRecord.record(Move.FORWARD);

        assertThat(driveRecord.isAt(NaturalNumber.of(1))).isTrue();
    }
}