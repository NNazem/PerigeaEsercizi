package EsercizioPersone;

import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        LinkedList<Persona> personeList = new LinkedList<>();
        Random random = new Random();

        //CHATGPT

        for (int i = 0; i < 20; i++) {
            String codiceFiscale = "CF" + random.nextInt(1000000);
            String nome = "Nome" + (i + 1);
            String cognome = "Cognome" + (i + 1);

            int[] differentiEtà = {25,40,60,55};
            int età = differentiEtà[random.nextInt(differentiEtà.length)];

            String[] paesi = {"Italia", "Francia", "Spagna", "Germania"};
            String paeseDiNascita = paesi[random.nextInt(paesi.length)];

            int reddito = 10000 + random.nextInt(90000); // Random income between 10000 and 99999

            Persona persona = new Persona(codiceFiscale, nome, cognome, età, paeseDiNascita, reddito);
            personeList.add(persona);
        }

        for (Persona persona : personeList) {
            System.out.println(persona.età);
        }

       Map<String, Integer> redditoPerPaese = personeList.stream()
               .collect(Collectors.groupingBy(
                       (Persona persona) -> persona.getPaeseDiNascita(),
                       Collectors.summingInt(Persona::getReddito)
               ));

       for (String stringa : redditoPerPaese.keySet()) {
           System.out.println("Totale paese: " + stringa + " " + redditoPerPaese.get(stringa));
       }

        Map<String, Double> redditoPerPaeseMedio = personeList.stream()
                .collect(Collectors.groupingBy(
                        (Persona persona) -> persona.getPaeseDiNascita(),
                        Collectors.averagingInt(Persona::getReddito)
                ));

        for (String stringa : redditoPerPaeseMedio.keySet()) {
            System.out.println("Media paese: " + stringa + " " + redditoPerPaeseMedio.get(stringa));
        }

        Map<Integer, Integer> redditoPerEtà = personeList.stream()
                .collect(Collectors.groupingBy(
                        (Persona persona) -> persona.getEtà(),
                        Collectors.summingInt(Persona::getReddito)
                ));

        for (Integer età : redditoPerEtà.keySet()) {
            System.out.println("Totale età: " + età + " " + redditoPerEtà.get(età));
        }

        Map<Integer, Double> redditoPerEtàMedio = personeList.stream()
                .collect(Collectors.groupingBy(
                        (Persona persona) -> persona.getEtà(),
                        Collectors.averagingInt(Persona::getReddito)
                ));

        for (Integer età : redditoPerEtàMedio.keySet()) {
            System.out.println("Media età: " + età + " " + redditoPerEtàMedio.get(età));
        }



    }
}
