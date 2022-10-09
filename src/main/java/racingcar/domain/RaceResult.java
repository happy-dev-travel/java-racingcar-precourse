package racingcar.domain;

import racingcar.common.PositiveNumber;

import java.util.*;

public class RaceResult {
    private final List<DriveRecord> records;

    public RaceResult(List<DriveRecord> records) {
        this.records = records;
    }

    public PositiveNumber getRecordSize() {
        return new PositiveNumber(records.size());
    }

    public List<DriveRecord> getWinner() {
        Collections.sort(records);
        Collections.reverse(records);
        PositiveNumber winnerPosition = records.get(0).getPosition();
        return filterWinners(winnerPosition);
    }

    private List<DriveRecord> filterWinners(PositiveNumber winnerPosition) {
        List<DriveRecord> winnerRecord = new ArrayList<>();
        for (DriveRecord record : records) {
            addWinners(winnerPosition, record, winnerRecord);
        }
        return winnerRecord;
    }

    private void addWinners(PositiveNumber winnerPosition, DriveRecord record, List<DriveRecord> winnerRecords) {
        if (record.isAt(winnerPosition)) {
            winnerRecords.add(record.copy());
        }
    }
}
