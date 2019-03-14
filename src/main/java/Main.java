import io.reactivex.Observable;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/RnU9nGJcbfo
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * We've created Observable using Observable.defer()
 * Which Delegates the item generation just before it reaches to the onNext()
 * So that every Observers get a new instance, and stay updated with the new value
 * <p>
 * Created By Mithu Roy on 10/03/2019
 */

public class Main {
    private static int start = 5, count = 2;

    public static void main(String[] args) {
        // it prints from start up to (start + count - 1)
        Observable<Integer> observable = Observable.defer(() -> {
            System.out.println("New Observable is created with start = " + start + " and count = " + count);
            return Observable.range(start, count);
        });
        observable.subscribe(item -> System.out.println("Observer 1: " + item));
        count = 3;
        observable.subscribe(item -> System.out.println("Observer 2: " + item));
    }
}
