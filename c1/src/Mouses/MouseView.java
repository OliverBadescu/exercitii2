package Mouses;

import java.util.Scanner;
public class MouseView {

    private MouseService mouseService;
    private Scanner scanner = new Scanner(System.in);

    public MouseView(){

        this.mouseService = new MouseService();
        this.play();

    }


    private void meniu(){

        //crude

        System.out.println("Apasati tasta 1 pentru a afisa lista de mouseuri");
        System.out.println("Apasati tasta 2 pentru a adauga un mouse");
        System.out.println("Apasati tasta 3 pentru a sterge un mouse");
        System.out.println("Apasati tasta 4 pentru a edita un mouse");

        System.out.println("\n");

        // filtrare
        System.out.println("Apasati tasta 5 pentru a afisa mouseurile cu gramaj mai mic de 100");
        System.out.println("Apasati tasta 6 pentru a afisa mouseurile cu gramaj mai mare de 100");
        System.out.println("Apasati tasta 7 pentru a afisa mouseurile cu pretul peste 600 lei");
        System.out.println("Apasati tasta 8 pentru a afisa mouseurile cu pretul sub 600 lei");

        System.out.println( "\n");

        //sortare
        System.out.println("Apasati tasta 9 pentru a sorta lista crescator dupa greutate");
        System.out.println("Apasati tasta 10 pentru a sorta lista crescator dupa an de fabricate");
        System.out.println("Apasati tasta 11 pentru a sorta lista crescator dupa pret");

        System.out.println("\n");
        //adaugare rating
        System.out.println("Apasati tasta 12 pentru a adauga un rating");

    }

    private void play(){

        boolean running = true;

        while (running){

            meniu();
            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere){
                case 1:
                    mouseService.afisareMouses();
                    break;
                case 2:
                    adaugareMouse();
                    break;
                case 3:
                    stergereMouse();
                    break;
                case 4:
                    editareMouse();
                    break;
                case 5:
                    mouseService.afisareGramajSub100();
                    break;
                case 6:
                    mouseService.afisareGramajPeste100();
                    break;
                case 7:
                    mouseService.afisarePretPeste600();
                    break;
                case 8:
                    mouseService.afisarePretSub600();
                    break;
                case 9:
                    sortareGreutate();
                    break;
                case 10:
                    sortareAnFabricate();
                    break;
                case 11:
                    sortarePret();
                    break;
                case 12:
                    adaugareRating();
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }

    }

    private void adaugareMouse(){

        System.out.println("Introduceti datele mouseului: ");
        System.out.println("Marca: ");
        String marca = scanner.nextLine();
        System.out.println("Model: ");
        String model = scanner.nextLine();
        System.out.println("Pret: ");
        int pret = Integer.parseInt(scanner.nextLine());
        System.out.println("Greutate: ");
        int greutate = Integer.parseInt(scanner.nextLine());;
        System.out.println("An de fabricatie: ");
        int anFabricatie = Integer.parseInt(scanner.nextLine());;

        Mouse nou = new Mouse (marca, model, pret ,greutate ,anFabricatie);

        if (!mouseService.adaugareMouse(nou)){
            System.out.println("Mouseul se afla deja in lista");
        }else{
            System.out.println("Mouseul a fost adaugat");
        }
    }

    private void stergereMouse(){
        System.out.println("Introduceti marca si modelul mouseului: ");
        System.out.println("Marca: ");
        String marca = scanner.nextLine();
        System.out.println("Model: ");
        String model = scanner.nextLine();

        if(mouseService.stergereMouse(marca, model)){
            System.out.println("Mouseul a fost sters din lista");
        }else{
            System.out.println("Mouseul nu a fost gasit in lista");
        }

    }

    private void editareMouse(){

        System.out.println("Introduceti marca si modelul mouseului: ");
        System.out.println("Marca: ");
        String marca = scanner.nextLine();
        System.out.println("Model: ");
        String model = scanner.nextLine();

        if(mouseService.editareMouse(marca, model)){
            System.out.println("Datele au fost actualizate");
        }else{
            System.out.println("Mouseul nu a fost gasit in lista");
        }

    }

    private void sortarePret(){

        mouseService.sortarePret();
        System.out.println("Lista a fost sortata");

    }

    private void sortareGreutate(){

        mouseService.sortareGreutate();
        System.out.println("Lista a fost sortata");

    }

    private void sortareAnFabricate(){

        mouseService.sortareAnFabricatie();
        System.out.println("Lista a fost sortata");

    }

    private void adaugareRating(){

        System.out.println("Introduceti marca si modelul mouseului care doriti sa il editati: ");
        System.out.println("Marca: ");
        String marca = scanner.nextLine();
        System.out.println("Model: ");
        String model = scanner.nextLine();

        if(mouseService.adaugareRating(marca, model)){
            System.out.println("Ratingul a fost adaugat");
        }else{
            System.out.println("Mouseul nu a fost gasit in lista");
        }

    }

}
