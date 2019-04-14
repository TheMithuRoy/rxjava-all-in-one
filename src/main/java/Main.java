import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/k0KQCF3ImuQ
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * We've created Observable using Observable.interval()
 * This factory method is very different compare to our previous factories
 * As it works on a computation thread and emit based on specific interval
 * <p>
 * Created By Mithu Roy on 14/03/2019
 */

public class Main {

    public static void main(String[] args) {
        Observable observable = Observable.interval(1, TimeUnit.SECONDS);

        observable.subscribe(item -> System.out.println("Observer 1: " + item));

        pause(2000);

        observable.subscribe(item -> System.out.println("Observer 2: " + item));

        pause(3000);
    }

    /**
     * This method sleep the main thread for specified duration
     *
     * @param duration Sleep Duration in Milliseconds
     */
    private static void pause(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
