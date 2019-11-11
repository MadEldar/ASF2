package labSession04;

public class Number {
    public int n = 1;
    public int n2;
    public boolean flag;

    public synchronized void findNextPrime() {
        flag = false;
        while (!flag) {
            n++;
            flag = true;
            for (int i = 2; i <= n/2; i++) {
                if (n % i == 0) {
                    flag = false;
                    break;
                }
            }
        }
        notify();
    }

    public synchronized void squareRoot() {
        if (n2 == n) {
            try {
                wait();
            } catch (Exception e) {}
        }
        System.out.println(n*n);
        n2 = n;
    }
}
