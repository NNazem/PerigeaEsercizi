package EsercizioVentitre;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class InvestitoreAggressivo implements Investitore{

    public String codiceAlfanumerico;
    public List<Argomento> settoriInvestiti;
    public int saldo;
    public int saldoInvestito;
    public Banca banca;


    public InvestitoreAggressivo(String codiceAlfanumerico) {
        settoriInvestiti = new LinkedList<>();
        settoriInvestiti.add(Argomento.FOREX);
        settoriInvestiti.add(Argomento.CRYPTO);
        settoriInvestiti.add(Argomento.DERIVATES);
        this.codiceAlfanumerico = codiceAlfanumerico;
        saldo = 1000000;
        banca = Banca.getIstance();
    }

    public void update(Notizia notizia){
        if(notizia.priorità >= 2 && notizia.isPositiva && settoriInvestiti.contains(notizia.argomento)){
            effettuaInvestimento();
        }else if(notizia.priorità >= 4 && !notizia.isPositiva && settoriInvestiti.contains(notizia.argomento)){
            effettuaPrelievo();
        }
    }

    @Override
    public void effettuaPrelievo() {
        Bancomat bancomat = banca.getBancomat(codiceAlfanumerico);
        int ammontare = new Random().nextInt(saldoInvestito/10);

    }

    public void effettuaInvestimento(){
        Bancomat bancomat = banca.getBancomat(codiceAlfanumerico);
        int ammontare = new Random().nextInt((saldo/10));
        bancomat.deposito(ammontare, this);
        saldo -= ammontare;
        saldoInvestito += ammontare;
    }


    @Override
    public String getCodiceAlfanumerico() {
        return codiceAlfanumerico;
    }

}
