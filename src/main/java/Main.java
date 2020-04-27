import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/e5Y5EAFuLjw
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * Here we're Using zip, zipWith and zipIterable operator to merge the emission in the Zipper function
 * <p>
 * Created By Mithu Roy on 26/04/2020
 */

public class Main {

    public static void main(String[] args) {
        exZip();
        exZipWith();
        exZipIterable();
    }

    /**
     * Uses Zip operator to get the stream on the Zipper function
     */
    private static void exZip() {
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.range(6, 5);
        Observable<Integer> elevenToFifteen = Observable.fromIterable(Arrays.asList(11, 12, 13, 14, 15));

        Observable.zip(oneToFive, sixToTen, elevenToFifteen, (a, b, c) -> a + b + c)
                .subscribe(System.out::println);

    }

    /**
     * Uses ZipWith operator on the Observable to easily zip One Observable with another
     */
    private static void exZipWith() {
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.fromIterable(Arrays.asList(6, 7, 8, 9, 10));

        oneToFive.zipWith(sixToTen, Integer::sum)
                .subscribe(System.out::println);
    }

    /**
     * Uses zipIterable operator which takes List of Observables and provides the zipped emission in an array
     */
    private static void exZipIterable() {
        Observable<Integer> oneToFive = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> sixToTen = Observable.just(6, 7, 8, 9, 10);
        Observable<Integer> elevenToFifteen = Observable.just(11, 12, 13, 14, 15);

        List<Observable<Integer>> observables = Arrays.asList(
                oneToFive, sixToTen, elevenToFifteen
        );

        Observable.zipIterable(observables, Arrays::toString, true, 1)
                .subscribe(System.out::println);
    }
}
