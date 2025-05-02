public class Main {
    public static void main(String[] args) {
        WetterStation station = new WetterStation();
        HandyAnzeige handy = new HandyAnzeige();
        UhrAnzeige uhr = new UhrAnzeige();

        station.addObserver(handy);
        station.addObserver(uhr);
        station.setTemperatur(22);
        station.removeObserver(handy);
        station.setTemperatur(14);
    }
}
