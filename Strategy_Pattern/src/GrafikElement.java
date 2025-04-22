public abstract class GrafikElement {
    protected ZeichenStrategie strategie;

    public void setStrategie(ZeichenStrategie strategie) {
        this.strategie = strategie;
    }

    public abstract void zeichnen();
}
