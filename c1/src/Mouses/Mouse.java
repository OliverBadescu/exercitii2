package Mouses;

public class Mouse {

    private String marca;
    private String model;
    private int greutate;
    private int pret;
    private int anFabricatie;
    private int nrReviewuri;
    private double rating;

    public Mouse(String marca, String model, int pret, int greutate, int anFabricatie){

        this.marca = marca;
        this.model = model;
        this.pret = pret;
        this.greutate= greutate;
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

    public int getGreutate() {
        return this.greutate;
    }

    public void setGreutate(int greutate) {
        this.greutate = greutate;
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
        text += "Gretutate: " + this.greutate + "g" + " \n";
        text += "Nr. Reviewuri: " + this.nrReviewuri + "\n";
        text += "Rating: " + this.rating + "/5"  + "\n";

        return text;

    }


}
