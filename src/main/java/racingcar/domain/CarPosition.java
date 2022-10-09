package racingcar.domain;

public class CarPosition {
    private int position;

    public CarPosition() {
        this(0);
    }

    public CarPosition(int initialPosition) {
        validate(initialPosition);
        this.position = initialPosition;
    }

    private void validate(int initialPosition) {
        if (initialPosition < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static CarPosition of(int initialPosition) {
        return new CarPosition(initialPosition);
    }

    public void plus(CarPosition carPosition) {
        this.position += carPosition.getPosition();
    }

    public boolean isAt(CarPosition carPosition) {
        if (carPosition == null) {
            return false;
        }
        return this.position == carPosition.getPosition();
    }

    public int getPosition() {
        return this.position;
    }
}
