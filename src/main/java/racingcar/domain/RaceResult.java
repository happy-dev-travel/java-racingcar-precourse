package racingcar.domain;

import racingcar.common.PositiveNumber;

import java.util.Collection;

public class RaceResult {
    private final Collection<DriveRecord> records;

    public RaceResult(Collection<DriveRecord> records) {
        this.records = records;
    }

    public PositiveNumber getRecordSize() {
        return new PositiveNumber(records.size());
    }
}
