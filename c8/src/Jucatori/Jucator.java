package Jucatori;

public class Jucator {

    private String nume;
    private String prenume;
    private String echipa;
    private int varsta;
    private int vechime;
    private int nrReviewuri;
    private double rating;

    public Jucator(String nume, String prenume, String echipa, int varsta, int vechime){
        this.nume = nume;
        this.prenume = prenume;
        this.echipa = echipa;
        this.varsta = varsta;
        this.vechime = vechime;
    }

    public String getNume(){return this.nume;}
    public void setNume(String nume){ this.nume = nume;}

    public String  getPrenume(){return this.prenume;}
    public void setPrenume(String prenume){this.prenume= prenume;}

    public String getEchipa(){return this.echipa;}
    public void setEchipa(String echipa){this.echipa= echipa;}

    public int getVarsta(){return this.varsta;}
    public void setVarsta(int varsta){this.varsta = varsta;}

    public int getVechime(){return this.vechime;}
    public void setVechime(int vechime){this.vechime = vechime;}

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
        text += "Prenume: " + this.prenume + "\n";
        text += "Echipa: " + this.echipa + "\n";
        text+= "Varsta: " + this.varsta + "\n";
        text += "Vechime: " + this.vechime + "ani" + "\n";
        text += "Nr. Reviewuri: " + this.nrReviewuri + "\n";
        text += "Rating: " + this.rating + "/5"  + "\n";

        return text;

    }
}
