package EsercizioDiciannove;

public enum DIPENDENTI_CONTRATTO_INDETERMINATO {
    DIPENDENTE_1("marcorossi", "Marco", "Rossi", 20000),
    DIPENDENTE_2("ilariabianchi", "Ilaria", "Bianchi", 20000),
    DIPENDENTE_3("giorgiobrambilla", "Giorgio", "Brambilla", 22250),
    DIPENDENTE_4("marcorossi", "Marco", "Rossi", 23000),
    DIPENDENTE_5("marcorossi", "Marco", "Rossi", 18000);


    private final String USERNAME;
    private final String NAME;
    private final String SURNAME;
    private final int SALARY;

    private DIPENDENTI_CONTRATTO_INDETERMINATO(String username, String name, String surname, int salary) {
        this.USERNAME = username;
        this.NAME = name;
        this.SURNAME = surname;
        this.SALARY = salary;
    }

    public String getUsername() {
        return USERNAME;
    }

    public String getName() {
        return NAME;
    }

    public String getSurname() {
        return SURNAME;
    }

    public int getSalary() {
        return SALARY;
    }

    public static void main(String[] args) {
        DIPENDENTI_CONTRATTO_INDETERMINATO uno = DIPENDENTE_1;
        System.out.println(uno.getUsername());
        System.out.println(uno.getName());
        System.out.println(uno.getSurname());
        System.out.println(uno.getSalary());
    }
}
