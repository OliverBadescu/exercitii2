package Biciclete;

public class Bicicleta {

    private String marca;
    private String model;
    private boolean uzat;
    private int pret;
    private int anFabricatie;
    private int nrReviewuri;
    private double rating;

    public Bicicleta(String marca, String model, int pret, boolean uzat, int anFabricatie){

        this.marca = marca;
        this.model = model;
        this.pret = pret;
        this.uzat= uzat;
        this.anFabricatie = anFabricatie;
    }

    public  String getMarca(){
        return  this.marca;
    }
    public void setMarca(String marca) {
        this.marca=marca;
    }


    public String getModel() {
        return this.model;
    }
    public void setModel(String model) {
        this.model = model;
    }


    public int getPret() {
        return this.pret;
    }
    public void setPret(int pret) {
        this.pret = pret;
    }

    public boolean getUzat(){
        return this.uzat;
    }
    public void setUzat(boolean uzat){this.uzat = uzat;}


    public int getAnFabricatie() {
        return this.anFabricatie;
    }
    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

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

        text+= "Marca: " + this.marca + "\n";
        text += "Model: " + this.model + "\n";
        text += "Pret: " + this.pret + "\n";
        text += "An fabricatie: " + this.anFabricatie + "\n";
        text += "Uzat: " + this.uzat  + " \n";
        text += "Nr. Reviewuri: " + this.nrReviewuri + "\n";
        text += "Rating: " + this.rating + "/5"  + "\n";

        return text;

    }

}
