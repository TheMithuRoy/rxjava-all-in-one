import io.reactivex.Observable;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/8YxIGNJZbfo
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * Here we've 3 Do/Action operators to show how we can handle specific block stream, before it reaches
 * <p>
 * Created By Mithu Roy on 05/04/2020
 */

public class Main {

    public static void main(String[] args) {
        exDoOnSubscribe();
        exDoOnNext();
        exDoOnComplete();
    }

    /**
     * doOnSubscribe will get the disposable as soon as we subscribe the specific observable
     */
    private static void exDoOnSubscribe() {
        Observable.just(1, 2, 3, 4, 5)
                .doOnSubscribe(disposable -> System.out.println("doOnSubscribe: Subscribed"))
                .subscribe(System.out::println);
    }

    /**
     * doOnNext will get the item just before it reaches to the downstream of onNext
     */
    private static void exDoOnNext() {
        Observable.just(1, 2, 3, 4, 5)
                .doOnNext(item -> System.out.println("doOnNext: " + ++item))
                .subscribe(System.out::println);
    }

    /**
     * doOnComplete will get void just before it reaches to the downstream of onComplete
     */
    private static void exDoOnComplete() {
        Observable.just(1, 2, 3, 4, 5)
                .doOnComplete(() -> System.out.println("doOnComplete: Completed"))
                .subscribe(System.out::println, System.out::print, () -> System.out.println("Completed"));
    }
}
