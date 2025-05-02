public class Produzent extends Thread {
    private final Lager lager;

    public Produzent(Lager lager) {
        this.lager = lager;
    }

    @Override
    public void run() {
        try {
            // Simuliere 5 Produktionsvorgänge
            for (int i = 0; i < 5; i++) {
                lager.produzieren(); // Versuch zu produzieren
                Thread.sleep(500); // kleine Pause (realistischere Abläufe)
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
