import io.reactivex.Observable;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/WA3TdQEoKOo
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * Here we've 2 error handling operators to showcase some techniques to handle errors in RxJava
 * <p>
 * Created By Mithu Roy on 29/03/2020
 */

public class Main {

    public static void main(String[] args) {
        retryWithPredicate();
        exRetry();
        exRetryUntil();
    }

    /**
     * This retry block try to analyze the error and take decision based on the error whether to retry or not
     * based on our logic inside that block
     */
    private static void retryWithPredicate() {
        Observable.error(new IOException("This is an example error"))
                .retry(error -> {
                    if (error instanceof IOException) {
                        System.out.println("retrying");
                        return true;
                    } else return false;
                })
                .subscribe(
                        System.out::println,
                        error -> System.out.println("Subscribed Error: " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }

    /**
     * This retry takes the number and tries to retry subscribing and getting the data from the observable again
     */
    private static void exRetry() {
        Observable.error(new Exception("This is an example error"))
                .retry(3)
                .subscribe(
                        System.out::println,
                        error -> System.out.println("Subscribed Error: " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }

    /**
     * retryUntil depends on the boolean that we pass, it keeps retrying until we pass true based on the logic
     */
    private static void exRetryUntil() {
        AtomicInteger atomicInteger = new AtomicInteger();
        Observable.error(new Exception("This is an example error"))
                .doOnError(error -> {
                    System.out.println(atomicInteger.get());
                    atomicInteger.getAndIncrement();
                })
                .retryUntil(() -> {
                    System.out.println("Retrying");
                    return atomicInteger.get() >= 3;
                })
                .subscribe(
                        System.out::println,
                        error -> System.out.println("Subscribed Error: " + error.getMessage()),
                        () -> System.out.println("Completed"));
    }
}
