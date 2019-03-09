import io.reactivex.Observable;

import static java.lang.Thread.sleep;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/61wtJkWlx7w
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * We've created Observable using two factory methods i.e., Observable.empty() and Observable.never()
 * <p>
 * Created By Mithu Roy on 03/03/2019
 */

public class Main {
    public static void main(String[] args) {
        createObservableUsingEmpty();
        createObservableUsingNever();
    }

    /**
     * Creates Observable using the factory method called empty()
     * Which doesn't emit any item to onNext() and only completes immediately
     * So, we get the callback on onComplete()
     */
    private static void createObservableUsingEmpty() {
        Observable observable = Observable.empty();
        observable.subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
    }

    /**
     * Creates Observable using the factory method called never()
     * Which doesn't emit any item and never completes
     * So, it's Observers are keep waiting until the thread is running
     * Observable.never() is primarily used for testing purposes
     */
    private static void createObservableUsingNever() {
        Observable observable = Observable.never();
        observable.subscribe(System.out::println, System.out::println, () -> System.out.println("Completed"));
        // Pause the main thread for the hope that it will print something
        pause(3000);
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
