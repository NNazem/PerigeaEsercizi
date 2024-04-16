package EsercizioQuattordici;

public class Animale {
    public String alfanumerico;
    public int età;

    public Animale(String alfanumerico, int età) {
        this.alfanumerico = alfanumerico;
        this.età = età;
    }

    public String getAlfanumerico() {
        return alfanumerico;
    }

    public int getEtà(){
        return età;
    }
}
