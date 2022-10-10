package racingcar.common;

public class NaturalNumber {
    private final int number;

    public NaturalNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static NaturalNumber of(int number) {
        return new NaturalNumber(number);
    }

    private void validate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isSame(NaturalNumber number) {
        return this.get() == number.get();
    }

    public NaturalNumber plus(NaturalNumber number) {
        return new NaturalNumber(this.get() + number.get());
    }

    public int get() {
        return this.number;
    }
}
