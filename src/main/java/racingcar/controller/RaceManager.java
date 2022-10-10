package racingcar.controller;

import racingcar.common.UserString;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGarage;

public class RaceManager {
    private UserRequest userRequest;
    private RacingGarage garage;

    public RaceManager(UserRequest userRequest) {
        this.userRequest = userRequest;
        this.garage = new RacingGarage();
    }

    public RacingCars readyCars() {
        try {
            UserString userCarNames = userRequest.getCarNames();
            return this.garage.createCars(userCarNames);
        } catch (IllegalArgumentException ex) {
            //view에 exception 보여주기
            return readyCars();
        }
    }
}
