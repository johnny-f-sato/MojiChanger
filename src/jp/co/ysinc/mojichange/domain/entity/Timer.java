package jp.co.ysinc.mojichange.domain.entity;

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

    public static Timer newInstace(int duration) {
        if (timer == null) {
            timer = new Timer(duration);
        }

        return timer;
    }

    public void start(TimeUpHandler handler) {
        thread = new Thread(() -> {
            for (int i=0; i < duration; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println(i+1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            handler.timeUp();
        });

        thread.start();
    }

    public void join() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public interface TimeUpHandler {
        void timeUp();
    }

}
