package Shoes;

public class Shoe {

    private String marca;
    private String model;
    private int marime;
    private int pret;
    private int anFabricatie;
    private int nrReviewuri;
    private double rating;

    public Shoe(String marca, String model, int pret, int marime, int anFabricatie){

        this.marca = marca;
        this.model = model;
        this.pret = pret;
        this.marime= marime;
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


    public int getAnFabricatie() {
        return this.anFabricatie;
    }
    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }


    public int getMarime() {
        return this.marime;
    }
    public void setMarime(int marime) {
        this.marime = marime;
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
        text += "Marime: " + this.marime  + " \n";
        text += "Nr. Reviewuri: " + this.nrReviewuri + "\n";
        text += "Rating: " + this.rating + "/5"  + "\n";

        return text;

    }

}
