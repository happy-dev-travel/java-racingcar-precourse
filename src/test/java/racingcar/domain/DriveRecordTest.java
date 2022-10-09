package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.PositiveNumber;
import racingcar.constant.Move;

import static org.assertj.core.api.Assertions.assertThat;

class DriveRecordTest {

    @Test
    @DisplayName("정지하면 drive record 가 증가하지 않는다")
    void test2() {
        DriveRecord driveRecord = new DriveRecord(new CarName("test"));

        driveRecord.record(Move.FORWARD);
        driveRecord.record(Move.STOP);

        assertThat(driveRecord.isAt(PositiveNumber.of(1))).isTrue();
    }

    @Test
    @DisplayName("한번 이동하면 drive record 가 1 증가함")
    void test1() {
        DriveRecord driveRecord = new DriveRecord(new CarName("test"));

        driveRecord.record(Move.FORWARD);

        assertThat(driveRecord.isAt(PositiveNumber.of(1))).isTrue();
    }
}