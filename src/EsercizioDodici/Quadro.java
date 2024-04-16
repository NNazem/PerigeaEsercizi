package EsercizioDodici;

public class Quadro extends OperaDarte{
    protected double altezza;
    protected double larghezza;

    public Quadro(String titolo, String artista, int altezza, int larghezza) {
        super(titolo, artista);
        this.altezza = altezza;
        this.larghezza = larghezza;
    }

    @Override
    public double printIngombro() {
        return altezza * larghezza;
    }
}
