package racingcar.controller;

import racingcar.common.ErrorMessage;
import racingcar.common.NaturalNumber;
import racingcar.common.UserString;
import racingcar.domain.RaceCars;
import racingcar.domain.RaceGarage;
import racingcar.view.BillBoard;

import java.util.Objects;

public class RaceManager {
    private static final String ERROR_USER_INPUT_WRONG_COUNT = "레이스 횟수는 0이상의 숫자를 입력해 주세요";
    private final UserInput userRequest;
    private final BillBoard billBoard;
    private final RaceGarage garage;
    private RaceCars racingCars;
    private NaturalNumber raceCount;

    public RaceManager(UserInput userRequest, BillBoard billBoard) {
        this.userRequest = userRequest;
        this.billBoard = billBoard;
        this.garage = new RaceGarage();
        this.racingCars = null;
        this.raceCount = null;
    }

    public RaceCars readyCars() {
        while (Objects.isNull(this.racingCars)) {
            this.billBoard.showRequestCarName();
            handleUserCarNames();
        }
        return this.racingCars;
    }

    private void handleUserCarNames() {
        try {
            UserString userCarNames = userRequest.getCarNames();
            this.racingCars = this.garage.createCars(userCarNames);
        } catch (IllegalArgumentException ex) {
            this.billBoard.showErrorMessage(ErrorMessage.of(ex.getMessage()));
        }
    }

    public NaturalNumber getRaceCount() {
        while (Objects.isNull(raceCount)) {
            this.billBoard.showRequestRaceCount();
            handleUserRaceCount();
        }
        return this.raceCount;
    }

    private void handleUserRaceCount() {
        try {
            UserString raceCount = userRequest.getRaceCount();
            this.raceCount = NaturalNumber.of(parseString(raceCount));
        } catch (IllegalArgumentException ex) {
            this.billBoard.showErrorMessage(ErrorMessage.of(ex.getMessage()));
        }
    }

    private int parseString(UserString input) {
        try {
            return Integer.parseInt(input.toString());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ERROR_USER_INPUT_WRONG_COUNT);
        }
    }
}
