package EsercizioDodici;

public abstract class OperaDarte {
    protected String titolo;
    protected String artista;

    public OperaDarte(String titolo, String artista) {
        this.titolo = titolo;
        this.artista = artista;
    }

    public abstract double printIngombro();

    public boolean equals(Object o){
        if(o instanceof OperaDarte){
            OperaDarte op = (OperaDarte) o;
            return titolo.equals(op.titolo) && artista.equals(op.artista);
        }
        return false;
    }
}
