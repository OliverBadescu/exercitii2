package Keyboards;

import java.util.Scanner;
import java.util.ArrayList;

public class KeyboardView {

    private KeyboardService keyboardService;
    private Scanner scanner;

    public KeyboardView() {

        this.scanner  = new Scanner(System.in);
        this.keyboardService = new KeyboardService();
        this.play();
    }

    private void meniu(){

        //crude

        System.out.println("Apasati tasta 1 pentru a afisa lista de tastaturi");
        System.out.println("Apasati tasta 2 pentru a adauga o tastaturi");
        System.out.println("Apasati tasta 3 pentru a sterge o tastaturi");
        System.out.println("Apasati tasta 4 pentru a edita o tastaturi");

        System.out.println("\n");

        // filtrare
        System.out.println("Apasati tasta 5 pentru a afisa tastaturile cu dimensiune sub 100 cm");
        System.out.println("Apasati tasta 6 pentru a afisa tastaturile cu dimensiune peste 100 cm");
        System.out.println("Apasati tasta 7 pentru a afisa tastaturile cu pretul peste 600 lei");
        System.out.println("Apasati tasta 8 pentru a afisa tastaturile cu pretul sub 600 lei");

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
                    keyboardService.afisareKeyboards();
                    break;
                case 2:
                    adaugareKeyboard();
                    break;
                case 3:
                    stergereKeyboard();
                    break;
                case 4:
                    editareKeyboard();
                    break;
                case 5:
                    keyboardService.afisareDimensiuneSub100();
                    break;
                case 6:
                    keyboardService.afisareDimensiunePeste100();
                    break;
                case 7:
                    keyboardService.afisarePretPeste600();
                    break;
                case 8:
                    keyboardService.afisarePretSub600();
                    break;
                case 9:
                    keyboardService.sortareDimensiune();
                    break;
                case 10:
                    keyboardService.sortareAnFabricatie();
                    break;
                case 11:
                    keyboardService.sortarePret();
                    break;
                case 12:
                    addKeyboardRating();
                    break;
                case 13:
                    running = false;
                    break;
                default:
                    System.out.println("Tasta incorecta. Reincercati.");
            }
        }
    }


    private void adaugareKeyboard() {
        System.out.println("Introduceti detaliile tastaturii: ");
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

        Keyboard nou= new Keyboard(marca, model, pret, dimensiune, anFabricatie);
        if (keyboardService.adaugareKeyboard(nou)) {
            System.out.println("Tastatura a fost adaugata cu succes.");
        } else {
            System.out.println("Tastatura exista deja in lista.");
        }
    }
    private void stergereKeyboard() {
        System.out.println("Introduceti marca si modelul tastaturii de sters: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        if (keyboardService.stergereKeyboard(marca, model)) {
            System.out.println("Tastatura a fost stearsa cu succes.");
        } else {
            System.out.println("Tastatura nu a fost gasita in lista.");
        }
    }
    private void editareKeyboard() {
        System.out.println("Introduceti marca si modelul tastaturii: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        if (keyboardService.editareKeyboard(marca, model)) {
            System.out.println("Datele tastaturii au fost actualizate.");
        } else {
            System.out.println("Tastatura nu a fost gasita in lista.");
        }
    }
    private void addKeyboardRating() {
        System.out.println("Introduceti marca si modelul tastaturii pentru adaugarea unui rating: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        if (keyboardService.adaugareRating(marca, model)) {
            System.out.println("Rating-ul a fost adaugat cu succes.");
        } else {
            System.out.println("Tastatura nu a fost gasita in lista.");
        }
    }
}



