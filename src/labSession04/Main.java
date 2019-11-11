package labSession04;

public class Main {
    public static void main(String[] args) {
        Number n = new Number();
        Runnable r1 = () -> {
            for (int i = 0; i < 25; i++) {
                n.findNextPrime();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        Runnable r2 = () -> {
            for (int i = 0; i < 25; i++) {
                n.squareRoot();
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();
        Thread t2 = new Thread(r2);
        t2.start();
    }
}
