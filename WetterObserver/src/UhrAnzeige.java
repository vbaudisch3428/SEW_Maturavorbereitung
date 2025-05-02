public class UhrAnzeige implements Observer {
    @Override
    public void update(int temperatur) {
        System.out.println("Uhr zeigt neue Temperatur: " + temperatur + "°C");
    }
}
