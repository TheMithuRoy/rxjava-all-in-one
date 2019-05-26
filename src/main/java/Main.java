import io.reactivex.Observable;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/6IwEvHH_BRk
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * Here we've used defaultIfEmpty and switchIfEmpty to emit default value and switch Observable Sources respectively
 * <p>
 * Created By Mithu Roy on 19/05/2019
 */

public class Main {
    public static void main(String[] args) {
        useDefaultIfEmpty();
        useSwitchIfEmpty();
    }

    /**
     * Used defaultIfEmpty() operator so the observer will emit at least a default value
     * if the emission gets empty
     */
    private static void useDefaultIfEmpty() {
        Observable.just(1,2,3,4,5)
                .filter(item -> item > 10)
                .defaultIfEmpty(100)
                .subscribe(System.out::println);
    }

    /**
     * This will switch to some alternative Observable Source
     * if the emission gets empty
     */
    private static void useSwitchIfEmpty() {
        Observable.just(1,2,3,4,5)
                .filter(item -> item > 10)
                .switchIfEmpty(Observable.just(6,7,8,9,10))
                .subscribe(System.out::println);
    }
}
