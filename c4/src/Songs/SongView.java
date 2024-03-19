package Songs;

import java.util.Scanner;
import java.util.ArrayList;

public class SongView {

    private SongService songService;
    private Scanner scanner;

    public SongView(){
        this.scanner = new Scanner(System.in);
        this.songService = new SongService();
        this.play();
    }

    private void meniu(){

        //crude

        System.out.println("Apasati tasta 1 pentru a afisa lista de cantece");
        System.out.println("Apasati tasta 2 pentru a adauga un cantec");
        System.out.println("Apasati tasta 3 pentru a sterge un cantec");
        System.out.println("Apasati tasta 4 pentru a edita un cantec");

        System.out.println("\n");

        // filtrare
        System.out.println("Apasati tasta 5 pentru a afisa cantecele cu durata peste 250 secunde");
        System.out.println("Apasati tasta 6 pentru a afisa cantecele cu durata sub 250 secunde");
        System.out.println("Apasati tasta 7 pentru a afisa cantecele cu peste 2000000000 streamuri");
        System.out.println("Apasati tasta 8 pentru a afisa cantecele cu sub 2000000000 streamuri");

        System.out.println( "\n");

        //sortare
        System.out.println("Apasati tasta 9 pentru a sorta lista crescator dupa durata");
        System.out.println("Apasati tasta 10 pentru a sorta lista crescator dupa streamuri");
        System.out.println("Apasati tasta 11 pentru a sorta lista crescator dupa release date");

        System.out.println("\n");
        //adaugare rating
        System.out.println("Apasati tasta 12 pentru a adauga un rating");


    }

    private void play() {
        boolean running = true;

        while (running) {
            meniu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    songService.afisareSongs();
                    break;
                case 2:
                    adaugareSong();
                    break;
                case 3:
                    stergereSong();
                    break;
                case 4:
                    editareSong();
                    break;
                case 5:
                    songService.afisareDurataPeste250();
                    break;
                case 6:
                    songService.afisareDurataSub250();
                    break;
                case 7:
                    songService.afisareStreamsPeste2000000000();
                    break;
                case 8:
                    songService.afisareStreamsSub2000000000();
                    break;
                case 9:
                    songService.sortareDurata();
                    break;
                case 10:
                    songService.sortareStreams();
                    break;
                case 11:
                    songService.sortareReleaseDate();
                    break;
                case 12:
                    addRating();
                    break;
                default:
                    System.out.println("Tasta incorecta");
            }
        }
    }

    private void adaugareSong(){

        System.out.println("Introduceti datele cantecului: ");
        System.out.println("Nume: ");
        String nume = scanner.nextLine();
        System.out.println("Cantaret: ");
        String cantaret = scanner.nextLine();
        System.out.println("Streams: ");
        int streams = Integer.parseInt(scanner.nextLine());
        System.out.println("Durata: ");
        int durata = Integer.parseInt(scanner.nextLine());
        System.out.println("Release date: ");
        int releaseDate = Integer.parseInt(scanner.nextLine());;

        Song nou = new Song (nume, cantaret, durata, streams ,releaseDate);

        if(songService.adaugareSong(nou)){
            System.out.println("Cantecul a fost adaugat");
        }else{
            System.out.println("Se afla deja in lista");
        }

    }

    private void stergereSong(){

        System.out.println("Introduceti numele si cantaretul cantecului care doriti sa fie sters: ");
        System.out.println("Nume: ");
        String nume = scanner.nextLine();
        System.out.println("Cantaret: ");
        String cantaret = scanner.nextLine();

        if(songService.stergereSong(nume, cantaret)){
            System.out.println("Cantecul a fost sters");
        }else{
            System.out.println("Nu se afla in lista");
        }

    }

    private void editareSong(){

        System.out.println("Introduceti numele si cantaretul cantecului care doriti sa fie editat: ");
        System.out.println("Nume: ");
        String nume = scanner.nextLine();
        System.out.println("Cantaret: ");
        String cantaret = scanner.nextLine();

        if(songService.editareSong(nume,cantaret)){
            System.out.println("Datele au fost actualizate");
        }else{
            System.out.println("Nu a fost gasit in lista");
        }

    }

    private void addRating() {
        System.out.println("Introduceti marca si modelul televizorlului pentru adaugarea unui rating: ");
        System.out.print("Nume: ");
        String nume = scanner.nextLine();
        System.out.print("Cantaret: ");
        String cantaret = scanner.nextLine();

        if (songService.adaugareRating(nume, cantaret)) {
            System.out.println("Rating-ul a fost adaugat cu succes.");
        } else {
            System.out.println("Cantecul nu a fost gasita in lista.");
        }
    }

}
