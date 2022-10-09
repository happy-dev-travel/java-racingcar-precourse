package racingcar.domain;

import racingcar.constant.Move;

public class DriveRecord {
    private final CarName carName;
    private final CarPosition position;

    public DriveRecord(CarName carName) {
        this.carName = carName;
        this.position = new CarPosition();
    }

    public void record(Move move) {
        if (move.equals(Move.FORWARD)) {
            position.plus(CarPosition.of(1));
        }
    }

    public boolean isAt(CarPosition position) {
        return this.position.isAt(position);
    }
}
