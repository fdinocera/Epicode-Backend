package Player;

import java.util.Scanner;

abstract public class Player {

    public static void main(String[] args) {
        ElementoMultimediale[] elementi = new ElementoMultimediale[5];

        elementi[0] = new Audio("Sono solo canzonette", 5, 3);
        elementi[1] = new Video("Il gladiatore", 5, 3, 10);
        elementi[2] = new Immagine("Panorama", 5);
        elementi[3] = new Audio("La noia", 7, 5);
        elementi[4] = new Video("Per un pugno di dollari", 6, 4, 8);

        Scanner scanner = new Scanner(System.in);


        //richiesta a utente di creazione elementi multimediali
        System.out.println("Crea 5 contenuti multimediali");
        for (int i = 0; i < 5; i++) {
            System.out.println("Scegli tra: 1) Immagine");
            System.out.println("          : 2) Audio");
            System.out.println("          : 3) Video");
            System.out.println("          : 0) Contenuti predefiniti");

            int tipoMediaScelto = scanner.nextInt();
            scanner.nextLine();

            if (tipoMediaScelto == 0) {
                break;
            }

            //Immagine
            if (tipoMediaScelto == 1) {
                System.out.println("Inserisci titolo immagine: ");
                String titolo = scanner.nextLine();

                System.out.println("Inserisci luminosità immagine: ");
                int luminosita = scanner.nextInt();

                elementi[i] = new Immagine(titolo, luminosita);
            }

            //Audio
            if (tipoMediaScelto == 2) {
                System.out.println("Inserisci titolo audio: ");
                String titolo = scanner.nextLine();

                System.out.println("Inserisci durata: ");
                int durata = scanner.nextInt();

                System.out.println("Inserisci volume: ");
                int volume = scanner.nextInt();

                elementi[i] = new Audio(titolo, durata, volume);
            }

            //Video
            if (tipoMediaScelto == 3) {
                System.out.println("Inserisci titolo video: ");
                String titolo = scanner.nextLine();

                System.out.println("Inserisci durata: ");
                int durata = scanner.nextInt();

                System.out.println("Inserisci volume: ");
                int volume = scanner.nextInt();

                System.out.println("Inserisci luminosità: ");
                int luminosita = scanner.nextInt();

                elementi[i] = new Video(titolo, luminosita, volume, durata);
            }
        }

        //riproduzione elemento multimediale
        int sceltaUtente;
        do {
            System.out.println("Scegli da 1 a 5 (0 per finire)");
            sceltaUtente = scanner.nextInt();
            if (sceltaUtente != 0) {
                elementi[sceltaUtente - 1].esegui();
            }
        } while (sceltaUtente != 0);
    }
}
