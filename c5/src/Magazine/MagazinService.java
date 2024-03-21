package Magazine;

import java.util.ArrayList;
import java.util.Scanner;

public class MagazinService {

    private ArrayList<Magazin> magazine;
    private Scanner scanner = new Scanner(System.in);

    public MagazinService(){
        this.magazine = new ArrayList<>();
        this.loadData();
    }

    private void loadData(){

        Magazin m1 = new Magazin("Supermarketul Vesel", "alimente, produse de uz casnic", "Str. Florilor nr. 10", 50000, 2010);
        Magazin m2 = new Magazin("Electronice Express", "electronice, electrocasnice", "Bulevardul Tehnologiei nr. 25", 30000, 2005);
        Magazin m3 = new Magazin("Moda Eleganta", "îmbrăcăminte, accesorii", "Piața Libertății nr. 5", 25000, 2015);
        Magazin m4 = new Magazin("Magazinul Copiilor Fericiți", "jucării, cărți pentru copii", "Aleea Prieteniei nr. 8", 15000, 2008);
        Magazin m5 = new Magazin("Fitness Pro", "echipamente de fitness, suplimente nutritive", "Str. Sportivilor nr. 15", 20000, 2012);
        Magazin m6 = new Magazin("Grădina Verde", "plante, unelte de grădinărit", "Bulevardul Naturii nr. 30", 18000, 2007);
        Magazin m7 = new Magazin("Casa Decorativă", "mobilă, decorațiuni interioare", "Aleea Frumuseții nr. 12", 22000, 2018);
        Magazin m8 = new Magazin("Tehno Shop", "produse IT, gadget-uri", "Str. Inovației nr. 18", 28000, 2013);
        Magazin m9 = new Magazin("Librăria Cunoașterii", "cărți, articole de papetărie", "Piața Cunoașterii nr. 7", 32000, 2009);
        Magazin m10 = new Magazin("Magazinul de Animale", "hrană și accesorii pentru animale de companie", "Bulevardul Prieteniei nr. 20", 24000, 2016);

        magazine.add(m1);
        magazine.add(m2);
        magazine.add(m3);
        magazine.add(m4);
        magazine.add(m5);
        magazine.add(m6);
        magazine.add(m7);
        magazine.add(m8);
        magazine.add(m9);
        magazine.add(m10);

    }

    public void afisareMagazine(){

        for (int i =0 ; i < magazine.size(); i++){
            System.out.println(magazine.get(i).descriere());
        }

    }

    public void afisareVanzariPeste25000(){
        for (int i = 0; i < magazine.size(); i++) {
            if (magazine.get(i).getVanzari() > 25000) {
                System.out.println(magazine.get(i).descriere());
            }
        }
    }
    public void afisareVanzariSub25000(){
        for (int i = 0; i < magazine.size(); i++) {
            if (magazine.get(i).getVanzari() < 25000) {
                System.out.println(magazine.get(i).descriere());
            }
        }
    }

    private Magazin findByNume(String nume){

        for (int i =0 ; i < magazine.size(); i++){
            if(magazine.get(i).getNume().equals(nume)){
                return magazine.get(i);
            }
        }
        return null;
    }
    public boolean adaugareMagazin(Magazin magazin){

        if(this.findByNume(magazin.getNume())!= null){
            return false;
        }
        this.magazine.add(magazin);
        return true;

    }
    public boolean steregereMagazin(String nume){

        for(int i =0; i < magazine.size();i++){
            if(magazine.get(i).getNume().equals(nume)){
                this.magazine.remove(magazine.get(i));
                return true;
            }
        }
        return false;
    }
    public boolean editareMagazin(String nume){

        Magazin magazin = findByNume(nume);

        if(magazin!= null){
            System.out.println("Ce doriti sa modificati?");
            System.out.println("1. Produse");
            System.out.println("2. Locatie");
            System.out.println("3. Vanzari");
            System.out.println("4. Anul deschiderii");
            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 1:
                    System.out.println("Introduceti noile produse:" );
                    String produse = scanner.nextLine();
                    magazin.setProduse(produse);
                    break;
                case 2:
                    System.out.println("Introduceti noua locatie: ");
                    String locatie = scanner.nextLine();
                    magazin.setLocatie(locatie);
                    break;
                case 3:
                    System.out.println("Introduceti noile vanzari: ");
                    int vanzari = Integer.parseInt(scanner.nextLine());
                    magazin.setVanzari(vanzari);
                    break;
                case 4:
                    System.out.println("Introduceti noul an al deschiderii: ");
                    int anDeschidere = Integer.parseInt(scanner.nextLine());
                    magazin.setAnDeschidere(anDeschidere);
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
            return true;
        }
        return false;

    }
    public void sortareVanzari(){

        boolean sortat = false;
        do {
            sortat = true;
            for (int i = 0; i < magazine.size() - 1; i++) {
                if (magazine.get(i).getVanzari() > magazine.get(i + 1).getVanzari()) {
                    Magazin aux = magazine.get(i);
                    magazine.set(i, magazine.get(i + 1));
                    magazine.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);

    }
    public void sortareAnDeschidere(){

        boolean sortat = false;
        do {
            sortat = true;
            for (int i = 0; i < magazine.size() - 1; i++) {
                if (magazine.get(i).getAnDeschidere() > magazine.get(i + 1).getAnDeschidere()) {
                    Magazin aux = magazine.get(i);
                    magazine.set(i, magazine.get(i + 1));
                    magazine.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);

    }
    public boolean adaugareRating(String nume) {
        Magazin nou = findByNume(nume);
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
