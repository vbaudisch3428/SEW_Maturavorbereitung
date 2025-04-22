class WurzelBerechnung implements Berechnung {
    private final double number;
    private final int iterations;

    public WurzelBerechnung(double number, int iterations) {
        this.number = number;
        this.iterations = iterations;
    }

    public void compute() {
        double x = number;
        for (int i = 0; i < iterations; i++) {
            x = 0.5 * (x + number / x);
        }
    }
}
