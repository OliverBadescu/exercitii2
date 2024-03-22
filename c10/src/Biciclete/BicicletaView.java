package Biciclete;

import java.util.Scanner;

public class BicicletaView {

    private BicicletaService bicicletaService;
    private Scanner scanner;

    public BicicletaView() {
        this.scanner = new Scanner(System.in);
        this.bicicletaService = new BicicletaService();
        this.play();
    }

    private void menu() {
        System.out.println("Apasati tasta 1 pentru a afisa lista de biciclete");
        System.out.println("Apasati tasta 2 pentru a adauga o bicicleta");
        System.out.println("Apasati tasta 3 pentru a sterge o bicicleta");
        System.out.println("Apasati tasta 4 pentru a edita o bicicleta");

        System.out.println("\n");
        System.out.println("Apasati tasta 5 pentru a afisa bicicletele uzate");
        System.out.println("Apasati tasta 6 pentru a afisa bicicletele noi");

        System.out.println("\n");
        System.out.println("Apasati tasta 7 pentru a sorta lista crescator dupa pret");
        System.out.println("Apasati tasta 8 pentru a sorta lista crescator dupa an de fabricatie");

        System.out.println("\n");
        System.out.println("Apasati tasta 9 pentru a adauga un rating unei biciclete");

    }

    private void play() {
        boolean running = true;
        while (running) {
            menu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    bicicletaService.afisareBiciclete();
                    break;
                case 2:
                    adaugareBicicleta();
                    break;
                case 3:
                    stergereBicicleta();
                    break;
                case 4:
                    editareBicicleta();
                    break;
                case 5:
                    bicicletaService.afisareBicicletaUzata();
                    break;
                case 6:
                    bicicletaService.afisareBicicletaNoua();
                    break;
                case 7:
                    bicicletaService.sortarePret();
                    break;
                case 8:
                    bicicletaService.sortareAnFabricatie();
                    break;
                case 9:
                    addRating();
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }
    }

    private void adaugareBicicleta() {
        System.out.println("Introduceti detaliile bicicletei: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Pret: ");
        int pret = Integer.parseInt(scanner.nextLine());
        System.out.print("An de fabricatie: ");
        int anFabricatie = Integer.parseInt(scanner.nextLine());
        System.out.print("Este bicicleta uzata? (true/false): ");
        boolean uzata = Boolean.parseBoolean(scanner.nextLine());

        Bicicleta nouaBicicleta = new Bicicleta(marca, model, pret, uzata, anFabricatie);
        if (bicicletaService.adaugareBicicleta(nouaBicicleta)) {
            System.out.println("Bicicleta a fost adaugata cu succes.");
        } else {
            System.out.println("Bicicleta exista deja in lista.");
        }
    }

    private void stergereBicicleta() {
        System.out.println("Introduceti marca si modelul bicicletei de sters: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        if (bicicletaService.stergereBicicleta(marca, model)) {
            System.out.println("Bicicleta a fost stearsa cu succes.");
        } else {
            System.out.println("Bicicleta nu a fost gasita in lista.");
        }
    }

    private void editareBicicleta() {
        System.out.println("Introduceti marca si modelul bicicletei: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        if (bicicletaService.editareBicicleta(marca, model)) {
            System.out.println("Datele bicicletei au fost actualizate.");
        } else {
            System.out.println("Bicicleta nu a fost gasita in lista.");
        }
    }

    private void addRating() {
        System.out.println("Introduceti marca si modelul bicicletei pentru adaugarea unui rating: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        if (bicicletaService.adaugareRating(marca, model)) {
            System.out.println("Rating-ul a fost adaugat cu succes.");
        } else {
            System.out.println("Bicicleta nu a fost gasita in lista.");
        }
    }
}
