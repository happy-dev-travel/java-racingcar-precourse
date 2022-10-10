package racingcar.domain;

public class CarPosition {
    private static final String ERROR_POSITION_IS_WRONG = "position 값은 음수일 수 없습니다";
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
            throw new IllegalArgumentException(ERROR_POSITION_IS_WRONG);
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
