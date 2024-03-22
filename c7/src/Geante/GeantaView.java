package Geante;

import java.util.Scanner;

public class GeantaView {

    private GeantaService geantaService;
    private Scanner scanner;

    public GeantaView(){

        this.scanner = new Scanner(System.in);
        this.geantaService = new GeantaService();
        this.play();

    }

    private void meniu(){

        //crude
        System.out.println("Apasati tasta 1 pentru a afisa lista de genti");
        System.out.println("Apasati tasta 2 pentru a adauga o geanta");
        System.out.println("Apasati tasta 3 pentru a sterge o geanta");
        System.out.println("Apasati tasta 4 pentru a edita o geanta");

        System.out.println("\n");

        // filtrare
        System.out.println("Apasati tasta 5 pentru a afisa gentile cu dimensiune peste 25 cm");
        System.out.println("Apasati tasta 6 pentru a afisa gentile cu dimensiune sub 25 cm");
        System.out.println("Apasati tasta 7 pentru a afisa gentile cu pretul peste 500 lei");
        System.out.println("Apasati tasta 8 pentru a afisa gentile cu pretul sub 500 lei");

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
                    geantaService.afisareGenti();
                    break;
                case 2:
                    adaugareGeanta();
                    break;
                case 3:
                    stergereGeanta();
                    break;
                case 4:
                    editareGeanta();
                    break;
                case 5:
                    geantaService.afisareDimensiunePeste25();
                    break;
                case 6:
                    geantaService.afisareDimensiuneSub25();
                    break;
                case 7:
                    geantaService.afisarePretPeste500();
                    break;
                case 8:
                    geantaService.afisarePretSub500();
                    break;
                case 9:
                    geantaService.sortareDimensiune();
                    break;
                case 10:
                    geantaService.sortareAnFabricatie();
                    break;
                case 11:
                    geantaService.sortarePret();
                    break;
                case 12:
                    addRating();
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }
    }

    private void adaugareGeanta() {
        System.out.println("Introduceti detaliile gentii: ");
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

        Geanta nou= new Geanta(marca, model, pret, dimensiune, anFabricatie);
        if (geantaService.adaugareGeanta(nou)) {
            System.out.println("Geanta a fost adaugata cu succes.");
        } else {
            System.out.println("Geanta exista deja in lista.");
        }
    }

    private void stergereGeanta() {
        System.out.println("Introduceti marca si modelul gentii de sters: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        if (geantaService.stergereGeanta(marca, model)) {
            System.out.println("Geanta a fost stearsa cu succes.");
        } else {
            System.out.println("Geanta nu a fost gasita in lista.");
        }
    }

    private void editareGeanta() {
        System.out.println("Introduceti marca si modelul gentii: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        if (geantaService.editareGeanta(marca, model)) {
            System.out.println("Datele gentii au fost actualizate.");
        } else {
            System.out.println("Geanta nu a fost gasita in lista.");
        }
    }

    private void addRating() {
        System.out.println("Introduceti marca si modelul gentii pentru adaugarea unui rating: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        if (geantaService.adaugareRating(marca, model)) {
            System.out.println("Rating-ul a fost adaugat cu succes.");
        } else {
            System.out.println("Geanta nu a fost gasita in lista.");
        }
    }
}
