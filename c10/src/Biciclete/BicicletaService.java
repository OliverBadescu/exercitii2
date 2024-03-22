package Biciclete;

import java.util.ArrayList;
import java.util.Scanner;

public class BicicletaService {

    private ArrayList<Bicicleta> biciclete;
    private Scanner scanner = new Scanner(System.in);

    public BicicletaService() {
        this.biciclete = new ArrayList<>();
        this.loadData();
    }

    private void loadData() {

        Bicicleta b1 = new Bicicleta("Trek", "Marlin", 1500, false, 2021);
        Bicicleta b2 = new Bicicleta("Giant", "Defy", 2000, false, 2020);
        Bicicleta b3 = new Bicicleta("Specialized", "Stumpjumper", 3000, true, 2019);
        Bicicleta b4 = new Bicicleta("Cannondale", "Synapse", 1800, false, 2021);
        Bicicleta b5 = new Bicicleta("Scott", "Addict", 2500, false, 2020);
        Bicicleta b6 = new Bicicleta("Bianchi", "Oltre", 3500, true, 2018);
        Bicicleta b7 = new Bicicleta("Cervelo", "S3", 4000, false, 2021);
        Bicicleta b8 = new Bicicleta("Focus", "Izalco", 2200, true, 2019);
        Bicicleta b9 = new Bicicleta("Cube", "Agree", 2800, false, 2020);
        Bicicleta b10 = new Bicicleta("Fuji", "SL", 3200, true, 2017);

        biciclete.add(b1);
        biciclete.add(b2);
        biciclete.add(b3);
        biciclete.add(b4);
        biciclete.add(b5);
        biciclete.add(b6);
        biciclete.add(b7);
        biciclete.add(b8);
        biciclete.add(b9);
        biciclete.add(b10);
    }

    public void afisareBiciclete() {
        for (Bicicleta bicicleta : biciclete) {
            System.out.println(bicicleta.descriere());
        }
    }

    public void afisarePretPeste2000() {
        for (Bicicleta bicicleta : biciclete) {
            if (bicicleta.getPret() > 2000) {
                System.out.println(bicicleta.descriere());
            }
        }
    }

    public void afisarePretSub2000() {
        for (Bicicleta bicicleta : biciclete) {
            if (bicicleta.getPret() < 2000) {
                System.out.println(bicicleta.descriere());
            }
        }
    }

    public void afisareBicicletaUzata() {
        for (Bicicleta bicicleta : biciclete) {
            if (bicicleta.getUzat()) {
                System.out.println(bicicleta.descriere());
            }
        }
    }

    public void afisareBicicletaNoua() {
        for (Bicicleta bicicleta : biciclete) {
            if (!bicicleta.getUzat()) {
                System.out.println(bicicleta.descriere());
            }
        }
    }

    public void sortarePret() {
        boolean sortat = false;
        do {
            sortat = true;
            for (int i = 0; i < biciclete.size() - 1; i++) {
                if (biciclete.get(i).getPret() > biciclete.get(i + 1).getPret()) {
                    Bicicleta aux = biciclete.get(i);
                    biciclete.set(i, biciclete.get(i + 1));
                    biciclete.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);
    }


    public void sortareAnFabricatie() {
        boolean sortat = false;
        do {
            sortat = true;
            for (int i = 0; i < biciclete.size() - 1; i++) {
                if (biciclete.get(i).getAnFabricatie() > biciclete.get(i + 1).getAnFabricatie()) {
                    Bicicleta aux = biciclete.get(i);
                    biciclete.set(i, biciclete.get(i + 1));
                    biciclete.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);
    }

    private Bicicleta findByMarcaSiModel(String marca, String model) {
        for (Bicicleta bicicleta : biciclete) {
            if (bicicleta.getMarca().equals(marca) && bicicleta.getModel().equals(model)) {
                return bicicleta;
            }
        }
        return null;
    }

    public boolean adaugareBicicleta(Bicicleta bicicleta) {
        if (this.findByMarcaSiModel(bicicleta.getMarca(), bicicleta.getModel()) != null) {
            return false;
        }
        this.biciclete.add(bicicleta);
        return true;
    }

    public boolean stergereBicicleta(String marca, String model) {
        Bicicleta bicicleta = findByMarcaSiModel(marca, model);
        if (bicicleta != null) {
            this.biciclete.remove(bicicleta);
            return true;
        }
        return false;
    }

    public boolean editareBicicleta(String marca, String model) {
        Bicicleta bicicleta = findByMarcaSiModel(marca, model);
        if (bicicleta != null) {
            System.out.println("Ce doriti sa modificati?");
            System.out.println("1. Pret");
            System.out.println("2. An de fabricatie");
            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1:
                    System.out.println("Introduceti noul pret: ");
                    int pret = Integer.parseInt(scanner.nextLine());
                    bicicleta.setPret(pret);
                    break;
                case 2:
                    System.out.println("Introduceti noul an de fabricatie: ");
                    int anFabricatie = Integer.parseInt(scanner.nextLine());
                    bicicleta.setAnFabricatie(anFabricatie);
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
            return true;
        }
        return false;
    }

    public boolean adaugareRating(String marca, String model) {
        Bicicleta nou = findByMarcaSiModel(marca, model);
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
