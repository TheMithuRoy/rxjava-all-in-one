import io.reactivex.Observable;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/NkI9XVB8i-8
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * Here we're showing the difference between map and flatMap operators
 * <p>
 * Created By Mithu Roy on 24/05/2020
 */

public class Main {

    public static void main(String[] args) {
        exMap();
        exFlatMap();
        exMapWithObservable();
    }

    /**
     * This uses the map operators to change the emission in between before it reaches to it's subscriber
     */
    private static void exMap() {
        Observable<String> observable = Observable.just("foo", "bard", "james");
        observable
                .map(item -> item.toUpperCase())
                .subscribe(System.out::println);
    }

    /**
     * This uses the flatMap to merge returned observables based on the emission
     */
    private static void exFlatMap() {
        Observable<String> observable = Observable.just("foo", "bar", "jam");
        observable.flatMap(item -> Observable.fromArray(item.split("")))
                .subscribe(System.out::println);
    }

    /**
     * This uses map operators to convert the stream in between to Observables
     * and for obvious reasons the subscribers get the Observable object instead
     */
    private static void exMapWithObservable() {
        Observable<String> observable = Observable.just("foo", "bar", "jam");
        observable.map(item -> Observable.fromArray(item.split(""))).subscribe(System.out::println);
    }
}
