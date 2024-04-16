package EsercizioVentitre;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Banca {

    private static Banca banca = new Banca();
    private Bancomat bancomatUno = new Bancomat(100000);
    private Bancomat bancomatDue = new Bancomat(100000);
    public Map<String, Integer> bancomatInvestitori= new HashMap<>();
    public List<Investitore> listaInvestitori = new LinkedList<>();
    int roundRobin = 1;


    private Banca(){}

    public static Banca getIstance(){
        return banca;
    }

    public void addInvestitore(Investitore investitore){
        bancomatInvestitori.put(investitore.getCodiceAlfanumerico(), (roundRobin++)%2);
    }

    public void deleteInvestitore(Investitore investitore){
        bancomatInvestitori.remove(investitore.getCodiceAlfanumerico());
        for(Investitore inv : listaInvestitori){
            if(inv.getCodiceAlfanumerico().equals(investitore.getCodiceAlfanumerico())){
                listaInvestitori.remove(inv);
            }
        }
    }

    public Bancomat getBancomat(String investitore){
        int bancomat =  bancomatInvestitori.get(investitore);
        if(bancomat == 0){
            return bancomatUno;
        }else{
            return bancomatDue;
        }
    }

    public void pushNotizia(Notizia notizia){
        for(Investitore inv : listaInvestitori){
            inv.update(notizia);
        }
    }

}
