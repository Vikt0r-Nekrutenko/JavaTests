public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int dif(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public double div(int a, int b) throws ArithmeticException {
        if (b == 0) throw new ArithmeticException();
        return a / b;
    }

    public int sqr(int a) {
        return a * a;
    }

    public double sqrt(int a) {
        return Math.sqrt(a);
    }
}
