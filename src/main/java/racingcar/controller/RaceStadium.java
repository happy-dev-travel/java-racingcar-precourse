package racingcar.controller;

import racingcar.common.NaturalNumber;
import racingcar.domain.RaceCars;
import racingcar.view.BillBoard;

public class RaceStadium {
    private final RaceManager raceManager;
    private final BillBoard billBoard;

    public RaceStadium(UserInput userInput, BillBoard billBoard) {
        this.raceManager = new RaceManager(userInput);
        this.billBoard = billBoard;
    }

    public void go() {
        RaceCars raceCars = raceManager.readyCars();
        NaturalNumber raceCount = raceManager.getRaceCount();
        Race race = new Race(billBoard, raceCars, raceCount);
        race.run();
    }
}
