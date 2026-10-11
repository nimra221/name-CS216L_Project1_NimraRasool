package node;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Playlist playlist = new Playlist();
        int choice;

        do {
            System.out.println("\n===== MUSIC PLAYLIST MANAGER =====");
            System.out.println("1. Add Song");
            System.out.println("2. Display Playlist");
            System.out.println("3. Delete Song");
            System.out.println("4. Undo Delete");
            System.out.println("5. Search Song");
            System.out.println("6. Sort Playlist A-Z");
            System.out.println("7. Play Current Song");
            System.out.println("8. Play Next Song");
            System.out.println("9. Play Previous Song");
            System.out.println("10. Display Recently Played");
            System.out.println("11. Show Last Played Song");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Enter song name: ");
                        String song = sc.nextLine().trim();

                        if (!song.isEmpty()) {
                            playlist.addSong(song);
                        } else {
                            System.out.println("Song name cannot be empty!");
                        }
                        break;

                    case 2:
                        playlist.displayPlaylist();
                        break;

                    case 3:
                        System.out.print("Enter song name to delete: ");
                        String deleteSong = sc.nextLine().trim();

                        if (!deleteSong.isEmpty()) {
                            playlist.deleteSong(deleteSong);
                        } else {
                            System.out.println("Song name cannot be empty!");
                        }
                        break;

                    case 4:
                        playlist.undoDelete();
                        break;

                    case 5:
                        System.out.print("Enter song name to search: ");
                        String searchSong = sc.nextLine().trim();

                        if (!searchSong.isEmpty()) {
                            playlist.searchSong(searchSong);
                        } else {
                            System.out.println("Song name cannot be empty!");
                        }
                        break;

                    case 6:
                        playlist.sortPlaylist();
                        break;

                    case 7:
                        playlist.playCurrent();
                        break;

                    case 8:
                        playlist.playNext();
                        break;

                    case 9:
                        playlist.playPrevious();
                        break;

                    case 10:
                        playlist.displayRecentlyPlayed();
                        break;

                    case 11:
                        playlist.showLastPlayed();
                        break;

                    case 0:
                        System.out.println("Thank you for using Music Playlist Manager!");
                        break;

                    default:
                        System.out.println("Invalid choice! Enter a number from 0 to 11.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                choice = -1;
            }

        } while (choice != 0);

        sc.close();
    }
}