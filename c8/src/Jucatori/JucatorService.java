package Jucatori;

import java.util.ArrayList;
import java.util.Scanner;

public class JucatorService {

    private ArrayList<Jucator> jucatori;
    private Scanner scanner = new Scanner(System.in);

    public JucatorService() {
        this.jucatori = new ArrayList<>();
        this.loadData();
    }

    private void loadData() {
        Jucator j1 = new Jucator("Cristiano", "Ronaldo", "Manchester United", 36, 20);
        Jucator j2 = new Jucator("Lionel", "Messi", "Paris Saint-Germain", 34, 18);
        Jucator j3 = new Jucator("Robert", "Lewandowski", "Bayern Munich", 33, 15);
        Jucator j4 = new Jucator("Neymar", "Jr.", "Paris Saint-Germain", 29, 12);
        Jucator j5 = new Jucator("Kevin", "De Bruyne", "Manchester City", 30, 14);
        Jucator j6 = new Jucator("Kylian", "Mbappé", "Paris Saint-Germain", 23, 10);
        Jucator j7 = new Jucator("Mohamed", "Salah", "Liverpool", 29, 12);
        Jucator j8 = new Jucator("Sergio", "Ramos", "Paris Saint-Germain", 35, 18);
        Jucator j9 = new Jucator("Virgil", "van Dijk", "Liverpool", 30, 14);
        Jucator j10 = new Jucator("Antoine", "Griezmann", "Atletico Madrid", 30, 13);

        jucatori.add(j1);
        jucatori.add(j2);
        jucatori.add(j3);
        jucatori.add(j4);
        jucatori.add(j5);
        jucatori.add(j6);
        jucatori.add(j7);
        jucatori.add(j8);
        jucatori.add(j9);
        jucatori.add(j10);
    }

    public void afisareJucatori() {
        for (int i = 0; i < jucatori.size(); i++) {
            System.out.println(jucatori.get(i).descriere());
        }
    }

    public void afisareSub25() {
        for (int i = 0; i < jucatori.size(); i++) {
            if (jucatori.get(i).getVarsta() < 25) {
                System.out.println(jucatori.get(i).descriere());
            }
        }
    }

    public void afisarePeste25() {
        for (int i = 0; i < jucatori.size(); i++) {
            if (jucatori.get(i).getVarsta() >= 25) {
                System.out.println(jucatori.get(i).descriere());
            }
        }
    }

    public void sortareVarsta() {
        boolean sortat = false;
        do {
            sortat = true;
            for (int i = 0; i < jucatori.size() - 1; i++) {
                if (jucatori.get(i).getVarsta() > jucatori.get(i + 1).getVarsta()) {
                    Jucator aux = jucatori.get(i);
                    jucatori.set(i, jucatori.get(i + 1));
                    jucatori.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);
    }

    public void sortareVechime() {
        boolean sortat = false;
        do {
            sortat = true;
            for (int i = 0; i < jucatori.size() - 1; i++) {
                if (jucatori.get(i).getVechime() > jucatori.get(i + 1).getVechime()) {
                    Jucator aux = jucatori.get(i);
                    jucatori.set(i, jucatori.get(i + 1));
                    jucatori.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);
    }

    public boolean adaugareRating(String nume, String prenume) {
        Jucator jucator = findByNumePrenume(nume, prenume);
        if (jucator != null) {
            System.out.println("Introduceti ratingul dorit:");
            double rating = Double.parseDouble(scanner.nextLine());

            double ratingVechi = jucator.getRating() * jucator.getNrReviewuri();
            double ratingTotal = ratingVechi + rating;
            jucator.adaugareNrReviewuri();
            double ratingNou = ratingTotal / jucator.getNrReviewuri();
            jucator.setRating(ratingNou);

            return true;
        }
        return false;
    }

    private Jucator findByNumePrenume(String nume, String prenume) {
        for (int i = 0; i < jucatori.size(); i++) {
            if (jucatori.get(i).getNume().equalsIgnoreCase(nume) && jucatori.get(i).getPrenume().equalsIgnoreCase(prenume)) {
                return jucatori.get(i);
            }
        }
        return null;
    }
    public boolean adaugareJucator(Jucator jucator) {
        if (findByNumePrenume(jucator.getNume(), jucator.getPrenume()) != null) {
            return false;
        }
        jucatori.add(jucator);
        return true;
    }
    public boolean editareJucator(String nume, String prenume) {
        Jucator jucator = findByNumePrenume(nume, prenume);
        if (jucator != null) {
            System.out.println("Ce doriti sa modificati?");
            System.out.println("1. Echipa");
            System.out.println("2. Varsta");
            System.out.println("3. Vechime");

            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1:
                    System.out.println("Introduceti noua echipa: ");
                    String echipa = scanner.nextLine();
                    jucator.setEchipa(echipa);
                    break;
                case 2:
                    System.out.println("Introduceti noua varsta: ");
                    int varsta = Integer.parseInt(scanner.nextLine());
                    jucator.setVarsta(varsta);
                    break;
                case 3:
                    System.out.println("Introduceti noua vechime: ");
                    int vechime = Integer.parseInt(scanner.nextLine());
                    jucator.setVechime(vechime);
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
            return true;
        }
        return false;
    }
    public boolean stergereJucator(String nume, String prenume) {
        for (int i = 0; i < jucatori.size(); i++) {
            if (jucatori.get(i).getNume().equalsIgnoreCase(nume) && jucatori.get(i).getPrenume().equalsIgnoreCase(prenume)) {
                this.jucatori.remove(jucatori.get(i));
                return true;
            }
        }
        return false;
    }

}
