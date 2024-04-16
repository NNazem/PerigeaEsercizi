package EsercizioDieci;

public abstract class OperazioneAbstract {
    protected int risultato = 0;

    public void stampaRisultato(){
        System.out.println("Risultato: " + risultato);
    }

    public void esegui(int a, int b){
        risultato = eseguiOperazione(a, b);
        stampaRisultato();
    }

    public abstract int eseguiOperazione(int a, int b);
}
