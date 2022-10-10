package racingcar.controller;

import racingcar.common.NaturalNumber;
import racingcar.domain.DriveRecord;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingResult;
import racingcar.view.BillBoard;
import racingcar.view.RacingCarView;
import racingcar.view.RacingCarViews;
import racingcar.view.WinnerRacingCarViews;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final BillBoard billBoard;
    private final RacingCars cars;
    private final NaturalNumber raceCount;
    private RacingResult result;

    public Race(BillBoard billBoard, RacingCars cars, NaturalNumber raceCount) {
        this.billBoard = billBoard;
        this.cars = cars;
        this.raceCount = raceCount;
    }

    public void run() {
        start();
        finish();
    }

    private void finish() {
        WinnerRacingCarViews winnerViews = transWinnerToView(result);
        this.billBoard.showWinner(winnerViews);
    }

    public void start() {
        for (int i = 0; i < raceCount.get(); i++) {
            cars.raceOneTime();
            result = cars.getDriveRecords();
            RacingCarViews currentView = transResultToView(result);
            this.billBoard.showRace(currentView);
        }
    }

    private WinnerRacingCarViews transWinnerToView(RacingResult result) {
        List<RacingCarView> views = new ArrayList<>();
        for (DriveRecord record : result) {
            views.add(RacingCarView.of(record.getName(), record.getPosition()));
        }
        return WinnerRacingCarViews.of(views);
    }

    private RacingCarViews transResultToView(RacingResult currentResult) {
        List<RacingCarView> views = new ArrayList<>();
        for (DriveRecord record : currentResult) {
            views.add(RacingCarView.of(record.getName(), record.getPosition()));
        }
        return RacingCarViews.of(views);
    }
}
