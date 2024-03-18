package Mouses;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MouseService {

    private ArrayList<Mouse> mouseList;
    private Scanner scanner = new Scanner(System.in);

    public MouseService(){

        this.mouseList = new ArrayList<>();

        this.loadData();

    }

    private void loadData(){

        Mouse m1 = new Mouse("Logitech", "Pro" , 500, 100, 2019);
        Mouse m2 = new Mouse("Razer", "DeathAdder", 600, 95, 2020);
        Mouse m3 = new Mouse("SteelSeries", "Rival 600", 700, 105, 2018);
        Mouse m4 = new Mouse("Corsair", "M65 Elite", 550, 98, 2019);
        Mouse m5 = new Mouse("Logitech", "G502 Hero", 650, 102, 2021);
        Mouse m6 = new Mouse("HyperX", "Pulsefire FPS Pro", 480, 96, 2017);
        Mouse m7 = new Mouse("Roccat", "Kone AIMO", 520, 97, 2019);
        Mouse m8 = new Mouse("Microsoft", "Pro IntelliMouse", 580, 99, 2020);
        Mouse m9 = new Mouse("Asus", "ROG Gladius II", 620, 101, 2018);
        Mouse m10 = new Mouse("SteelSeries", "Sensei Ten", 700, 100, 2020);


        mouseList.add(m1);
        mouseList.add(m2);
        mouseList.add(m3);
        mouseList.add(m4);
        mouseList.add(m5);
        mouseList.add(m6);
        mouseList.add(m7);
        mouseList.add(m8);
        mouseList.add(m9);
        mouseList.add(m10);

    }

    // afisari

    public void afisareMouses(){

        for (int i =0;  i < mouseList.size(); i++){
            System.out.println(mouseList.get(i).descriere());
        }

    }
    public void afisareGramajPeste100(){

        for (int i = 0; i < mouseList.size(); i++){
            if(mouseList.get(i).getGreutate() >= 100){
                System.out.println(mouseList.get(i).descriere());
            }
        }

    }
    public void afisareGramajSub100(){

        for (int i = 0; i < mouseList.size(); i++){
            if(mouseList.get(i).getGreutate() < 100){
                System.out.println(mouseList.get(i).descriere());
            }
        }

    }
    public void afisarePretPeste600(){

        for (int i = 0; i < mouseList.size(); i++){
            if(mouseList.get(i).getPret() >= 600){
                System.out.println(mouseList.get(i).descriere());
            }
        }

    }
    public void afisarePretSub600(){

        for (int i = 0; i < mouseList.size(); i++){
            if(mouseList.get(i).getPret() < 600){
                System.out.println(mouseList.get(i).descriere());
            }
        }

    }

    // crude

    private Mouse findByMarcaSiModel(String marca, String model){

        for (int i = 0 ; i < mouseList.size(); i++){
            if(mouseList.get(i).getMarca().equals(marca) && mouseList.get(i).getModel().equals(model)){
                return mouseList.get(i);
            }
        }
        return null;
    }

    public boolean adaugareMouse(Mouse mouse){

        if (this.findByMarcaSiModel(mouse.getMarca(),mouse.getModel()) != null){
            return false;
        }
        this.mouseList.add(mouse);
        return true;

    }

    public boolean stergereMouse(String marca, String model){

        for (int i =0 ; i < mouseList.size(); i++){
            if (mouseList.get(i).getMarca().equals(marca) && mouseList.get(i).getModel().equals(model)){

                this.mouseList.remove(mouseList.get(i));
                return true;

            }
        }
        return false;
    }

    public boolean editareMouse(String marca, String model){

        Mouse mouse = findByMarcaSiModel(marca,model );

        if (mouse != null){

            System.out.println("Ce doriti sa modificati?");
            System.out.println("1. Pret");
            System.out.println("2. Greutatea");
            System.out.println("3. An de fabricatie");

            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere){

                case 1:
                    System.out.println("Introduceti noul pret: ");
                    int pret = Integer.parseInt(scanner.nextLine());
                    mouse.setPret(pret);
                    break;
                case 2:
                    System.out.println("Introduceti noua greutate");
                    int greutate = Integer.parseInt(scanner.nextLine());
                    mouse.setGreutate(greutate);
                    break;
                case 3:
                    System.out.println("Introduceti noul an de fabricatie: ");
                    int anFabricatie = Integer.parseInt(scanner.nextLine());
                    mouse.setAnFabricatie(anFabricatie);
                    break;

                default:
                    System.out.println("Tasta incorecta");
            }

            return true;
        }
        return false;
    }


    // sortare

    public void sortarePret(){

        boolean sortat = false;

        do{
            sortat = true;

            for (int i =0; i < mouseList.size()-1; i++){
                if(mouseList.get(i).getPret() > mouseList.get(i+1).getPret()){

                    Mouse aux=mouseList.get(i);
                    mouseList.set(i,mouseList.get(i+1));
                    mouseList.set(i+1,aux);

                    sortat = false;
                }
            }
        }while (!sortat);


    }

    public void sortareGreutate(){

        boolean sortat = false;

        do{
            sortat = true;

            for (int i =0; i < mouseList.size()-1; i++){
                if(mouseList.get(i).getGreutate() > mouseList.get(i+1).getGreutate()){

                    Mouse aux=mouseList.get(i);
                    mouseList.set(i,mouseList.get(i+1));
                    mouseList.set(i+1,aux);

                    sortat = false;
                }
            }
        }while (!sortat);


    }

    public void sortareAnFabricatie(){

        boolean sortat = false;

        do{
            sortat = true;

            for (int i =0; i < mouseList.size()-1; i++){
                if(mouseList.get(i).getAnFabricatie() > mouseList.get(i+1).getAnFabricatie()){

                    Mouse aux=mouseList.get(i);
                    mouseList.set(i,mouseList.get(i+1));
                    mouseList.set(i+1,aux);

                    sortat = false;
                }
            }
        }while (!sortat);


    }

    // rating

    public boolean adaugareRating(String marca, String model){

        Mouse nou = findByMarcaSiModel(marca, model);

        if (nou != null){
            System.out.println("Introduceti ratingul dorit:");
            double rating = Double.parseDouble(scanner.nextLine());


            double ratingVechi= nou.getRating() * nou.getNrReviewuri();
            double ratingTotal = ratingVechi + rating;
            nou.adaugareNrReviewuri();
            double ratingNou = ratingTotal / nou.getNrReviewuri();
            nou.setRating(ratingNou);

            return true;
        }
        return false;
    }

}
