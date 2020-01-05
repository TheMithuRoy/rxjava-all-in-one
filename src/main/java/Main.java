import io.reactivex.Observable;

import java.util.Comparator;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/jnxoOup1eY0
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * Here we've used sorted operator to sort the emission based on different criteria
 * <p>
 * Created By Mithu Roy on 02/06/2019
 */

public class Main {

    public static void main(String[] args) {
        useSorted();
        useSortedWithOwnComparator();
        useSortedOnNonComparator();
    }

    /**
     * This used sorted operator to sort the operator
     */
    private static void useSorted() {
        Observable.just(3, 5, 2, 4, 1)
                .sorted()
                .subscribe(System.out::println);
    }

    /**
     * This used sorted operator along with Comparators reverse function
     * to sort and reverse the emission
     */
    private static void useSortedWithOwnComparator() {
        Observable.just(3, 5, 2, 4, 1)
                .sorted(Comparator.reverseOrder())
                .subscribe(System.out::println);
    }

    /**
     * This used sorted operator along with Integer's compare function to
     * sort the emission based on their length
     */
    private static void useSortedOnNonComparator() {
        Observable.just("foo", "john", "bar")
                .sorted((first, second) -> Integer.compare(first.length(), second.length()))
                .subscribe(System.out::println);
    }

}
