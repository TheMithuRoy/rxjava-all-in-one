import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/Ih4CKI4e3sw
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * Here we're Using merge operator to merge Two or more or list of Observables
 * <p>
 * Created By Mithu Roy on 19/04/2020
 */

public class Main {

    public static void main(String[] args) {
        exMerge();
        exMergeArray();
        exMergeIterable();
        exMergeWith();
        exMergeInfinite();
    }

    /**
     * Uses the static merge function to merge Observables
     * This function can take at most 4 Observables
     */
    private static void exMerge() {
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);

        Observable.merge(sixToTen, oneToFive).subscribe(System.out::println);
    }

    /**
     * Uses the static mergeArray function to merge unlimited Observables, as it takes vararg
     */
    private static void exMergeArray() {
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);
        Observable<Integer> elevenToFifteen = Observable.just(11, 12, 13, 14, 15);
        Observable<Integer> sixteenToTwenty = Observable.just(16, 17, 18, 19, 20);
        Observable<Integer> twentyOneToTwentyFive = Observable.just(21, 22, 23, 24, 25);

        Observable.mergeArray(oneToFive, sixToTen, elevenToFifteen, sixteenToTwenty, twentyOneToTwentyFive)
                .subscribe(System.out::println);

    }

    /**
     *  Uses the static merge function to merge List of Observables
     */
    private static void exMergeIterable() {
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);
        Observable<Integer> elevenToFifteen = Observable.just(11, 12, 13, 14, 15);
        Observable<Integer> sixteenToTwenty = Observable.just(16, 17, 18, 19, 20);
        Observable<Integer> twentyOneToTwentyFive = Observable.just(21, 22, 23, 24, 25);
        List<Observable<Integer>> observableList =
                Arrays.asList(oneToFive, sixToTen, elevenToFifteen, sixteenToTwenty, twentyOneToTwentyFive);

        Observable.merge(observableList).subscribe(System.out::println);

    }

    /**
     * All Observables has the mergeWith function, to easily merge it with another Observable
     * We can't merge with more than one Observable in this case
     */
    private static void exMergeWith() {
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);

        oneToFive.mergeWith(sixToTen).subscribe(System.out::println);
    }

    /**
     * This shows an implementation of the merge function with infinite Observables
     * As interval emits data as given time
     */
    private static void exMergeInfinite() {
        Observable<String> infinite1 = Observable.interval(1, TimeUnit.SECONDS)
                .map(item -> "From infinite1: " + item);
        Observable<String> infinite2 = Observable.interval(2, TimeUnit.SECONDS)
                .map(item -> "From infinite2: " + item);


        infinite1.mergeWith(infinite2).subscribe(System.out::println);

        pause(6050);
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
