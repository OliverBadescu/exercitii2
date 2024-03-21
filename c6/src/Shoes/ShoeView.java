package Shoes;
import java.util.Scanner;
import java.util.ArrayList;
public class ShoeView {

    private ShoeService shoeService;
    private Scanner scanner;

    public ShoeView(){
        this.scanner = new Scanner(System.in);
        this.shoeService = new ShoeService();
        this.play();
    }

    private void meniu(){

        //crude

        System.out.println("Apasati tasta 1 pentru a afisa lista de papuci");
        System.out.println("Apasati tasta 2 pentru a adauga un papuc");
        System.out.println("Apasati tasta 3 pentru a sterge un papuc");
        System.out.println("Apasati tasta 4 pentru a edita un papuc");

        System.out.println("\n");

        // filtrare
        System.out.println("Apasati tasta 5 pentru a afisa papucii cu pret peste 100 lei");
        System.out.println("Apasati tasta 6 pentru a afisa papucii cu pret sub 100 lei");
        System.out.println("Apasati tasta 7 pentru a afisa papucii cu marime peste 40");
        System.out.println("Apasati tasta 8 pentru a afisa papucii cu marime sub 40");

        System.out.println( "\n");

        //sortare
        System.out.println("Apasati tasta 9 pentru a sorta lista crescator dupa marime");
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
                    shoeService.afisareShoes();
                    break;
                case 2:
                    adaugareShoe();
                    break;
                case 3:
                    stergereShoe();
                    break;
                case 4:
                    editareShoe();
                    break;
                case 5:
                    shoeService.afisarePretPeste100();
                    break;
                case 6:
                    shoeService.afisarePretSub100();
                    break;
                case 7:
                    shoeService.afisareMarimePeste40();
                    break;
                case 8:
                    shoeService.afisareMarimeSub40();
                    break;
                case 9:
                    shoeService.sortareMarime();
                    break;
                case 10:
                    shoeService.sortareAnFabricatie();
                    break;
                case 11:
                    shoeService.sortarePret();
                    break;
                case 12:
                    addRating();
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }
    }

    private void adaugareShoe(){

        System.out.println("Introduceti detaliile papucului: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Pret: ");
        int pret = Integer.parseInt(scanner.nextLine());
        System.out.print("Marime: ");
        int marime = Integer.parseInt(scanner.nextLine());
        System.out.print("An de fabricatie: ");
        int anFabricatie = Integer.parseInt(scanner.nextLine());

        Shoe nou= new Shoe(marca, model, pret, marime, anFabricatie);
        if (shoeService.adaugareShoe(nou)) {
            System.out.println("Papucul a fost adaugata cu succes.");
        } else {
            System.out.println("Papucul exista deja in lista.");
        }

    }

    private void stergereShoe() {
        System.out.println("Introduceti marca si modelul papucului de sters: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        if (shoeService.stergereShoe(marca, model)) {
            System.out.println("Papucul a fost stearsa cu succes.");
        } else {
            System.out.println("Papucul nu a fost gasita in lista.");
        }
    }
    private void editareShoe() {
        System.out.println("Introduceti marca si modelul papucului: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        if (shoeService.editareShoe(marca, model)) {
            System.out.println("Datele papucului au fost actualizate.");
        } else {
            System.out.println("Papucului nu a fost gasita in lista.");
        }
    }
    private void addRating() {
        System.out.println("Introduceti marca si modelul papucului pentru adaugarea unui rating: ");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();

        if (shoeService.adaugareRating(marca, model)) {
            System.out.println("Rating-ul a fost adaugat cu succes.");
        } else {
            System.out.println("Papucului nu a fost gasita in lista.");
        }
    }

}
