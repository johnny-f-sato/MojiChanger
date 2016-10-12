package jp.co.ysinc.mojichange.domain.tools;

import jp.co.ysinc.mojichange.domain.event.OnAlarmListener;
import jp.co.ysinc.mojichange.domain.tools.spec.Timer;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class GameTimer implements Timer {

    private static GameTimer timer;
    private final int duration;
    private Thread thread;

    private GameTimer(int duration) {
        this.duration = duration;
    }

    public static Timer newInstance(int duration) {
        if (timer == null) {
            timer = new GameTimer(duration);
        }

        return timer;
    }


    @Override
    public void start(OnAlarmListener listener) {
        thread = new Thread(() -> {
            for (int i=0; i < duration; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (listener != null) {
                listener.onRumble();
            }

            System.exit(0);
        });

        thread.start();
    }
}
