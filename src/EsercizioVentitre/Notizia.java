package EsercizioVentitre;

public class Notizia {

    public String testo;
    public int priorità;
    public Argomento argomento;
    public boolean isPositiva;

    public Notizia(String testo, int priorità, Argomento argomento, boolean isPositiva) {
        this.testo = testo;
        this.priorità  = priorità;
        this.argomento = argomento;
        this.isPositiva = isPositiva;
    }
}
