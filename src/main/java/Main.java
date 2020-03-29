import io.reactivex.Observable;

import java.io.IOException;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/2MEOCo_zz1E
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * Here we've 4 error handling operators to showcase some techniques to handle errors in RxJava
 * <p>
 * Created By Mithu Roy on 08/02/2020
 */

public class Main {

    public static void main(String[] args) {
        exDoOnError();
        exOnErrorResumeNext();
        exOnErrorReturn();
        exOnErrorReturnItem();
    }

    /**
     * The error goes to the doOnError lambda on the chain first, so we can handle it
     */
    private static void exDoOnError() {
        Observable.error(new Exception("This is an example error"))
                .doOnError(error -> System.out.println("Error: " + error.getMessage()))
                .subscribe(
                        System.out::println,
                        error -> System.out.println("Subscribed Error: " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }

    /**
     * Whenever an error is found on the chain, it goes to the onErrorResumeNext
     * As this takes another Observable, the subscriber switch to that Observable
     * to skip the error
     */
    private static void exOnErrorResumeNext() {
        Observable.error(new Exception("This is an example error"))
                .onErrorResumeNext(Observable.just(1, 2, 3, 4, 5))
                .subscribe(
                        System.out::println,
                        error -> System.out.println("Subscribed Error: " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }

    /**
     * We can return specific values based on the error type
     * As when we get the error it goes to the onErrorReturn lambda
     */
    private static void exOnErrorReturn() {
        Observable.error(new Exception("This is an example error"))
                .onErrorReturn(error -> {
                    if (error instanceof IOException) return 0;
                    else throw new Exception("This is an exception");
                })
                .subscribe(
                        System.out::println,
                        error -> System.out.println("Subscribed Error: " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }

    /**
     * We can pass an alternative for the subscriber below the chain
     * Whenever error encounters it gives that specific alternative
     */
    private static void exOnErrorReturnItem() {
        Observable.error(new IOException("This is an example error"))
                .onErrorReturnItem(1)
                .subscribe(
                        System.out::println,
                        error -> System.out.println("Subscribed Error: " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }

}
