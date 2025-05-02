class StrategyDemo {
    public static void run() {
        Strategy add = new Add();
        Strategy mul = new Multiply();

        System.out.println("[Strategy] Add: 5 + 3 = " + add.execute(5, 3));
        System.out.println("[Strategy] Multiply: 5 * 3 = " + mul.execute(5, 3));
    }
}