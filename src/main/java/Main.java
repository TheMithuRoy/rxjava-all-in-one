import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/x6djvacyri8
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * We've created Single, Maybe and Completable
 * All of them works almost like Observable but with some functionality removed
 * <p>
 * Created By Mithu Roy on 14/04/2019
 */

public class Main {
    public static void main(String[] args) {
        createSingle();
        createMaybe();
        createCompletable();
    }

    /**
     * Creates a single and emit data to it's Observer only once
     */
    private static void createSingle() {
        Single.just("Hello World").subscribe(System.out::println);
    }

    /**
     * Creates a Maybe and it may or may not emit data to it's Observers
     * <p>Maybe.empty() has been called here and this factory method doesn't emit, only completes</p>
     */
    private static void createMaybe() {
        Maybe.empty().subscribe(new MaybeObserver<Object>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Object o) {
                System.out.println(o);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("Done");

            }
        });
    }

    /**
     * Creates a Completable
     * <p>
     * Completable.fromSingle() factory method has been used here which takes a single
     * But it doesn't emit any item to it's Observers
     * </p>
     * <p>
     * Because CompletableObserver doesn't have any onNext() method
     * And it's works is limited to let it's Observers know that something has been completed
     * You may be using this sometime just to test some stuff
     * Otherwise, this is not used much often in production
     * </p>
     */
    private static void createCompletable() {
        Completable.fromSingle(Single.just("Hello World")).subscribe(() -> System.out.println("Done"));
    }
}
