package racingcar.view;

import java.util.Iterator;
import java.util.List;

public class RacingCarViews implements Iterable<RacingCarView> {
    private final List<RacingCarView> views;

    private RacingCarViews(List<RacingCarView> views) {
        this.views = views;
    }

    public static RacingCarViews of(List<RacingCarView> views) {
        return new RacingCarViews(views);
    }

    @Override
    public Iterator<RacingCarView> iterator() {
        return views.iterator();
    }
}
