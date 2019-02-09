/**
 * This is an example of illustration of the video series RxJava All In One.
 * <p>
 * You can watch the video implementation of this source code for free on YouTube here:
 * https://youtu.be/OyVIGm0O7yY
 * Subscribe here -> http://bit.ly/MithuRoyOnYoutube
 * <p>
 * In this class we've shown how easily you can get rid of anonymous inner class
 * using Lambdas and along with Method Reference the code looks much cleaner.
 * <p>
 * Created By Mithu Roy on 20/01/2019
 */

public class Main {

    public static void main(String[] args) {
        /*
         * Old School Implementation with anonymous inner class
         * Thread thread = new Thread(new Runnable() {
         *   @Override
         *  public void run() {
         *       runIt();
         *   }
         * });
         */

        // With Lambda and Method Reference
        Thread thread = new Thread(Main::runIt);
        thread.run();
    }

    private static void runIt() {
        System.out.println("Hello World");
    }
}
