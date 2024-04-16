package EsercizioSedici;

public class Orario {
    int ore;
    int minuti;
    int secondi;

    public Orario(int ore, int minuti, int secondi) {
        this.ore = ore;
        this.minuti = minuti;
        this.secondi = secondi;
    }

    public static boolean isCorrect(int ore, int minuti, int secondi){
        if(ore > 24 || ore < 0){
            return false;
        }
        if(minuti > 59 || minuti < 0){
            return false;
        }
        if(secondi > 59 || secondi < 0){
            return false;
        }

        return true;
    }

    public int getOre() {
        return ore;
    }

    public void setOre(int ore) {
        this.ore = ore;
    }

    public int getMinuti() {
        return minuti;
    }

    public void setMinuti(int minuti) {
        this.minuti = minuti;
    }

    public int getSecondi() {
        return secondi;
    }

    public void setSecondi(int secondi) {
        this.secondi = secondi;
    }

    public void SommaOrario(Orario orario){
        int riporto = 0;

        if(this.secondi + orario.getSecondi() > 59) {
            this.secondi = (this.secondi + orario.getSecondi()) % 60;
            riporto++;
        }else {
            this.secondi = this.secondi + orario.getSecondi();
        }

        if((this.minuti + orario.getMinuti() + riporto) > 59) {
            this.minuti = (this.minuti + orario.getMinuti()) % 60;
        }else{
            this.minuti = (this.minuti + orario.getMinuti() + riporto);
            riporto = 0;
        }

        this.ore = (this.ore + orario.getOre() + riporto) % 24;


    }


    public static void main(String[] args) {
        Orario ore = new Orario(15, 0, 1);
        System.out.println(isCorrect(23,10,59));
        Orario due =new Orario(15, 1, 59);
        ore.SommaOrario(due);
        System.out.println(ore.ore);
        System.out.println(ore.minuti);
        System.out.println(ore.secondi);
    }

}
