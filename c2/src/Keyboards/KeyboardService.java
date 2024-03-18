package Keyboards;

import java.util.ArrayList;
import java.util.Scanner;

public class KeyboardService {

    private ArrayList<Keyboard> keyboardList;
    private Scanner scanner = new Scanner(System.in);

    public KeyboardService() {
        this.keyboardList = new ArrayList<>();
        this.loadData();
    }

    private void loadData() {
        Keyboard k1 = new Keyboard("Logitech", "G Pro X", 400, 104, 2019);
        Keyboard k2 = new Keyboard("Razer", "BlackWidow Elite", 600, 104, 2020);
        Keyboard k3 = new Keyboard("Corsair", "K95 RGB Platinum", 700, 110, 2018);
        Keyboard k4 = new Keyboard("SteelSeries", "Apex Pro", 550, 104, 2019);
        Keyboard k5 = new Keyboard("HyperX", "Alloy FPS RGB", 450, 104, 2021);
        Keyboard k6 = new Keyboard("Ducky", "One 2 Mini", 250, 61, 2019);
        Keyboard k7 = new Keyboard("Cooler Master", "MasterKeys Pro L", 350, 104, 2017);
        Keyboard k8 = new Keyboard("Glorious PC Gaming Race", "GMMK Full-Size", 200, 104, 2020);
        Keyboard k9 = new Keyboard("Varmilo", "VA88M Double Rainbow", 300, 88, 2021);
        Keyboard k10 = new Keyboard("ASUS", "ROG Strix Scope RX", 500, 104, 2020);

        keyboardList.add(k1);
        keyboardList.add(k2);
        keyboardList.add(k3);
        keyboardList.add(k4);
        keyboardList.add(k5);
        keyboardList.add(k6);
        keyboardList.add(k7);
        keyboardList.add(k8);
        keyboardList.add(k9);
        keyboardList.add(k10);
    }

    public void afisareKeyboards() {
        for (int i = 0; i < keyboardList.size(); i++) {
            System.out.println(keyboardList.get(i).descriere());
        }
    }

    public void afisareDimensiunePeste100() {
        for (int i = 0; i < keyboardList.size(); i++) {
            if (keyboardList.get(i).getDimensiune() > 100) {
                System.out.println(keyboardList.get(i).descriere());
            }
        }
    }

    public void afisareDimensiuneSub100() {
        for (int i = 0; i < keyboardList.size(); i++) {
            if (keyboardList.get(i).getDimensiune() <= 100) {
                System.out.println(keyboardList.get(i).descriere());
            }
        }
    }

    public void afisarePretPeste600() {
        for (int i = 0; i < keyboardList.size(); i++) {
            if (keyboardList.get(i).getPret() > 600) {
                System.out.println(keyboardList.get(i).descriere());
            }
        }
    }

    public void afisarePretSub600() {
        for (int i = 0; i < keyboardList.size(); i++) {
            if (keyboardList.get(i).getPret() <= 600) {
                System.out.println(keyboardList.get(i).descriere());
            }
        }
    }

    private Keyboard findByMarcaSiModel(String marca, String model) {
        for (int i = 0; i < keyboardList.size(); i++) {
            if (keyboardList.get(i).getMarca().equals(marca) && keyboardList.get(i).getModel().equals(model)) {
                return keyboardList.get(i);
            }
        }
        return null;
    }

    public boolean adaugareKeyboard(Keyboard keyboard) {
        if (this.findByMarcaSiModel(keyboard.getMarca(), keyboard.getModel()) != null) {
            return false;
        }
        this.keyboardList.add(keyboard);
        return true;
    }

    public boolean stergereKeyboard(String marca, String model) {
        for (int i = 0; i < keyboardList.size(); i++) {
            if (keyboardList.get(i).getMarca().equals(marca) && keyboardList.get(i).getModel().equals(model)) {
                this.keyboardList.remove(keyboardList.get(i));
                return true;
            }
        }
        return false;
    }

    public boolean editareKeyboard(String marca, String model) {
        Keyboard keyboard = findByMarcaSiModel(marca, model);
        if (keyboard != null) {
            System.out.println("Ce doriti sa modificati?");
            System.out.println("1. Pret");
            System.out.println("2. Dimensiune");
            System.out.println("3. An de fabricatie");

            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1:
                    System.out.println("Introduceti noul pret: ");
                    int pret = Integer.parseInt(scanner.nextLine());
                    keyboard.setPret(pret);
                    break;
                case 2:
                    System.out.println("Introduceti noua dimensiune");
                    int dimensiune = Integer.parseInt(scanner.nextLine());
                    keyboard.setDimensiune(dimensiune);
                    break;
                case 3:
                    System.out.println("Introduceti noul an de fabricatie: ");
                    int anFabricatie = Integer.parseInt(scanner.nextLine());
                    keyboard.setAnFabricatie(anFabricatie);
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
            for (int i = 0; i < keyboardList.size() - 1; i++) {
                if (keyboardList.get(i).getPret() > keyboardList.get(i + 1).getPret()) {
                    Keyboard aux = keyboardList.get(i);
                    keyboardList.set(i, keyboardList.get(i + 1));
                    keyboardList.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);
    }

    public void sortareDimensiune() {
        boolean sortat = false;
        do {
            sortat = true;
            for (int i = 0; i < keyboardList.size() - 1; i++) {
                if (keyboardList.get(i).getDimensiune() > keyboardList.get(i + 1).getDimensiune()) {
                    Keyboard aux = keyboardList.get(i);
                    keyboardList.set(i, keyboardList.get(i + 1));
                    keyboardList.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);
    }

    public void sortareAnFabricatie() {
        boolean sortat = false;
        do {
            sortat = true;
            for (int i = 0; i < keyboardList.size() - 1; i++) {
                if (keyboardList.get(i).getAnFabricatie() > keyboardList.get(i + 1).getAnFabricatie()) {
                    Keyboard aux = keyboardList.get(i);
                    keyboardList.set(i, keyboardList.get(i + 1));
                    keyboardList.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);
    }

    public boolean adaugareRating(String marca, String model) {
        Keyboard nou = findByMarcaSiModel(marca, model);
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