package EsercizioDiciannove;

public enum DIPENDENTI_CONTRATTO_INDETERMINATO {
    DIPENDENTE_1("marcorossi", "Marco", "Rossi", 20000),
    DIPENDENTE_2("ilariabianchi", "Ilaria", "Bianchi", 20000),
    DIPENDENTE_3("giorgiobrambilla", "Giorgio", "Brambilla", 22250),
    DIPENDENTE_4("marcorossi", "Marco", "Rossi", 23000),
    DIPENDENTE_5("marcorossi", "Marco", "Rossi", 18000);


    private final String username;
    private final String name;
    private final String surname;
    private final int salary;

    private DIPENDENTI_CONTRATTO_INDETERMINATO(String username, String name, String surname, int salary) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        DIPENDENTI_CONTRATTO_INDETERMINATO uno = DIPENDENTE_1;
        System.out.println(uno.getUsername());
        System.out.println(uno.getName());
        System.out.println(uno.getSurname());
        System.out.println(uno.getSalary());
    }
}
