package Motor;

import java.util.ArrayList;
import java.util.Scanner;

public class MotorService {

    private ArrayList<Motor> motors;
    private Scanner scanner = new Scanner(System.in);

    public MotorService() {
        this.motors = new ArrayList<>();
        this.loadData();
    }

    private void loadData() {

        Motor m1 = new Motor("BMW", "S1000RR", 15000, false, 2021);
        Motor m2 = new Motor("Ducati", "Panigale V4", 25000, false, 2020);
        Motor m3 = new Motor("Honda", "CBR1000RR-R Fireblade SP", 30000, false, 2021);
        Motor m4 = new Motor("Kawasaki", "Ninja ZX-10R", 18000, false, 2019);
        Motor m5 = new Motor("Suzuki", "GSX-R1000R", 17000, false, 2020);
        Motor m6 = new Motor("Yamaha", "YZF-R1", 16000, false, 2021);
        Motor m7 = new Motor("Aprilia", "RSV4 1100 Factory", 28000, false, 2020);
        Motor m8 = new Motor("Triumph", "Daytona Moto2 765", 22000, false, 2021);
        Motor m9 = new Motor("MV Agusta", "F4 RR", 35000, false, 2019);
        Motor m10 = new Motor("KTM", "RC8C", 30000, false, 2021);

        motors.add(m1);
        motors.add(m2);
        motors.add(m3);
        motors.add(m4);
        motors.add(m5);
        motors.add(m6);
        motors.add(m7);
        motors.add(m8);
        motors.add(m9);
        motors.add(m10);
    }

    public void afisareMotociclete() {
        for (int i = 0; i < motors.size(); i++) {
            System.out.println(motors.get(i).descriere());
        }
    }

    public void afisarePretPeste20000() {
        for (int i = 0; i < motors.size(); i++) {
            if (motors.get(i).getPret() > 20000) {
                System.out.println(motors.get(i).descriere());
            }
        }
    }

    public void afisarePretSub20000() {
        for (int i = 0; i < motors.size(); i++) {
            if (motors.get(i).getPret() < 20000) {
                System.out.println(motors.get(i).descriere());
            }
        }
    }

    public void afisareMotorUzat() {
        for (int i = 0; i < motors.size(); i++) {
            if (motors.get(i).getUzat()) {
                System.out.println(motors.get(i).descriere());
            }
        }
    }

    public void afisareMotorNou() {
        for (int i = 0; i < motors.size(); i++) {
            if (!motors.get(i).getUzat()) {
                System.out.println(motors.get(i).descriere());
            }
        }
    }

    public void sortarePret() {
        boolean sortat = false;
        do {
            sortat = true;
            for (int i = 0; i < motors.size() - 1; i++) {
                if (motors.get(i).getPret() > motors.get(i + 1).getPret()) {
                    Motor aux = motors.get(i);
                    motors.set(i, motors.get(i + 1));
                    motors.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);
    }

    public void sortareAnFabricatie() {
        boolean sortat = false;
        do {
            sortat = true;
            for (int i = 0; i < motors.size() - 1; i++) {
                if (motors.get(i).getAnFabricatie() > motors.get(i + 1).getAnFabricatie()) {
                    Motor aux = motors.get(i);
                    motors.set(i, motors.get(i + 1));
                    motors.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);
    }

    private Motor findByMarcaSiModel(String marca, String model) {

        for (int i = 0; i < motors.size(); i++) {
            if (motors.get(i).getMarca().equals(marca) && motors.get(i).getModel().equals(model)) {
                return motors.get(i);
            }
        }
        return null;
    }

    public boolean adaugareMotor(Motor motor) {

        if (this.findByMarcaSiModel(motor.getMarca(), motor.getModel()) != null) {
            return false;
        }
        this.motors.add(motor);
        return true;

    }

    public boolean stergereMotor(String marca, String model) {

        for (int i = 0; i < motors.size(); i++) {
            if (motors.get(i).getMarca().equals(marca) && motors.get(i).getModel().equals(model)) {
                this.motors.remove(motors.get(i));
                return true;
            }
        }
        return false;
    }

    public boolean editareMotor(String marca, String model) {
        Motor motor = findByMarcaSiModel(marca, model);
        if (motor != null) {
            System.out.println("Ce doriti sa modificati?");
            System.out.println("1. Pret");
            System.out.println("2. Stare (Uzat/Nou)");
            System.out.println("3. An de fabricatie");

            int alegere = Integer.parseInt(scanner.nextLine());

            switch (alegere) {
                case 1:
                    System.out.println("Introduceti noul pret: ");
                    int pret = Integer.parseInt(scanner.nextLine());
                    motor.setPret(pret);
                    break;
                case 2:
                    System.out.println("Este motorul uzat? (true/false)");
                    boolean uzat = Boolean.parseBoolean(scanner.nextLine());
                    motor.setUzat(uzat);
                    break;
                case 3:
                    System.out.println("Introduceti noul an de fabricatie: ");
                    int anFabricatie = Integer.parseInt(scanner.nextLine());
                    motor.setAnFabricatie(anFabricatie);
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
            return true;
        }
        return false;

    }

    public boolean adaugareRating(String marca, String model) {
        Motor nou = findByMarcaSiModel(marca, model);
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
