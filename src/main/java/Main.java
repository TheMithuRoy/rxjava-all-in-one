import io.reactivex.Observable;

/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/vjbTOReGZN4
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * Here we've used contains operator to check if an emission contains the specific item or not
 * <p>
 * Created By Mithu Roy on 08/02/2020
 */

public class Main {

    public static void main(String[] args) {
        containsWithPremitive();
        containsWithNonPremitive();
    }

    /**
     * contains operator checks if the number exist in the Observable emission
     * As soon as it gets the item it emits true or false otherwise
     */
    private static void containsWithPremitive() {
        Observable.just(1, 2, 3, 4, 5)
                .contains(3)
                .subscribe(System.out::println);
    }

    /**
     * contains operator checks if the specific object exist in the Observable emission
     * based on the Object's hashcode
     * As soon as it gets the item it emits true or false otherwise
     */
    private static void containsWithNonPremitive() {
        User user = new User("mroydroid");
        Observable.just(user)
                .contains(user)
                .subscribe(System.out::println);
    }

    /**
     * a static class for demonstration purpose
     */
    static class User {
        String name;

        User(String name) {
            this.name = name;
        }
    }

}
