package EsercizioDiciannove;

import java.time.Month;
import java.time.Year;
import java.util.*;

public class gestioneUtenti {
    List<DIPENDENTI_CONTRATTO_INDETERMINATO> dipendenti;

    Map<Integer, Map<EMesi, List<String>>> dipendenteUno;
    Map<Integer, Map<EMesi, List<String>>> dipendenteDue;
    Map<Integer, Map<EMesi, List<String>>> dipendenteTre;
    Map<Integer, Map<EMesi, List<String>>> dipendenteQuattro;
    Map<Integer, Map<EMesi, List<String>>> dipendenteCinque;

    List<Map<Integer, Map<EMesi, List<String>>>> mappeDipendenti;


    public gestioneUtenti() {
        dipendenti = new LinkedList<>();
        DIPENDENTI_CONTRATTO_INDETERMINATO[] elenco = DIPENDENTI_CONTRATTO_INDETERMINATO.values();

        for(DIPENDENTI_CONTRATTO_INDETERMINATO dipendente : elenco){
            dipendenti.add(dipendente);
        }

        mappeDipendenti = new LinkedList<>();

        dipendenteUno = new HashMap<>();
        mappeDipendenti.add(dipendenteUno);
        dipendenteDue = new HashMap<>();
        mappeDipendenti.add(dipendenteDue);
        dipendenteTre = new HashMap<>();
        mappeDipendenti.add(dipendenteTre);
        dipendenteQuattro = new HashMap<>();
        mappeDipendenti.add(dipendenteQuattro);
        dipendenteCinque = new HashMap<>();
        mappeDipendenti.add(dipendenteCinque);

    }

    public void addDipendente(DIPENDENTI_CONTRATTO_INDETERMINATO dipendente){
        dipendenti.add(dipendente);
    }

    public void deleteDipendente(String username){
        for(DIPENDENTI_CONTRATTO_INDETERMINATO dipendente : dipendenti){
            if(dipendente.getUsername().equals(username)){
                dipendenti.remove(dipendente);
            }
        }
    }

    public void addBonusMalus(DIPENDENTI_CONTRATTO_INDETERMINATO dipendente, EMesi mese, String bonusMalus){

        switch (dipendente.ordinal() + 1){
            case 1:
                aggiungiBonus(mese, bonusMalus.trim(), dipendenteUno);
                break;
            case 2:
                aggiungiBonus(mese, bonusMalus.trim(), dipendenteDue);
                break;
            case 3:
                aggiungiBonus(mese, bonusMalus.trim(), dipendenteTre);
                break;
            case 4:
                aggiungiBonus(mese, bonusMalus.trim(), dipendenteQuattro);
            case 5:
                aggiungiBonus(mese, bonusMalus.trim(), dipendenteCinque);
                break;
        }
    }

    private void aggiungiBonus(EMesi mese, String bonusMalus, Map<Integer, Map<EMesi, List<String>>> listaDipendente) {
        if(listaDipendente.containsKey(Year.now().getValue())){
            Map<EMesi, List<String>> map = listaDipendente.get(Year.now().getValue());
            if(map.containsKey(mese)){
                List<String> bonus = map.get(mese);
                bonus.add(bonusMalus);
            }else{
                List<String> bonus = new LinkedList<>();
                bonus.add(bonusMalus);
                map.put(mese, bonus);
            }
        }else{
            List<String> bonus = new LinkedList<>();
            bonus.add(bonusMalus);
            Map<EMesi, List<String>> map = new HashMap<>();
            map.put(mese, bonus);
            listaDipendente.put(Year.now().getValue(), map);
        }
    }

    private String recordMalus(){
        int malus = 0;
        String username = "";
        int i = 0;

        for(Map<Integer, Map<EMesi, List<String>>> mappaDipendente : mappeDipendenti){
            int tmp = computaMalus(mappaDipendente.get(Year.now().getValue()));
            if(tmp < malus){
                malus = tmp;
                username = DIPENDENTI_CONTRATTO_INDETERMINATO.values()[i].getUsername();
            }
            i++;
        }

        return username;

    }

    public boolean salarioPiuBasso(String username){
        int currentLowestSalary = Integer.MAX_VALUE;
        String currentUsername = "";
        int i = 0;

        for(Map<Integer, Map<EMesi, List<String>>> mappaDipendente : mappeDipendenti){
            int tmp = computaMalus(mappaDipendente.get(Year.now().getValue()));
            int salario = DIPENDENTI_CONTRATTO_INDETERMINATO.values()[i].getSalary();
            if((tmp + salario) < currentLowestSalary){
                currentLowestSalary = tmp + salario;
                currentUsername = DIPENDENTI_CONTRATTO_INDETERMINATO.values()[i].getUsername();
            }
            i++;
        }

        return username.equals(currentUsername);
    }

    private int computaMalus(Map<EMesi, List<String>> map){
        int malus = 0;
        for(Map.Entry<EMesi, List<String>> entry : map.entrySet()){
            for (String value : entry.getValue()){
                malus += Integer.parseInt(value);
            }
        }

        return malus;
    }

    public String migliorDipendenteNatale(){
        int currentHighestSalary = Integer.MIN_VALUE;
        String currentUsername = "";
        int i = 0;

        for(Map<Integer, Map<EMesi, List<String>>> mappaDipendente : mappeDipendenti){
            int tmp = computaMalus(mappaDipendente.get(Year.now().getValue()));
            int salario = DIPENDENTI_CONTRATTO_INDETERMINATO.values()[i].getSalary();
            if((tmp + salario) > currentHighestSalary){
                currentHighestSalary = tmp + salario;
                currentUsername = DIPENDENTI_CONTRATTO_INDETERMINATO.values()[i].getUsername();
            }
            i++;
        }

        return currentUsername;
    }


}
