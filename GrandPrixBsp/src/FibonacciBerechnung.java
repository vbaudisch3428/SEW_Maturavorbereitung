class FibonacciBerechnung implements Berechnung {
    private final int n;

    public FibonacciBerechnung(int n) {
        this.n = n;
    }

    // Rekursive Fibonacci-Berechnung
    private long fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public void compute() {
        fib(n); // Keine Ausgabe, nur Berechnung
    }
}