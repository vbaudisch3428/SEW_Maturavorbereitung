public class HandyAnzeige implements Observer {
    @Override
    public void update(int temperatur) {
        System.out.println("Handy zeigt neue Temperatur: " + temperatur + "°C");
    }
}
