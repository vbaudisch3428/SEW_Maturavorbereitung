public class Konsument extends Thread {
    private final Lager lager;

    public Konsument(Lager lager) {
        this.lager = lager;
    }

    @Override
    public void run() {
        try {
            // Simuliere 5 Verbrauchsvorgänge
            for (int i = 0; i < 5; i++) {
                lager.konsumieren();           // Versuch zu konsumieren
                Thread.sleep(500);             // kleine Pause
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
