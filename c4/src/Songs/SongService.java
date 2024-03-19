package Songs;

import java.util.ArrayList;
import java.util.Scanner;
public class SongService {

    private ArrayList<Song> songs;
    private Scanner scanner = new Scanner(System.in);

    public SongService(){
        this.songs = new ArrayList<>();
        this.loadData();
    }

    private void loadData(){

        Song s1 = new Song("Shape of You", "Ed Sheeran", 233, 250000000, 2017);
        Song s2 = new Song("Bohemian Rhapsody", "Queen", 354, 1000000000, 1975);
        Song s3 = new Song("Dance Monkey", "Tones and I", 209, 2000000000, 2019);
        Song s4 = new Song("Uptown Funk", "Mark Ronson ft. Bruno Mars", 270, 1800000000, 2014);
        Song s5 = new Song("Old Town Road", "Lil Nas X ft. Billy Ray Cyrus", 157, 220000000, 2019);
        Song s6 = new Song("Despacito", "Luis Fonsi ft. Daddy Yankee", 228, 700000000, 2017);
        Song s7 = new Song("Something Just Like This", "The Chainsmokers & Coldplay", 247, 1500000000, 2017);
        Song s8 = new Song("Closer", "The Chainsmokers ft. Halsey", 245, 2000000000, 2016);
        Song s9 = new Song("Rockstar", "Post Malone ft. 21 Savage", 218, 1900000000, 2017);
        Song s10 = new Song("Counting Stars", "OneRepublic", 257, 1300000000, 2013);

        songs.add(s1);
        songs.add(s2);
        songs.add(s3);
        songs.add(s4);
        songs.add(s5);
        songs.add(s6);
        songs.add(s7);
        songs.add(s8);
        songs.add(s9);
        songs.add(s10);


    }

    public void afisareSongs(){

        for (int i = 0 ; i < songs.size(); i++){
            System.out.println(songs.get(i).descriere());
        }

    }


    public void afisareDurataSub250(){

        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getDurata() < 250) {
                System.out.println(songs.get(i).descriere());
            }
        }

    }
    public void afisareDurataPeste250(){

        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getDurata() > 250) {
                System.out.println(songs.get(i).descriere());
            }
        }

    }


    public void afisareStreamsPeste2000000000(){

        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getStreams() >=2000000000) {
                System.out.println(songs.get(i).descriere());
            }
        }

    }
    public void afisareStreamsSub2000000000(){

        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getStreams() <2000000000) {
                System.out.println(songs.get(i).descriere());
            }
        }

    }


    private Song findByNumeSiCantaret(String nume, String cantaret){

        for (int i =0 ; i < songs.size();i++){
            if(songs.get(i).getNume().equals(nume) && songs.get(i).getCantaret().equals(cantaret)){
                return songs.get(i);
            }
        }
        return null;
    }
    public boolean adaugareSong(Song song){

        if (this.findByNumeSiCantaret(song.getNume(), song.getCantaret()) != null){
            return false;
        }
        this.songs.add(song);
        return true;
    }
    public boolean stergereSong(String nume, String cantaret){

        for (int i =0 ; i < songs.size(); i++){
            if(songs.get(i).getNume().equals(nume) && songs.get(i).getCantaret().equals(cantaret)){
                this.songs.remove(songs.get(i));
                return true;
            }
        }
        return false;
    }
    public boolean editareSong(String nume, String cantaret){

        Song song = findByNumeSiCantaret(nume ,cantaret);

        if(song != null){
            System.out.println("Ce doriti sa modificati? ");
            System.out.println("1.Durata");
            System.out.println("2.Streams");
            System.out.println("3.Release Date");

            int alegere = Integer.parseInt(scanner.nextLine());
            switch (alegere){

                case 1:
                    System.out.println("Introduceti noua durata: ");
                    int durata = Integer.parseInt(scanner.nextLine());
                    song.setDurata(durata);
                    break;
                case 2:
                    System.out.println("Introduceti noul nr. de streams");
                    int streams = Integer.parseInt(scanner.nextLine());
                    song.setStreams(streams);
                    break;
                case 3:
                    System.out.println("Introduceti noul release date");
                    int releaseDate = Integer.parseInt(scanner.nextLine());
                    song.setReleaseDate(releaseDate);
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
            return true;
        }
        return false;
    }

    public void sortareDurata() {
        boolean sortat = false;
        do {
            sortat = true;
            for (int i = 0; i < songs.size() - 1; i++) {
                if (songs.get(i).getDurata() > songs.get(i + 1).getDurata()) {
                    Song aux = songs.get(i);
                    songs.set(i, songs.get(i + 1));
                    songs.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);
    }
    public void sortareStreams() {
        boolean sortat = false;
        do {
            sortat = true;
            for (int i = 0; i < songs.size() - 1; i++) {
                if (songs.get(i).getStreams() > songs.get(i + 1).getStreams()) {
                    Song aux = songs.get(i);
                    songs.set(i, songs.get(i + 1));
                    songs.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);
    }
    public void sortareReleaseDate() {
        boolean sortat = false;
        do {
            sortat = true;
            for (int i = 0; i < songs.size() - 1; i++) {
                if (songs.get(i).getReleaseDate() > songs.get(i + 1).getReleaseDate()) {
                    Song aux = songs.get(i);
                    songs.set(i, songs.get(i + 1));
                    songs.set(i + 1, aux);
                    sortat = false;
                }
            }
        } while (!sortat);
    }

    public boolean adaugareRating(String nume, String cantaret) {
        Song nou = findByNumeSiCantaret(nume, cantaret);
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
