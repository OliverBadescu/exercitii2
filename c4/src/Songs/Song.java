package Songs;

public class Song {

    private String nume;
    private String cantaret;
    private int durata;
    private int streams;
    private int releaseDate;
    private int nrReviewuri;
    private double rating;

    public Song(String nume, String cantaret, int durata, int streams, int releaseDate){
        this.nume = nume;
        this.cantaret = cantaret;
        this.durata = durata;
        this.streams= streams;
        this.releaseDate= releaseDate;
    }

    public String getNume(){return this.nume;}
    public void setNume(String nume){this.nume = nume;}

    public String getCantaret(){return this.cantaret;}
    public void setCantaret(String cantaret){this.cantaret = cantaret;}

    public int getDurata(){
        return this.durata;
    }
    public void setDurata(int durata){this.durata = durata;}

    public int getReleaseDate(){return this.releaseDate;}
    public void setReleaseDate(int releaseDate){this.releaseDate =releaseDate;}

    public int getStreams(){return this.streams;}
    public void setStreams(int streams){this.streams = streams;}

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
        text += "Cantaret: " + this.cantaret + "\n";
        text += "Streams: " + this.streams + "\n";
        text += "Durata: " + this.durata + "sec" + "\n";
        text += "Release date: " + this.releaseDate + "\n";
        text += "Nr. Reviewuri: " + this.nrReviewuri + "\n";
        text += "Rating: " + this.rating + "/5"  + "\n";

        return text;
    }


}
