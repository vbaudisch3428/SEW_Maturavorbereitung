public interface Subjekt {
    void registriereBeobachter(Beobachter b);
    void entferneBeobachter(Beobachter b);
    void benachrichtigeBeobachter(String aktion);
}
