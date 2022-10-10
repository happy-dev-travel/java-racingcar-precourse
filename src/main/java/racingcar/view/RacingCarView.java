package racingcar.view;

import racingcar.common.NaturalNumber;
import racingcar.common.UserString;

public class RacingCarView {

    private static final String raceMark = "-";
    private final UserString name;
    private final NaturalNumber position;

    private RacingCarView(UserString name, NaturalNumber position) {
        this.name = name;
        this.position = position;
    }

    public static RacingCarView of(UserString name, NaturalNumber position) {
        return new RacingCarView(name, position);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(position.get());
        for (int i = 0; i < this.position.get(); i++) {
            sb.append(raceMark);
        }
        return String.format("%s:%s", this.name, sb);
    }

    public String getName() {
        return this.name.toString();
    }
}
