package Magazine;

import java.util.Scanner;
import java.util.ArrayList;

public class MagazinView {

    private MagazinService magazinService;
    private Scanner scanner;

    public MagazinView(){
        this.scanner = new Scanner(System.in);
        this.magazinService = new MagazinService();
        this.play();
    }

    private void meniu(){

        //crude

        System.out.println("Apasati tasta 1 pentru a afisa lista de magazine");
        System.out.println("Apasati tasta 2 pentru a adauga un magazin");
        System.out.println("Apasati tasta 3 pentru a sterge un magazin");
        System.out.println("Apasati tasta 4 pentru a edita un magazin");

        System.out.println("\n");

        // filtrare
        System.out.println("Apasati tasta 5 pentru a afisa magazinele cu vanzari peste 25000");
        System.out.println("Apasati tasta 6 pentru a afisa magazinele cu vanzari sub 25000");

        System.out.println( "\n");

        //sortare
        System.out.println("Apasati tasta 7 pentru a sorta lista crescator dupa vanzari");
        System.out.println("Apasati tasta 8 pentru a sorta lista crescator dupa anul deschiderii");

        System.out.println("\n");
        //adaugare rating
        System.out.println("Apasati tasta 9 pentru a adauga un rating");


    }

    private void play() {
        boolean running = true;

        while (running) {
            meniu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    magazinService.afisareMagazine();
                    break;
                case 2:
                    adaugareMagazin();
                    break;
                case 3:
                    stergereMagazin();
                    break;
                case 4:
                    editareMagazin();
                    break;
                case 5:
                    magazinService.afisareVanzariPeste25000();
                    break;
                case 6:
                    magazinService.afisareVanzariSub25000();
                    break;
                case 7:
                    magazinService.sortareVanzari();
                    break;
                case 8:
                    magazinService.sortareAnDeschidere();
                    break;
                case 9:
                    addRating();
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }
    }

    private void adaugareMagazin(){

        System.out.println("Introduceti datele magazinului: ");
        System.out.println("Nume: ");
        String nume = scanner.nextLine();
        System.out.println("Produse: ");
        String produse = scanner.nextLine();
        System.out.println("Locatie: ");
        String locatie = scanner.nextLine();
        System.out.println("Vanzari: ");
        int vanzari = Integer.parseInt(scanner.nextLine());
        System.out.println("Anul deschiderii: ");
        int anDeschidere = Integer.parseInt(scanner.nextLine());

        Magazin nou = new Magazin(nume, produse, locatie, vanzari, anDeschidere);

        if(magazinService.adaugareMagazin(nou)){
            System.out.println("Magazinul a fost adaugat");
        }else{
            System.out.println("Magaziunl nu a fost gasit in lista");
        }

    }

    private void stergereMagazin(){

        System.out.println("Introduceti numele magazinului care doriti sa fie sters: ");
        System.out.println("Nume: ");
        String nume = scanner.nextLine();

        if(magazinService.steregereMagazin(nume)){
            System.out.println("Magazinul a fost sters: ");
        }else{
            System.out.println("Magazinul nu se afla in lista");
        }

    }

    private void editareMagazin(){

        System.out.println("Introduceti numele magazinului care doriti sa fie editat: ");
        System.out.println("Nume: ");
        String nume = scanner.nextLine();

        if(magazinService.editareMagazin(nume)){
            System.out.println("Datele au fost actualizate");
        }else{
            System.out.println("Nu a fost gasit in lista");
        }

    }

    private void addRating() {
        System.out.println("Introduceti numele magazinului pentru adaugarea unui rating: ");
        System.out.print("Nume: ");
        String nume = scanner.nextLine();

        if (magazinService.adaugareRating(nume)) {
            System.out.println("Rating-ul a fost adaugat cu succes.");
        } else {
            System.out.println("Magazinul nu a fost gasita in lista.");
        }
    }

}
