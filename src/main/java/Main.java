import io.reactivex.Observable;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/wrFvo7eNW6Q
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * We've started our RxJava Operator's series with map() and filter()
 * Here you can check how map() and filter() works individually
 * and also with each other by chaining multiple operators
 * <p>
 * Created By Mithu Roy on 28/04/2019
 */

public class Main {
    public static void main(String[] args) {
        mapOperator();
        mapOperatorReturnsDifferentData();
        filterOperator();
        combineMapAndFilter();
    }

    /**
     * Uses the map() operator to transform the value in between,
     * before it reaches to the Observer
     */
    private static void mapOperator() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        observable
                .map(item -> item * 2)
                .subscribe(System.out::println);
    }

    /**
     * Uses the map() operator to transform the value in between,
     * before it reaches to the Observer and here map() emit different data type and
     * Observer just needs to adjust with it or accept the same type of emission
     */
    private static void mapOperatorReturnsDifferentData() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        observable
                .map(item -> "Hello World!")
                .subscribe(System.out::println);
    }

    /**
     * Uses the filter() operator to filter out the value in between,
     * which doesn't meet the logic specified in filter,
     * and filter() may not emit no item if it no item match that criteria
     */
    private static void filterOperator() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        observable
                .filter(item -> item % 2 == 0)
                .subscribe(System.out::println);
    }

    /**
     * Combines the map() and filter() operator together
     * and as map() and filter() both are nothing but an Observable
     * and also works like an Observer, so we can chain them,
     * but the order of operation does matter here.
     * Here filter() will kicks in first and map() will work on the filtered emission,
     * and not the whole emission in general
     */
    private static void combineMapAndFilter() {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);
        observable
                .filter(item -> item % 2 == 0)
                .map(item -> item * 2)
                .subscribe(System.out::println);
    }
}
