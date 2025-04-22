public class Main {
    public static void main(String[] args) {
        GrafikElement kreis = new Kreis();
        GrafikElement rechteck = new Rechteck();

        GrafikGruppe gruppe = new GrafikGruppe();
        gruppe.hinzufuegen(kreis);
        gruppe.hinzufuegen(rechteck);

        GrafikGruppe hauptGruppe = new GrafikGruppe();
        hauptGruppe.hinzufuegen(gruppe);
        hauptGruppe.hinzufuegen(new Kreis());

        hauptGruppe.zeichnen();
    }
}
