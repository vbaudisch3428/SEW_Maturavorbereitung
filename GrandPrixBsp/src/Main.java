
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Main-Klasse = Schiedsrichter
public class Main {
    private static final int NUM_RUNNERS = 3;
    private static final int NUM_ROUNDS = 3;

    public static void main(String[] args) throws InterruptedException {
        Verwaltung coordinator = new Verwaltung(NUM_RUNNERS);
        List<Laufer> laufer = new ArrayList<>();

        // Berechnungsaufgaben pro Läufer (jede Runde andere Aufgabe)
        List<Berechnung> tasks1 = List.of(
                new FibonacciBerechnung(44),
                new WurzelBerechnung(987654321.0, 250),
                new FibonacciBerechnung(40)
        );

        List<Berechnung> tasks2 = List.of(
                new FibonacciBerechnung(41),
                new FibonacciBerechnung(43),
                new WurzelBerechnung(888888888.0, 270)
                );

        List<Berechnung> tasks3 = List.of(
                new FibonacciBerechnung(43),
                new FibonacciBerechnung(42),
                new WurzelBerechnung(999999999.0, 230)
                );

        // Läufer erstellen
        laufer.add(new Laufer(1, tasks1, coordinator));
        laufer.add(new Laufer(2, tasks2, coordinator));
        laufer.add(new Laufer(3, tasks3, coordinator));

        // Läufer starten
        for (Laufer r : laufer) {
            r.start();
        }

        System.out.println("Die Läufer sind bereit...");
        Thread.sleep(1000); // kurze Pause für Realismus

        System.out.println("Start!");
        coordinator.sendStartSignal(); // Startsignal an alle

        Map<Integer, Integer> runnerRounds = new HashMap<>();
        Map<Integer, Long> finishTimes = new HashMap<>();
        int place = 1;

        int totalResults = NUM_RUNNERS * NUM_ROUNDS;

        for (int i = 0; i < totalResults; i++) {
            Runde result = coordinator.receiveRoundResult(); // Ergebnis holen

            runnerRounds.put(result.runnerId, result.round);

            // Ausgabe der Rundenzeiten
            System.out.printf("Thread %d hat Runde %d nach %dms abgeschlossen!%n",
                    result.runnerId, result.round, result.timeMs);

            // Platzierung nur bei letzter Runde
            if (result.round == NUM_ROUNDS && !finishTimes.containsKey(result.runnerId)) {
                System.out.printf("Thread %d hat Runde %d nach %dms abgeschlossen! Platz %d!%n",
                        result.runnerId, result.round, result.timeMs, place++);
                finishTimes.put(result.runnerId, System.currentTimeMillis());
            }
        }
    }
}
