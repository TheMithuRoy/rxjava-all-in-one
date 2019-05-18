import io.reactivex.Observable;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/M6aoMdjFmXI
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * Here we've used distinct and distinctUntilChanged and their two overloads
 * <p>
 * Created By Mithu Roy on 12/05/2019
 */

public class Main {
    public static void main(String[] args) {
        distinctOperator();
        distinctWithKeySelector();
        distinctUntilChangedOperator();
        distinctUntilChangedWithKeySelector();
    }

    /**
     * Used the distinct() to get the unique emission
     */
    private static void distinctOperator() {
        Observable.just(1, 1, 2, 2, 3, 3, 4, 5, 1, 2)
                .distinct()
                .subscribe(System.out::println);
    }

    /**
     * Used the distinct based on the item's property to distinguish emission
     */
    private static void distinctWithKeySelector() {
        Observable.just("foo", "fool", "super", "foss", "foil")
                .distinct(String::length)
                .subscribe(System.out::println);
    }

    /**
     * Used distinctUntilChanged() to avoid consecutive duplicate items one after another
     */
    private static void distinctUntilChangedOperator() {
        Observable.just(1, 1, 2, 2, 3, 3, 4, 5, 1, 2)
                .distinctUntilChanged()
                .subscribe(System.out::println);
    }

    /**
     * Used distinctUntilChangedOperator() based on the item's property to distinguish the consecutive duplicate items
     */
    private static void distinctUntilChangedWithKeySelector() {
        Observable.just("foo", "fool", "super", "foss", "foil")
                .distinctUntilChanged(String::length)
                .subscribe(System.out::println);
    }
}
