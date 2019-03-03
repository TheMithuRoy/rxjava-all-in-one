import io.reactivex.Observable;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/bEti4Rqhbfw
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * We've created Observable using Observable.error()
 * This factory method only provides exception to their Observers
 * through the onError()
 * This is specifically helpful if we don't want to throw exception directly,
 * so we can handle it gracefully in the onError()
 * <p>
 * Created By Mithu Roy on 03/03/2019
 */

public class Main {
    public static void main(String[] args) {
        throwException();
        throwExceptionUsingCallable();
    }

    /**
     * This method uses Observable.error() to pass a new instance of exception directly
     * So their observers get the same exception instance everytime
     */
    private static void throwException() {
        Observable observable = Observable.error(new Exception("An Exception"));
        observable.subscribe(System.out::println, error -> System.out.println("Error 1: " + error.hashCode()));
        observable.subscribe(System.out::println, error -> System.out.println("Error 2: " + error.hashCode()));
    }

    /**
     * This method uses Observable.error() to pass a new Instance of Callable
     * which takes an Exception as it's return type through lambda
     * So their Observers gets a new instance of exception on onError() every time
     */
    private static void throwExceptionUsingCallable() {
        Observable observable = Observable.error(() -> {
            // We're printing this message to show that new instance gets created before
            // publishing the error to their Observers
            System.out.println("New Exception Created");
            return new Exception("An Exception");
        });
        observable.subscribe(System.out::println, error -> System.out.println("Error 1: " + error.hashCode()));
        observable.subscribe(System.out::println, error -> System.out.println("Error 2: " + error.hashCode()));
    }
}
