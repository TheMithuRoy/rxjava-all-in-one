import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/U1yPKXqCNoA
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * We've started our RxJava Operator's series with map() and filter()
 * Here we've used take and skip operator and some variants of them to showcase
 * how they work and how skip is nothing but an opposite of take
 * <p>
 * Created By Mithu Roy on 05/05/2019
 */

public class Main {
    public static void main(String[] args) {
        takeOperator();
        takeWithInterval();
        takeWhileOperator();
        skipOperator();
        skipWhileOperator();
    }

    /**
     * Used take(2) here, which emits only first 2 items and then complete
     */
    private static void takeOperator() {
        Observable.just(1,2,3,4,5)
                .take(2)
                .subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
    }

    /**
     * Used take(2) but with interval here, which emits items for the specified time interval only
     */
    private static void takeWithInterval() {
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .take(2, TimeUnit.SECONDS)
                .subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));

        pause(5000);
    }

    /**
     * This takeWhile() is like combination of filter and take,
     * the only difference is filter goes through all the items to check if the logic is true
     * whereas takeWhile() keep emitting only some logic is true
     * and it completes once it gets logic as false
     */
    private static void takeWhileOperator() {
        Observable.just(1,2,3,4,5,1,2,3,4,5)
                .takeWhile(item -> item <= 3)
                .subscribe(System.out::println);
    }

    /**
     * skip(2) is just the opposite of take(2)
     * it will skip first values and emit remaining ones
     */
    private static void skipOperator() {
        Observable.just(1,2,3,4,5)
                .skip(2)
                .subscribe(System.out::println);
    }

    /**
     * skipWhile() is little is like combination of filter and skip,
     * the only difference is filter goes through all the items to check if the logic is true
     * whereas skipWhile() keep skipping items only if some logic true
     * and once the logic is false it emits remaining items without checking
     */
    private static void skipWhileOperator() {
        Observable.just(1,2,3,4,5,1,2,3,4,5)
                .skipWhile(item -> item <= 3)
                .subscribe(System.out::println);
    }

    /**
     * This method sleep the main thread for specified duration
     *
     * @param duration Sleep Duration in Milliseconds
     */
    private static void pause(int duration) {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
