package Televizoare;

import java.util.ArrayList;
import java.util.Scanner;

public class TelevizorService {


    private ArrayList<Televizor> televizors;
    private Scanner scanner = new Scanner(System.in);

    public TelevizorService(){
        this.televizors = new ArrayList<>();
        this.loadData();
    }

    private void loadData(){

        Televizor t1 = new Televizor("LG", "OLED C1", 2000, 55, 2021);
        Televizor t2 = new Televizor("Sony", "Bravia XR A90J", 3000, 65, 2021);
        Televizor t3 = new Televizor("Samsung", "Neo QLED QN800A", 2500, 75, 2021);
        Televizor t4 = new Televizor("Hisense", "U7G", 1000, 55, 2021);
        Televizor t5 = new Televizor("TCL", "4-Series", 400, 50, 2021);
        Televizor t6 = new Televizor("Vizio", "M-Series Quantum", 700, 65, 2021);
        Televizor t7 = new Televizor("Panasonic", "JX800", 900, 58, 2021);
        Televizor t8 = new Televizor("Philips", "PUS9006", 1100, 65, 2021);
        Televizor t9 = new Televizor("Sharp", "AQOUS 70", 1500, 70, 2021);
        Televizor t10 = new Televizor("Skyworth", "Q71 Series", 800, 55, 2021);


        televizors.add(t1);
        televizors.add(t2);
        televizors.add(t3);
        televizors.add(t4);
        televizors.add(t5);
        televizors.add(t6);
        televizors.add(t7);
        televizors.add(t8);
        televizors.add(t9);
        televizors.add(t10);

    }

    public void afisareTelevozare(){
        for (int i =0 ; i < televizors.size();i++){
            System.out.println(televizors.get(i).descriere());
        }

    }

    public void afisareDimensiunePeste60() {
        for (int i = 0; i < televizors.size(); i++) {
            if (televizors.get(i).getDimensiune() > 60) {
                System.out.println(televizors.get(i).descriere());
            }
        }
    }

    public void afisareDimensiuneSub60() {
        for (int i = 0; i < televizors.size(); i++) {
            if (televizors.get(i).getDimensiune() < 60) {
                System.out.println(televizors.get(i).descriere());
            }
        }
    }

    public void afisarePretPeste1000() {
        for (int i = 0; i < televizors.size(); i++) {
            if (televizors.get(i).getPret() >1000) {
                System.out.println(televizors.get(i).descriere());
            }
        }
    }

    public void afisarePretSub1000() {
        for (int i = 0; i < televizors.size(); i++) {
            if (televizors.get(i).getPret() <1000) {
                System.out.println(televizors.get(i).descriere());
            }
        }
    }


    private Televizor findByMarcaSiModel(String marca, String model){

        for (int i =0 ; i < televizors.size();i++){
            if(televizors.get(i).getMarca().equals(marca) && televizors.get(i).getModel().equals(model)){
                return televizors.get(i);
            }
        }
        return null;
    }

    public boolean adaugareTelevizor(Televizor televizor){

        if (this.findByMarcaSiModel(televizor.getMarca(), televizor.getModel()) != null){
            return false;
        }
        this.televizors.add(televizor);
        return true;

    }

    public boolean stergereTelevizor(String marca, String model){

        for (int i =0 ; i < televizors.size();i++){
            if(televizors.get(i).getMarca().equals(marca) && televizors.get(i).getModel().equals(model)){
                this.televizors.remove(televizors.get(i));
                return true;
            }
        }
        return false;
    }

    public boolean editareTelevizor(String marca, String model) {
        Televizor televizor = findByMarcaSiModel(marca, model);
        if (televizor != null) {
            System.out.println("Ce doriti sa modificati?");
            System.out.println("1. Pret");
            System.out.println("2. Dimensiune");
            System.out.println("3. An de fabricatie");

            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1:
                    System.out.println("Introduceti noul pret: ");
                    int pret = Integer.parseInt(scanner.nextLine());
                    televizor.setPret(pret);
                    break;
                case 2:
                    System.out.println("Introduceti noua dimensiune");
                    int dimensiune = Integer.parseInt(scanner.nextLine());
                    televizor.setDimensiune(dimensiune);
                    break;
                case 3:
                    System.out.println("Introduceti noul an de fabricatie: ");
                    int anFabricatie = Integer.parseInt(scanner.nextLine());
                    televizor.setAnFabricatie(anFabricatie);
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
            return true;
        }
        return false;
    }

    public void sortarePret() {
        boolean sortat = false;
        do {
            sortat = true;
            for (int i = 0; i < televizors.size() - 1; i++) {
                if (televizors.get(i).getPret() > televizors.get(i + 1).getPret()) {
                    Televizor aux = televizors.get(i);
                    televizors.set(i, televizors.get(i + 1));
                    televizors.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);
    }

    public void sortareDimensiune() {
        boolean sortat = false;
        do {
            sortat = true;
            for (int i = 0; i < televizors.size() - 1; i++) {
                if (televizors.get(i).getDimensiune() > televizors.get(i + 1).getDimensiune()) {
                    Televizor aux = televizors.get(i);
                    televizors.set(i, televizors.get(i + 1));
                    televizors.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);
    }

    public void sortareAnFabricatie() {
        boolean sortat = false;
        do {
            sortat = true;
            for (int i = 0; i < televizors.size() - 1; i++) {
                if (televizors.get(i).getAnFabricatie() > televizors.get(i + 1).getAnFabricatie()) {
                    Televizor aux = televizors.get(i);
                    televizors.set(i, televizors.get(i + 1));
                    televizors.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);
    }

    public boolean adaugareRating(String marca, String model) {
        Televizor nou = findByMarcaSiModel(marca, model);
        if (nou != null) {
            System.out.println("Introduceti ratingul dorit:");
            double rating = Double.parseDouble(scanner.nextLine());

            double ratingVechi = nou.getRating() * nou.getNrReviewuri();
            double ratingTotal = ratingVechi + rating;
            nou.adaugareNrReviewuri();
            double ratingNou = ratingTotal / nou.getNrReviewuri();
            nou.setRating(ratingNou);

            return true;
        }
        return false;
    }
}
