package Jucatori;

import java.util.Scanner;

public class JucatorView {

    private JucatorService jucatorService;
    private Scanner scanner;

    public JucatorView() {
        this.scanner = new Scanner(System.in);
        this.jucatorService = new JucatorService();
        this.play();
    }

    private void meniu() {

        //crude
        System.out.println("Apasati tasta 1 pentru a afisa lista de jucatori");
        System.out.println("Apasati tasta 2 pentru a adauga un jucator");
        System.out.println("Apasati tasta 3 pentru a sterge un jucator");
        System.out.println("Apasati tasta 4 pentru a edita un jucator");

        System.out.println("\n");

        //filtrare

        System.out.println("Apasati tasta 5 pentru a afisa jucatorii sub varsta de 25 de ani;");
        System.out.println("Apasati tasta 6 pentru a afisa jucatorii peste varsta de 25 de ani;");

        System.out.println("\n");

        // sortare

        System.out.println("Apasati tasta 7 pentru a sorta jucatorii dupa varsta");
        System.out.println("Apasati tasta 8 pentru a sorta jucatorii dupa vechime");

        System.out.println("\n");

        // rating
        System.out.println("Apasati tasta 9 pentru a adauga un rating unui jucator");
    }

    private void play() {
        boolean running = true;

        while (running) {
            meniu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    jucatorService.afisareJucatori();
                    break;
                case 2:
                    adaugareJucator();
                    break;
                case 3:
                    stergereJucator();
                    break;
                case 4:
                    editareJucator();
                    break;
                case 5:
                    jucatorService.afisareSub25();
                    break;
                case 6:
                    jucatorService.afisarePeste25();
                case 7:
                    jucatorService.sortareVarsta();
                    break;
                case 8:
                    jucatorService.sortareVechime();
                    break;
                case 9:
                    adaugareRating();
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }
    }

    private void adaugareJucator() {
        System.out.println("Introduceti detaliile jucatorului:");
        System.out.print("Nume: ");
        String nume = scanner.nextLine();
        System.out.print("Prenume: ");
        String prenume = scanner.nextLine();
        System.out.print("Echipa: ");
        String echipa = scanner.nextLine();
        System.out.print("Varsta: ");
        int varsta = Integer.parseInt(scanner.nextLine());
        System.out.print("Vechime: ");
        int vechime = Integer.parseInt(scanner.nextLine());

        Jucator jucator = new Jucator(nume, prenume, echipa, varsta, vechime);
        if (jucatorService.adaugareJucator(jucator)) {
            System.out.println("Jucatorul a fost adaugat cu succes.");
        } else {
            System.out.println("Jucatorul exista deja in lista.");
        }
    }

    private void stergereJucator() {
        System.out.println("Introduceti numele si prenumele jucatorului de sters:");
        System.out.print("Nume: ");
        String nume = scanner.nextLine();
        System.out.print("Prenume: ");
        String prenume = scanner.nextLine();

        if (jucatorService.stergereJucator(nume, prenume)) {
            System.out.println("Jucatorul a fost sters cu succes.");
        } else {
            System.out.println("Jucatorul nu a fost gasit in lista.");
        }
    }

    private void editareJucator() {
        System.out.println("Introduceti numele si prenumele jucatorului:");
        System.out.print("Nume: ");
        String nume = scanner.nextLine();
        System.out.print("Prenume: ");
        String prenume = scanner.nextLine();

        if (jucatorService.editareJucator(nume, prenume)) {
            System.out.println("Datele jucatorului au fost actualizate.");
        } else {
            System.out.println("Jucatorul nu a fost gasit in lista.");
        }
    }

    private void adaugareRating() {
        System.out.println("Introduceti numele si prenumele jucatorului pentru adaugarea unui rating:");
        System.out.print("Nume: ");
        String nume = scanner.nextLine();
        System.out.print("Prenume: ");
        String prenume = scanner.nextLine();

        if (jucatorService.adaugareRating(nume, prenume)) {
            System.out.println("Rating-ul a fost adaugat cu succes.");
        } else {
            System.out.println("Jucatorul nu a fost gasit in lista.");
        }
    }
}
