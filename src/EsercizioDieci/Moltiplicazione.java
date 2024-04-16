package EsercizioDieci;

public class Moltiplicazione extends OperazioneAbstract implements Operazione{
    @Override
    public int eseguiOperazione(int a, int b) {
        super.risultato = a * b;
        return risultato;
    }
}
