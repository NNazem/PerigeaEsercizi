package EsercizioQuattordici;

public class Pesce extends Animale{
    public int profondità;

    public Pesce (String alfanumerico, int età, int profondità){
        super(alfanumerico, età);
        this.profondità = profondità;
    }
}
