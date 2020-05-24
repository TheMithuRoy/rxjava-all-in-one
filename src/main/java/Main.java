import io.reactivex.Observable;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/d-LV8ayemQ8
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * Here we're Using flatMap and flatMap with biFunction
 * <p>
 * Created By Mithu Roy on 03/05/2020
 */

public class Main {

    public static void main(String[] args) {
        exFlatMap();
        exFlatMapBiFunction();
    }

    /**
     * This uses the flatMap to return desired Observables to the downstream
     * based on upstream emissions it gets in the Function
     */
    private static void exFlatMap() {
        Observable<String> observable = Observable.just("foo", "bar", "jam");
        observable.flatMap((string) -> {
            if (string.equals("bar")) return Observable.empty();
            return Observable.fromArray(string.split(""));
        }).subscribe(System.out::println);
    }

    /**
     * This is similar to normal flatMap except the biFunction
     * which merge upstream emission with the emissions from the flatMap returned Observables from Function
     */
    private static void exFlatMapBiFunction() {
        Observable<String> observable = Observable.just("foo", "bar", "jam");
        observable.flatMap(string -> Observable.fromArray(string.split("")),
                (actual, second) -> actual + " " + second)
                .subscribe(System.out::println);
    }
}
