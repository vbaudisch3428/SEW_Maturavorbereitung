import java.util.Objects;

public class Person{
    private String title;
    private String autor;
    private int erscheinungsjahr;
    private double preis;

    public Person(String title, double preis, int erscheinungsjahr, String autor) {
        this.title = title;
        this.preis = preis;
        this.erscheinungsjahr = erscheinungsjahr;
        this.autor = autor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public void setErscheinungsjahr(int erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return erscheinungsjahr == person.erscheinungsjahr && Double.compare(preis, person.preis) == 0 && Objects.equals(title, person.title) && Objects.equals(autor, person.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, autor, erscheinungsjahr, preis);
    }
}
