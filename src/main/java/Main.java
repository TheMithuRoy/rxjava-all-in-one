import io.reactivex.Observable;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/3s9yW5k9J1A
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * Here we've 2 Do/Action operators to show how we can handle callback after a stream or observable is done with
 * <p>
 * Created By Mithu Roy on 12/04/2020
 */

public class Main {

    public static void main(String[] args) {
        exDoFinally();
        exDoOnDispose();
    }

    /**
     * doFinally works after the observable is done or onComplete
     */
    private static void exDoFinally() {
        Observable.just(1, 2, 3, 4, 5)
                .doFinally(() -> System.out.println("doFinally: Completed"))
                .subscribe(System.out::println);
    }

    /**
     * doOnDispose only works if we can dispose the observable explicitly
     * before onComplete or onError
     */
    private static void exDoOnDispose() {
        Observable.just(1, 2, 3, 4, 5)
                .doOnDispose(() -> System.out.println("onDispose: Disposed"))
                .doOnSubscribe(disposable -> disposable.dispose())
                .subscribe(System.out::println);

    }
}
