package chap13;

public class RecursiveDemo {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(factorial(n));
        System.out.println(facotrial_int(n));
    }

    public static int factorial(int n) {
        if (n > 1) {
            return n * factorial(n - 1);
        } else
            return 1;
    }

    public static int facotrial_int(int n) {
        if (n > 1) {
            int result = 1;
            for (int i = n; i > 1; i++) {
                result = result * i;
            }
            return result;
        } else
            return 1;
    }

}