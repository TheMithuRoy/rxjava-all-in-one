import io.reactivex.Observable;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/aWhhgVblLDU
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * We've created Observable using Observable.fromCallable()
 * Which Delegates the item generation just before it reaches to the onNext()
 * So that it doesn't throw exception
 * And instead you can get a callback on your onError()
 * <p>
 * Created By Mithu Roy on 14/03/2019
 */

public class Main {

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.fromCallable(() -> {
            System.out.println("Calling Method");
            return getNumber();
        });
        observable.subscribe(System.out::println,
                error -> System.out.println("An Exception Occurred" + error.getLocalizedMessage()));
    }

    /***
     * This method returns an expression which is an int
     * @return a dummy expression (int)
     */
    private static int getNumber() {
        System.out.println("Generating Value");
        return 1 / 0;
    }
}
