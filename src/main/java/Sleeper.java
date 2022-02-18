public class Sleeper {
    static void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            // ignore
        }
    }
}
