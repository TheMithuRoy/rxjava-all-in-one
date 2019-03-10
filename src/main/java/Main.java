import io.reactivex.Observable;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/MoMb2CMR6nU
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * We've created Observable using Observable.range()
 * <p>
 * Created By Mithu Roy on 09/03/2019
 */

public class Main {
    public static void main(String[] args) {
//        Observable<Integer> observable = Observable.range(0, 10);
//        observable.subscribe(System.out::println);

        // it prints from start up to (start + count - 1)
        int start = 5, count = 2;
        Observable<Integer> observable = Observable.range(start, count);
        observable.subscribe(System.out::println);
    }
}
