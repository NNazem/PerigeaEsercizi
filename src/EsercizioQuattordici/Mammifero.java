package EsercizioQuattordici;

public class Mammifero extends Animale{
    public int periodoGestazione;

    public Mammifero(String alfanumerico, int età, int periodoGestazione){
        super(alfanumerico, età);
        this.periodoGestazione = periodoGestazione;
    }
}
