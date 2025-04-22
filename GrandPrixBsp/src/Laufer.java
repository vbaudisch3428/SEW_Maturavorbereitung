import java.util.List;

class Laufer extends Thread {
    private final int runnerId;
    private final List<Berechnung> tasks;
    private final Verwaltung coordinator;

    public Laufer(int runnerId, List<Berechnung> tasks, Verwaltung coordinator) {
        this.runnerId = runnerId;
        this.tasks = tasks;
        this.coordinator = coordinator;
    }

    public void run() {
        try {
            coordinator.awaitStart(); // Warten auf Startsignal

            for (int i = 0; i < tasks.size(); i++) {
                long start = System.currentTimeMillis();
                tasks.get(i).compute(); // Rechenaufgabe durchführen
                long end = System.currentTimeMillis();
                long duration = end - start;

                coordinator.sendRoundResult(new Runde(runnerId, i + 1, duration));
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}