package Shoes;


import java.util.ArrayList;
import java.util.Scanner;
public class ShoeService {

    private ArrayList<Shoe> shoes;
    private Scanner scanner = new Scanner(System.in);

    public ShoeService(){
        this.shoes = new ArrayList<>();
        this.loadData();

    }

    private void loadData(){

        Shoe p1 = new Shoe("Nike", "Air Force 1", 150, 42, 2021);
        Shoe p2 = new Shoe("Adidas", "Stan Smith", 100, 40, 2020);
        Shoe p3 = new Shoe("Puma", "Suede Classic", 80, 41, 2019);
        Shoe p4 = new Shoe("Reebok", "Classic Leather", 90, 39, 2020);
        Shoe p5 = new Shoe("Vans", "Old Skool", 70, 38, 2018);
        Shoe p6 = new Shoe("Converse", "Chuck Taylor All Star", 60, 37, 2019);
        Shoe p7 = new Shoe("New Balance", "574", 120, 43, 2021);
        Shoe p8 = new Shoe("Asics", "Gel-Kayano 27", 160, 44, 2020);
        Shoe p9 = new Shoe("Fila", "Disruptor II", 75, 41, 2019);
        Shoe p10 = new Shoe("Skechers", "D'Lites", 50, 39, 2021);

        shoes.add(p1);
        shoes.add(p2);
        shoes.add(p3);
        shoes.add(p4);
        shoes.add(p5);
        shoes.add(p6);
        shoes.add(p7);
        shoes.add(p8);
        shoes.add(p9);
        shoes.add(p10);


    }

    public void afisareShoes(){

        for (int i =0 ; i < shoes.size();i++){
            System.out.println(shoes.get(i).descriere());
        }

    }
    public void afisarePretPeste100(){

        for (int i = 0; i < shoes.size(); i++) {
            if (shoes.get(i).getPret() > 100) {
                System.out.println(shoes.get(i).descriere());
            }
        }

    }
    public void afisarePretSub100(){

        for (int i = 0; i < shoes.size(); i++) {
            if (shoes.get(i).getPret() < 100) {
                System.out.println(shoes.get(i).descriere());
            }
        }

    }
    public void afisareMarimePeste40(){
        for (int i = 0; i < shoes.size(); i++) {
            if (shoes.get(i).getMarime() > 40) {
                System.out.println(shoes.get(i).descriere());
            }
        }
    }
    public void afisareMarimeSub40(){
        for (int i = 0; i < shoes.size(); i++) {
            if (shoes.get(i).getMarime() < 40) {
                System.out.println(shoes.get(i).descriere());
            }
        }


    }

    private Shoe findByMarcaSiModel(String marca, String model){

        for (int i =0 ; i < shoes.size();i++){
            if(shoes.get(i).getMarca().equals(marca) && shoes.get(i).getModel().equals(model)){
                return shoes.get(i);
            }
        }
        return null;
    }
    public boolean adaugareShoe(Shoe shoe){

        if (this.findByMarcaSiModel(shoe.getMarca(), shoe.getModel())!= null){
            return false;
        }
        this.shoes.add(shoe);
        return true;

    }
    public boolean stergereShoe(String marca, String model){

        for (int i =0 ; i < shoes.size();i++){
            if(shoes.get(i).getMarca().equals(marca) && shoes.get(i).getModel().equals(model)){
                this.shoes.remove(shoes.get(i));
                return true;
            }
        }
        return false;

    }
    public boolean editareShoe(String marca, String model){

        Shoe shoe = findByMarcaSiModel(marca, model);
        if(shoe != null){
            System.out.println("Ce doriti sa modificati?");
            System.out.println("1. Pret");
            System.out.println("2. Marime");
            System.out.println("3. An de fabricatie");

            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1:
                    System.out.println("Introduceti noul pret: ");
                    int pret = Integer.parseInt(scanner.nextLine());
                    shoe.setPret(pret);
                    break;
                case 2:
                    System.out.println("Introduceti noua marime: ");
                    int marime = Integer.parseInt(scanner.nextLine());
                    shoe.setMarime(marime);
                    break;
                case 3:
                    System.out.println("Introduceti noul an de fabricatie: ");
                    int anFabricatie = Integer.parseInt(scanner.nextLine());
                    shoe.setAnFabricatie(anFabricatie);
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
            for (int i = 0; i < shoes.size() - 1; i++) {
                if (shoes.get(i).getPret() > shoes.get(i + 1).getPret()) {
                    Shoe aux = shoes.get(i);
                    shoes.set(i, shoes.get(i + 1));
                    shoes.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);
    }

    public void sortareMarime() {
        boolean sortat = false;
        do {
            sortat = true;
            for (int i = 0; i < shoes.size() - 1; i++) {
                if (shoes.get(i).getMarime() > shoes.get(i + 1).getMarime()) {
                    Shoe aux = shoes.get(i);
                    shoes.set(i, shoes.get(i + 1));
                    shoes.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);
    }

    public void sortareAnFabricatie() {
        boolean sortat = false;
        do {
            sortat = true;
            for (int i = 0; i < shoes.size() - 1; i++) {
                if (shoes.get(i).getAnFabricatie() > shoes.get(i + 1).getAnFabricatie()) {
                    Shoe aux = shoes.get(i);
                    shoes.set(i, shoes.get(i + 1));
                    shoes.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);
    }

    public boolean adaugareRating(String marca, String model) {
        Shoe nou = findByMarcaSiModel(marca, model);
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
