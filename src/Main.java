import de.rhistel.logic.ConsoleReader;

public class Main {

    //region Konstanten
    public static final String APPLICATION_NAME = "\nMg Bucket List\n";
    public static final String TITLE_MINIMUM_THREE_CHARACTERS = "\nDer Song muss mindestens 3 Zeichen lang sein.";
    public static final String HOW_MANY_SONGS_TO_CHOOSE = "\nWie viele Songs möchtest du auf deine Bucketlist setzen?";
    public static final String MARK_ANOTHER_SONG = "\nMöchten Sie einen Song als 'erledigt' markieren? (ja/nein)";
    public static final String WHICH_SONG_TO_MARK = "\nWelchen Song möchten Sie als 'erledigt' markieren? (Geben Sie die Nummer ein)";
    public static final String INVALID_CHOICE = "Ungültige Auswahl.";
    public static final String DONE = " (erledigt)";
    public static final String NO = "nein";
    public static final String USER_BUCKETLIST = "\nIhre Bucket List:\n";
    public static final String END_PROGRAM = "\nProgramm beendet.";
    //endregion Konstanten


    //region Variablen
    private static String[] songs;
    //endregion Variablen


    //region Methoden
    public static void main(String[] args) {
        startApplication();
    }

    private static void startApplication() {
        printApplicationName();
        numbersOfSongsToWriteDownInBucketlist();
        markAnotherSong();
    }

    private static void printApplicationName() {
        System.out.println(APPLICATION_NAME);
    }

    private static void numbersOfSongsToWriteDownInBucketlist() {

        // Anzahl der Songs abfragen
        System.out.println(HOW_MANY_SONGS_TO_CHOOSE);
        int numberOfSongs = ConsoleReader.in.readInt();

        // Songs einlesen
        songs = new String[numberOfSongs];
        for (int i = 0; i < numberOfSongs; i++) {
            System.out.println("Song " + (i + 1) + ":");
            songs[i] = ConsoleReader.in.readString();

            // Prüfen, ob der Text mindestens 3 Zeichen lang ist
            if (songs[i].length() < 3) {
                System.out.println(TITLE_MINIMUM_THREE_CHARACTERS);
                i--;
            }
        }
        // Bucketlist ausgeben
        printSonglist(songs);
    }

    private static void printSonglist(String[] songs) {
        System.out.println(USER_BUCKETLIST);
        for (int i = 0; i < songs.length; i++) {
            System.out.println((i + 1) + ". " + songs[i]);
        }
    }

    private static void markAnotherSong() {
        while (true) {
            System.out.println(MARK_ANOTHER_SONG);
            String userInput = ConsoleReader.in.readString();

            if (userInput.equalsIgnoreCase(NO)) {
                break;
            }
            System.out.println(WHICH_SONG_TO_MARK);
            int songIndex = ConsoleReader.in.readInt() - 1;

            if (songIndex >= 0 && songIndex < songs.length) {
                songs[songIndex] += DONE;
                printSonglist(songs);
            } else {
                System.out.println(INVALID_CHOICE);
            }
        }
        System.out.println(END_PROGRAM);
    }
    //endregion Methoden
}