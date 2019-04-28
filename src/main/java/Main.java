import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/X2bBIfqUnGk
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * We've shown how to deal with Disposables in various ways
 * <p>
 * Created By Mithu Roy on 14/04/2019
 */

public class Main {
    public static void main(String[] args) {
        handleDisposable();
        handleDisposableInObserver();
        handleDisposableOutsideObserver();
        compositeDisposable();
    }

    /**
     * Saves the returned disposable from the subscribe(),
     * and dispose it after 3000 milliseconds and pase the
     * thread for 3000 milliseconds more to check whether it emits or not
     */
    private static void handleDisposable() {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable = observable.subscribe(System.out::println);
        pause(3000);
        disposable.dispose();
        pause(3000);
    }

    /**
     * When we pass an Observer to the subscribe() method, it returns void.
     * So we need to get the Disposable from the overridden method onSubscribe,
     * so we can deal with it anywhere and any point in time
     */
    private static void handleDisposableInObserver() {
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        Observer<Integer> observer = new Observer<Integer>() {
            Disposable disposable;
            @Override
            public void onSubscribe(Disposable d) {
                disposable = d;
            }

            @Override
            public void onNext(Integer integer) {
                if (integer == 3) {
                    disposable.dispose();
                }
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);
    }

    /**
     * Used ResourceObserver here, to the disposable out of the subscribe
     * Instead of subscribe(), subscribeWith() has been used here
     * Which returns the Observer that we pass in
     * As ResourceObserver implements Disposable,
     * so we can deal with it like it is a Disposable
     */
    private static void handleDisposableOutsideObserver() {
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        ResourceObserver<Integer> observer = new ResourceObserver<Integer>() {

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        Disposable d = observable.subscribeWith(observer);
    }

    /**
     * Used CompositeDisposable and used it's add method
     * to add Disposables to the set of Disposables
     * by calling the dispose on CompositeDisposable instead of disposing each and everyone
     * We can even use the delete method to remove any disposable from the set of CompositeDisposable
     */
    private static void compositeDisposable() {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable1 = observable.subscribe(item -> System.out.println("Observer 1: " + item));
        Disposable disposable2 = observable.subscribe(item -> System.out.println("Observer 2: " + item));
        compositeDisposable.addAll(disposable1, disposable2);
        pause(3000);
        compositeDisposable.delete(disposable1);
        compositeDisposable.dispose();
        pause(3000);
    }

    /**
     * This method sleep the main thread for specified duration
     *
     * @param duration Sleep Duration in Milliseconds
     */
    private static void pause(int duration) {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
