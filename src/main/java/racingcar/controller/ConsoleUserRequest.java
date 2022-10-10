package racingcar.controller;

import racingcar.common.NaturalNumber;
import racingcar.common.UserString;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleUserRequest implements UserRequest {
    @Override
    public UserString getCarNames() {
        return UserString.of(readLine());
    }

    @Override
    public UserString getRaceCount() {
        return UserString.of(readLine());
    }


}
