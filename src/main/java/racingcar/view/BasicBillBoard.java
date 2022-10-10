package racingcar.view;

public class BasicBillBoard implements BillBoard {
    private final UserOutput userOutput;

    public BasicBillBoard(UserOutput userOutput) {
        this.userOutput = userOutput;
    }

    @Override
    public void showRace(RaceCarViews currentView) {
        for (RaceCarView carView : currentView) {
            this.userOutput.show(carView.toString());
        }
        this.userOutput.show("");
    }

    @Override
    public void showWinner(WinnerRacingCarViews winnerViews) {
        this.userOutput.show(String.format("최종 우승자 : %s", winnerViews.getWinners()));
    }
}
