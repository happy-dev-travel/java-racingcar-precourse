package racingcar.common;

public class PositiveNumber {
    private final int number;

    public PositiveNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static PositiveNumber of(int number) {
        return new PositiveNumber(number);
    }

    private void validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isSame(PositiveNumber number) {
        return this.get() == number.get();
    }

    public PositiveNumber plus(PositiveNumber number) {
        return new PositiveNumber(this.get() + number.get());
    }

    public int get() {
        return this.number;
    }
}
