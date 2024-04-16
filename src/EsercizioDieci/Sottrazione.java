package EsercizioDieci;

public class Sottrazione extends OperazioneAbstract implements Operazione{
    @Override
    public int eseguiOperazione(int a, int b) {
        super.risultato = a - b;
        return super.risultato;
    }
}
