package fasttrackit.ro;

import java.util.Scanner;

public class Main {

    static String[] agendaDeNume = new String[5];
    static int pozitie = 0;

    public static void afisareMeniu() {
        System.out.println("1> Afisare");
        System.out.println("2> Adaugare");
        System.out.println("3> Stergere");
        System.out.println("4> Cautare");
        System.out.println("5> Modificare");
        System.out.println("0> Exit");

    }

    public static String citireNume(String label) {
        System.out.print(label);
        Scanner kbdInput = new Scanner(System.in);
        String readValue = kbdInput.nextLine();
        return readValue;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int optiune = -1;
        do {
            afisareMeniu();
            Scanner sc = new Scanner(System.in);
            optiune = sc.nextInt();
            switch (optiune) {
                case 1: {
                    afisareAgenda();
                    break;
                }

                case 2: {
                    adaugareAgenda();
                    break;
                }

                case 3: {
                    stergereAgenda();
                    break;
                }
                case 4: {
                    cautareAgenda();
                    break;
                }
                case 5: {
                    modificareAgenda();
                    break;
                }
            }
        }
        while (optiune != 0);
    }


    public static void afisareAgenda() {
        for (int i = 0; i < agendaDeNume.length; i++) {
            if (agendaDeNume[i] != null) {
                System.out.println(i + ": " + agendaDeNume[i]);
            }

        }
    }

    public static void adaugareAgenda() {
        if (pozitie < agendaDeNume.length) {
            String nume = citireNume("Introduceti numele de adaugat:");
            agendaDeNume[pozitie] = nume;
            pozitie++;
        } else {
            // totusi hai sa cautam in goluri , ugly code !!!!
            for (int i = 0; i < agendaDeNume.length; i++) {
                if (agendaDeNume[i] == null) {
                    String nume = citireNume("Introduceti numele de adaugat:");
                    agendaDeNume[i] = nume;
                    break;
                }
            }


            System.out.println("Agenda plina, ia alta mai mare");
        }

        System.out.println();
    }


    public static int cautareAgenda(String nume) { //se opreste la primul gasit
        int found = -1;
        String nume = citireNume("Introduceti numele de cautat:");
        for (int i = 0; i < agendaDeNume.length; i++) {
            if (nume.equalsIgnoreCase(agendaDeNume[i])) {
                agendaDeNume[i] = null;
                System.out.println("Nume gasit:" + nume);
                found = i;
                break;
            }
        }
        return found;
    }

    public static void stergereAgenda(String nume) {
        String nume = citireNume("Introduceti numele de sters:");
        //int indexCautat = -1;
        int indexCautat = cautareAgenda(nume);
        if(indexCautat!=-1)
            agendaDeNume[indexCautat]=null;
    }

    public static void modificareAgenda(String nume, String numenou) {


    }
}