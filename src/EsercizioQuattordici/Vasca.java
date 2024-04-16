package EsercizioQuattordici;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Vasca {
    List<Animale> animali;

    public Vasca() {
        animali = new LinkedList<>();
    }

    public void addAnimale(Animale a) {
        animali.add(a);
    }

    public void stampaAnimali(){
        for(Animale a : animali){
            System.out.println("Codice: " + a.getAlfanumerico() + ", età: " + a.getEtà());
        }
    }

    public void deleteAnimali(String alfanumerico) {
        for(Animale a : animali){
            if(a.getAlfanumerico().equals(alfanumerico)){
                animali.remove(a);
            }
        }
    }

    public static void main(String[] args) {
        Mammifero mammifero = new Mammifero("AB", 10, 9);
        Pesce pesce = new Pesce("AC", 12, 10);

        Vasca vasca = new Vasca();
        vasca.addAnimale(mammifero);
        vasca.addAnimale(pesce);

        vasca.stampaAnimali();
        vasca.deleteAnimali("AB");
        vasca.stampaAnimali();
    }


}
