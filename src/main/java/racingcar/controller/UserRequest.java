package racingcar.controller;

import racingcar.common.NaturalNumber;
import racingcar.common.UserString;

public interface UserRequest {
    UserString getCarNames();

    NaturalNumber getRaceCount();
}
