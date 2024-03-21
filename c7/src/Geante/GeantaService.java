package Geante;
import java.util.ArrayList;
import java.util.Scanner;

public class GeantaService {

    private ArrayList<Geanta> bags;
    private Scanner scanner = new Scanner(System.in);

    public GeantaService(){
        this.bags = new ArrayList<>();
        this.loadData();
    }

    private void loadData(){

        Geanta g1 = new Geanta("Louis Vuitton", "Speedy", 2000, 30, 2021);
        Geanta g2 = new Geanta("Gucci", "Marmont", 2500, 25, 2020);
        Geanta g3 = new Geanta("Prada", "Re-Edition", 1800, 28, 2021);
        Geanta g4 = new Geanta("Chanel", "Classic Flap", 5000, 20, 2019);
        Geanta g5 = new Geanta("Hermes", "Birkin", 10000, 35, 2020);
        Geanta g6 = new Geanta("Michael Kors", "Jet Set", 300, 22, 2021);
        Geanta g7 = new Geanta("Coach", "Tabby", 400, 24, 2020);
        Geanta g8 = new Geanta("Kate Spade", "Margaux", 350, 26, 2019);
        Geanta g9 = new Geanta("Longchamp", "Le Pliage", 150, 27, 2020);
        Geanta g10 = new Geanta("Fendi", "Peekaboo", 3500, 29, 2018);

        bags.add(g1);
        bags.add(g2);
        bags.add(g3);
        bags.add(g4);
        bags.add(g5);
        bags.add(g6);
        bags.add(g7);
        bags.add(g8);
        bags.add(g9);
        bags.add(g10);

    }

    public void afisareGenti(){
        for (int i =0 ; i < bags.size();i++){
            System.out.println(bags.get(i).descriere());
        }
    }

    public void afisareDimensiunePeste25() {
        for (int i = 0; i < bags.size(); i++) {
            if (bags.get(i).getDimensiune() > 25) {
                System.out.println(bags.get(i).descriere());
            }
        }
    }

    public void afisareDimensiuneSub25() {
        for (int i = 0; i < bags.size(); i++) {
            if (bags.get(i).getDimensiune() < 25) {
                System.out.println(bags.get(i).descriere());
            }
        }
    }

    public void afisarePretPeste500() {
        for (int i = 0; i < bags.size(); i++) {
            if (bags.get(i).getPret() >500) {
                System.out.println(bags.get(i).descriere());
            }
        }
    }

    public void afisarePretSub500() {
        for (int i = 0; i < bags.size(); i++) {
            if (bags.get(i).getPret() <500) {
                System.out.println(bags.get(i).descriere());
            }
        }
    }


    private Geanta findByMarcaSiModel(String marca, String model){

        for (int i =0 ; i < bags.size();i++){
            if(bags.get(i).getMarca().equals(marca) && bags.get(i).getModel().equals(model)){
                return bags.get(i);
            }
        }
        return null;
    }

    public boolean adaugareGeanta(Geanta geanta){

        if (this.findByMarcaSiModel(geanta.getMarca(), geanta.getModel()) != null){
            return false;
        }
        this.bags.add(geanta);
        return true;

    }

    public boolean stergereGeanta(String marca, String model){

        for (int i =0 ; i < bags.size();i++){
            if(bags.get(i).getMarca().equals(marca) && bags.get(i).getModel().equals(model)){
                this.bags.remove(bags.get(i));
                return true;
            }
        }
        return false;
    }

    public boolean editareGeanta(String marca, String model) {
        Geanta geanta = findByMarcaSiModel(marca, model);
        if (geanta != null) {
            System.out.println("Ce doriti sa modificati?");
            System.out.println("1. Pret");
            System.out.println("2. Dimensiune");
            System.out.println("3. An de fabricatie");

            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1:
                    System.out.println("Introduceti noul pret: ");
                    int pret = Integer.parseInt(scanner.nextLine());
                    geanta.setPret(pret);
                    break;
                case 2:
                    System.out.println("Introduceti noua dimensiune");
                    int dimensiune = Integer.parseInt(scanner.nextLine());
                    geanta.setDimensiune(dimensiune);
                    break;
                case 3:
                    System.out.println("Introduceti noul an de fabricatie: ");
                    int anFabricatie = Integer.parseInt(scanner.nextLine());
                    geanta.setAnFabricatie(anFabricatie);
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
            for (int i = 0; i < bags.size() - 1; i++) {
                if (bags.get(i).getPret() > bags.get(i + 1).getPret()) {
                    Geanta aux = bags.get(i);
                    bags.set(i, bags.get(i + 1));
                    bags.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);
    }

    public void sortareDimensiune() {
        boolean sortat = false;
        do {
            sortat = true;
            for (int i = 0; i < bags.size() - 1; i++) {
                if (bags.get(i).getDimensiune() > bags.get(i + 1).getDimensiune()) {
                    Geanta aux = bags.get(i);
                    bags.set(i, bags.get(i + 1));
                    bags.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);
    }

    public void sortareAnFabricatie() {
        boolean sortat = false;
        do {
            sortat = true;
            for (int i = 0; i < bags.size() - 1; i++) {
                if (bags.get(i).getAnFabricatie() > bags.get(i + 1).getAnFabricatie()) {
                    Geanta aux = bags.get(i);
                    bags.set(i, bags.get(i + 1));
                    bags.set(i + 1, aux);
                    sortat = false;
                }
            }
        }while (!sortat);
    }

    public boolean adaugareRating(String marca, String model) {
        Geanta nou = findByMarcaSiModel(marca, model);
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
