package racingcar.controller;

import racingcar.common.NaturalNumber;
import racingcar.common.UserString;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGarage;

import java.util.Objects;

public class RaceManager {
    private final UserInput userRequest;
    private final RacingGarage garage;
    private RacingCars racingCars;
    private NaturalNumber raceCount;

    public RaceManager(UserInput userRequest) {
        this.userRequest = userRequest;
        this.garage = new RacingGarage();
        this.racingCars = null;
        this.raceCount = null;
    }

    public RacingCars readyCars() {
        while (Objects.isNull(this.racingCars)) {
            handleUserCarNames();
        }
        return this.racingCars;
    }

    private void handleUserCarNames() {
        try {
            UserString userCarNames = userRequest.getCarNames();
            this.racingCars = this.garage.createCars(userCarNames);
        } catch (IllegalArgumentException ex) {
            //view에 exception 보여주기
        }
    }

    public NaturalNumber getRaceCount() {
        while (Objects.isNull(raceCount)) {
            handleUserRaceCount();
        }
        return this.raceCount;
    }

    private void handleUserRaceCount() {
        try {
            UserString raceCount = userRequest.getRaceCount();
            this.raceCount = NaturalNumber.of(parseString(raceCount));
        } catch (IllegalArgumentException ex) {
            //view 에 exception 보여주기
        }
    }

    private int parseString(UserString input) {
        try {
            return Integer.parseInt(input.toString());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }
    }
}
