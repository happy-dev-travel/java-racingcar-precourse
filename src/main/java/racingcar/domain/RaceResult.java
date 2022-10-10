package racingcar.domain;

import racingcar.common.NaturalNumber;

import java.util.*;

public class RaceResult implements Iterable<DriveRecord> {
    private final List<DriveRecord> records;

    public RaceResult(List<DriveRecord> records) {
        this.records = records;
    }

    public NaturalNumber getRecordSize() {
        return new NaturalNumber(records.size());
    }

    public List<DriveRecord> getWinner() {
        Collections.sort(records);
        Collections.reverse(records);
        NaturalNumber winnerPosition = getWinnerPosition();
        return filterWinners(winnerPosition);
    }

    private NaturalNumber getWinnerPosition() {
        final int winnerElementIndex = 0;
        return records.get(winnerElementIndex).getPosition();
    }

    private List<DriveRecord> filterWinners(NaturalNumber winnerPosition) {
        List<DriveRecord> winnerRecord = new ArrayList<>();
        for (DriveRecord record : records) {
            addWinners(winnerPosition, record, winnerRecord);
        }
        return winnerRecord;
    }

    private void addWinners(NaturalNumber winnerPosition, DriveRecord record, List<DriveRecord> winnerRecords) {
        if (record.isAt(winnerPosition)) {
            winnerRecords.add(record.copy());
        }
    }

    @Override
    public Iterator<DriveRecord> iterator() {
        return records.iterator();
    }
}
