class Runde {
    public final int runnerId;
    public final int round;
    public final long timeMs;

    public Runde(int runnerId, int round, long timeMs) {
        this.runnerId = runnerId;
        this.round = round;
        this.timeMs = timeMs;
    }
}