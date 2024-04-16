package EsercizioVentitre;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Bancomat {

    private int saldoBancomat;
    private Map<String, Integer> investitori;

    public Bancomat(int saldoBancomat) {
        this.saldoBancomat = saldoBancomat;
        this.investitori = new HashMap<>();
    }

    public int getSaldoBancomat() {
        return saldoBancomat;
    }

    public void prelievo(int cifra){
        if(saldoBancomat >= cifra){
            saldoBancomat -= cifra;
        }
    }

    public String deposito(int cifra, Investitore investitore){
        saldoBancomat += cifra;
        if(investitori.containsKey(investitore.getCodiceAlfanumerico())){
            investitori.replace(investitore.getCodiceAlfanumerico(), investitori.get(investitore.getCodiceAlfanumerico() + cifra));
            return "Prelievo effettuato corretamente";
        }else{
            investitori.put(investitore.getCodiceAlfanumerico(), cifra);
            return "Prelievo effettuato corretamente";
        }
    }

    public String prelievo(int cifra, Investitore investitore){
        if(cifra > saldoBancomat){
            return "Spiacenti, ma il bancomat non è al momento in grado di erogare la cifra richiesta.";
        }

        if(investitori.get(investitore.getCodiceAlfanumerico()) >= cifra){
            investitori.replace(investitore.getCodiceAlfanumerico(), investitori.get(investitore.getCodiceAlfanumerico()) - cifra);
            saldoBancomat -= cifra;
            return "Prelievo effettuato correttamente. ";
        }else{
            return "Spiacenti, ma il tuo saldo investito è inferiore alla cifra richiesta.";
        }
    }


}
