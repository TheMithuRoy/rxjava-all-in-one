import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/uaAcSxXjxrw
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * We've created the Observer interface so we can pass it to the subscribe method
 * and do the required task on onNext(), onError() and onComplete() overridden method
 * onNext() method emits the item available on the Observable source, one by one
 * onError() method throws an error if something goes wrong while the emission
 * onComplete() method let us know if the emission ends
 * N.B. We don't get the onComplete() callback if we ever get to the onError()
 * <p>
 * Created By Mithu Roy on 16/02/2019
 */

public class Main {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5);

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                // We're going to discuss about onSubscribe() on upcoming episodes
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }
        };

        observable.subscribe(observer);
    }
}
