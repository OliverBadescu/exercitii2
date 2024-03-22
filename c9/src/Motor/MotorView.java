package Motor;

import java.util.Scanner;

public class MotorView {

    private MotorService motorService;
    private Scanner scanner;

    public MotorView() {
        this.scanner = new Scanner(System.in);
        this.motorService = new MotorService();
        this.play();
    }

    private void meniu() {
        System.out.println("Apasati tasta 1 pentru a afisa lista de motociclete");
        System.out.println("Apasati tasta 2 pentru a adauga o motocicleta");
        System.out.println("Apasati tasta 3 pentru a sterge o motocicleta");
        System.out.println("Apasati tasta 4 pentru a edita o motocicleta");

        System.out.println("\n");
        System.out.println("Apasati tasta 5 pentru a afisa motocicletele cu pret peste 20000");
        System.out.println("Apasati tasta 6 pentru a afisa motocicletele cu pret sub 20000");
        System.out.println("Apasati tasta 7 pentru a afisa motocicletele uzate");
        System.out.println("Apasati tasta 8 pentru a afisa motocicletele noi");

        System.out.println("\n");
        System.out.println("Apasati tasta 9 pentru a sorta lista crescator dupa pret");
        System.out.println("Apasati tasta 10 pentru a sorta lista crescator dupa an de fabricatie");
        System.out.println("\n");

        System.out.println("Apasati tasta 11 pentru a adauga un rating");
    }

    private void play() {
        boolean running = true;

        while (running) {
            meniu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    motorService.afisareMotociclete();
                    break;
                case 2:
                    adaugareMotocicleta();
                    break;
                case 3:
                    stergereMotocicleta();
                    break;
                case 4:
                    editareMotocicleta();
                    break;
                case 5:
                    motorService.afisarePretPeste20000();
                    break;
                case 6:
                    motorService.afisarePretSub20000();
                    break;
                case 7:
                    motorService.afisareMotorUzat();
                    break;
                case 8:
                    motorService.afisareMotorNou();
                    break;
                case 9:
                    motorService.sortarePret();
                    break;
                case 10:
                    motorService.sortareAnFabricatie();
                    break;
                case 11:
                    addRating();
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }
    }

    private void adaugareMotocicleta() {
        System.out.println("Introduceti detaliile motocicletei: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Pret: ");
        int pret = Integer.parseInt(scanner.nextLine());
        System.out.print("Este uzata? (true/false): ");
        boolean uzat = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("An de fabricatie: ");
        int anFabricatie = Integer.parseInt(scanner.nextLine());

        Motor nouaMotor = new Motor(marca, model, pret, uzat, anFabricatie);
        if (motorService.adaugareMotor(nouaMotor)) {
            System.out.println("Motocicleta a fost adaugata cu succes.");
        } else {
            System.out.println("Motocicleta exista deja in lista.");
        }
    }

    private void stergereMotocicleta() {
        System.out.println("Introduceti marca si modelul motocicletei de sters: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        if (motorService.stergereMotor(marca, model)) {
            System.out.println("Motocicleta a fost stearsa cu succes.");
        } else {
            System.out.println("Motocicleta nu a fost gasita in lista.");
        }
    }

    private void editareMotocicleta() {
        System.out.println("Introduceti marca si modelul motocicletei: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        if (motorService.editareMotor(marca, model)) {
            System.out.println("Datele motocicletei au fost actualizate.");
        } else {
            System.out.println("Motocicleta nu a fost gasita in lista.");
        }
    }

    private void addRating() {
        System.out.println("Introduceti marca si modelul motocicletei pentru adaugarea unui rating: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        if (motorService.adaugareRating(marca, model)) {
            System.out.println("Rating-ul a fost adaugat cu succes.");
        } else {
            System.out.println("Geanta nu a fost gasita in lista.");
        }
    }
}

