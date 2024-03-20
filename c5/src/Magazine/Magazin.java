package Magazine;

public class Magazin {

    private String nume;
    private String produse;
    private String locatie;
    private int vanzari;
    private int anDeschidere;
    private int nrReviewuri;
    private double rating;

    public Magazin(String nume, String produse, String locatie, int vanzari, int anDeschidere){

        this.nume = nume;
        this.produse = produse;
        this.locatie = locatie;
        this.vanzari = vanzari;
        this.anDeschidere = anDeschidere;

    }

    public String getNume(){return this.nume;}
    public void setNume(String nume){this.nume = nume;}

    public String getProduse(){return this.produse;}
    public void setProduse(String produse){this.produse = produse;}

    public String getLocatie(){return this.locatie;}
    public void setLocatie(String locatie){this.locatie = locatie;}

    public int getVanzari(){return this.vanzari;}
    public void setVanzari(int vanzari){this.vanzari = vanzari;}

    public int getAnDeschidere(){return this.anDeschidere;}
    public void setAnDeschidere(int anDeschidere){this.anDeschidere = anDeschidere;}

    public int getNrReviewuri(){
        return this.nrReviewuri;
    }
    public void adaugareNrReviewuri(){
        this.nrReviewuri++;
    }


    public double getRating(){
        return this.rating;
    }
    public void setRating(double rating){
        this.rating = rating;
    }

    public String descriere(){

        String text = "";

        text += "Nume: " + this.nume + "\n";
        text += "Produse: " + this.produse + "\n";
        text+= "Locatie: " + this.locatie + "\n";
        text+= "Vanzari: " + this.vanzari + "\n";
        text +="Anul deschiderii: " + this.anDeschidere + "\n";
        text += "Nr. Reviewuri: " + this.nrReviewuri + "\n";
        text += "Rating: " + this.rating + "/5"  + "\n";

        return text;

    }
}
