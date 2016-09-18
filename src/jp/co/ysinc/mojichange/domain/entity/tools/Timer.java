package jp.co.ysinc.mojichange.domain.entity.tools;

/**
 * Created by Fumiya on 2016/04/02.
 */
public class Timer {

    private static Timer timer;
    private final int duration;
    private Thread thread;

    private Timer(int duration) {
        this.duration = duration;
    }

    public static Timer newInstance(int duration) {
        if (timer == null) {
            timer = new Timer(duration);
        }

        return timer;
    }

    public void start(TimerHandler handler) {
        thread = new Thread(() -> {
            for (int i=0; i < duration; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println();
            handler.timeUp();
        });

        thread.start();
    }

    public interface TimerHandler {
        void countDown();
        void timeUp();
    }

}
