package EsercizioDodici;

public class Scultura extends OperaDarte{
    protected double altezza;
    protected double larghezza;
    protected double profondità;

    public Scultura(String titolo, String artista, int altezza, int larghezza, int profondità){
        super(titolo, artista);
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.profondità = profondità;
    }
    @Override
    public double printIngombro() {
        return altezza * larghezza * profondità;
    }
}
