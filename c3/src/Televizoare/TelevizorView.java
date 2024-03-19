package Televizoare;

import java.util.Scanner;
import java.util.ArrayList;

public class TelevizorView {

    private TelevizorService televizorService;
    private Scanner scanner;

    public TelevizorView(){

        this.scanner = new Scanner(System.in);
        this.televizorService = new TelevizorService();
        this.play();

    }

    private void meniu(){

        //crude

        System.out.println("Apasati tasta 1 pentru a afisa lista de televizoare");
        System.out.println("Apasati tasta 2 pentru a adauga un televizor");
        System.out.println("Apasati tasta 3 pentru a sterge un televizor");
        System.out.println("Apasati tasta 4 pentru a edita un televizor");

        System.out.println("\n");

        // filtrare
        System.out.println("Apasati tasta 5 pentru a afisa televizoarele cu dimensiune peste 60 cm");
        System.out.println("Apasati tasta 6 pentru a afisa televizoarele cu dimensiune sub 60 cm");
        System.out.println("Apasati tasta 7 pentru a afisa televizoarele cu pretul peste 1000 lei");
        System.out.println("Apasati tasta 8 pentru a afisa televizoarele cu pretul sub 1000 lei");

        System.out.println( "\n");

        //sortare
        System.out.println("Apasati tasta 9 pentru a sorta lista crescator dupa dimensiune");
        System.out.println("Apasati tasta 10 pentru a sorta lista crescator dupa an de fabricate");
        System.out.println("Apasati tasta 11 pentru a sorta lista crescator dupa pret");

        System.out.println("\n");
        //adaugare rating
        System.out.println("Apasati tasta 12 pentru a adauga un rating");

    }

    private void play() {
        boolean running = true;

        while (running) {
            meniu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    televizorService.afisareTelevozare();
                    break;
                case 2:
                    adaugareTelevizor();
                    break;
                case 3:
                    stergereTelevizor();
                    break;
                case 4:
                    editareTelevizor();
                    break;
                case 5:
                    televizorService.afisareDimensiunePeste60();
                    break;
                case 6:
                    televizorService.afisareDimensiuneSub60();
                    break;
                case 7:
                    televizorService.afisarePretPeste1000();
                    break;
                case 8:
                    televizorService.afisarePretSub1000();
                    break;
                case 9:
                    televizorService.sortareDimensiune();
                    break;
                case 10:
                    televizorService.sortareAnFabricatie();
                    break;
                case 11:
                    televizorService.sortarePret();
                    break;
                case 12:
                    addTelevizorRating();
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }
    }
    private void adaugareTelevizor() {
        System.out.println("Introduceti detaliile televizorului: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Pret: ");
        int pret = Integer.parseInt(scanner.nextLine());
        System.out.print("Dimensiune: ");
        int dimensiune = Integer.parseInt(scanner.nextLine());
        System.out.print("An de fabricatie: ");
        int anFabricatie = Integer.parseInt(scanner.nextLine());

        Televizor nou= new Televizor(marca, model, pret, dimensiune, anFabricatie);
        if (televizorService.adaugareTelevizor(nou)) {
            System.out.println("Tastatura a fost adaugata cu succes.");
        } else {
            System.out.println("Tastatura exista deja in lista.");
        }
    }
    private void stergereTelevizor() {
        System.out.println("Introduceti marca si modelul televizorului de sters: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        if (televizorService.stergereTelevizor(marca, model)) {
            System.out.println("Tastatura a fost stearsa cu succes.");
        } else {
            System.out.println("Tastatura nu a fost gasita in lista.");
        }
    }
    private void editareTelevizor() {
        System.out.println("Introduceti marca si modelul televizorului: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        if (televizorService.editareTelevizor(marca, model)) {
            System.out.println("Datele televizorului au fost actualizate.");
        } else {
            System.out.println("Televizorul nu a fost gasita in lista.");
        }
    }
    private void addTelevizorRating() {
        System.out.println("Introduceti marca si modelul televizorlului pentru adaugarea unui rating: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        if (televizorService.adaugareRating(marca, model)) {
            System.out.println("Rating-ul a fost adaugat cu succes.");
        } else {
            System.out.println("Televizorul nu a fost gasita in lista.");
        }
    }

}
