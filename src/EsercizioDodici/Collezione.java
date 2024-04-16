package EsercizioDodici;

import java.util.LinkedList;
import java.util.List;

public class Collezione {
    public String nome;
    public List<OperaDarte> opere;

    public Collezione(String nome) {
        this.nome = nome;
        opere = new LinkedList<>();
    }

    public void addOpera(OperaDarte opera) {
        opere.add(opera);
    }

    public void stampaCollezione(){
        int index = 1;
        for(OperaDarte opera : opere){
            System.out.println(index + " | " + "Titolo opera: " + opera.titolo + ", artista: " + opera.artista);
            index++;
        }
    }

    public void stampaIngombroOpera(int index){
        OperaDarte opera = opere.get(index-1);
        System.out.println("Ingombro opera: " + opera.printIngombro());
    }

    public static void main(String[] args) {
        Quadro quadro = new Quadro("A", "B", 5, 5);
        Scultura scultura = new Scultura("C", "D", 5, 5, 5);
        Collezione collezione = new Collezione("E");
        collezione.addOpera(quadro);
        collezione.addOpera(scultura);
        collezione.stampaCollezione();
        collezione.stampaIngombroOpera(1);
    }
}
