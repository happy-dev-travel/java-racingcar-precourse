package racingcar.domain;

import racingcar.common.NaturalNumber;
import racingcar.common.UserString;
import racingcar.constant.Move;

public class DriveRecord implements Comparable<DriveRecord> {
    private final CarName carName;
    private final CarPosition position;

    public DriveRecord(CarName carName) {
        this(carName, new CarPosition());
    }

    public DriveRecord(CarName carName, CarPosition position) {
        this.carName = carName;
        this.position = position;
    }

    public void record(Move move) {
        if (move.equals(Move.FORWARD)) {
            position.plus(CarPosition.of(1));
        }
    }

    public boolean isAt(NaturalNumber position) {
        return this.position.isAt(CarPosition.of(position.get()));
    }

    public NaturalNumber getPosition() {
        return new NaturalNumber(this.position.getPosition());
    }

    public UserString getName() {
        return UserString.of(carName.toString());
    }

    public boolean hasName(CarName car1) {
        return this.carName.equals(car1);
    }

    public DriveRecord copy() {
        return new DriveRecord(this.carName, CarPosition.of(this.position.getPosition()));
    }

    @Override
    public int compareTo(DriveRecord o) {
        return this.getPosition().get() - o.getPosition().get();
    }
}
