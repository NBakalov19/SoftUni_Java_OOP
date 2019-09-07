package onlineRadioDatabase;

import onlineRadioDatabase.songExeptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int countOfSongs = Integer.parseInt(reader.readLine());
    SongDatabase songDatabase = new SongDatabase();

    while (countOfSongs > 0) {
      String[] songInfo = reader.readLine().split(";");
      String artist = songInfo[0];
      String songName = songInfo[1];
      String length = songInfo[2];
      try {
        Song song = new Song(artist, songName, length);
        songDatabase.addSong(song);
        System.out.println("Song added.");
      } catch (InvalidSongException ex) {
        System.out.println(ex.getMessage());
      }
      countOfSongs--;
    }
    System.out.println(songDatabase.getSongsCount());
    System.out.println("Playlist length: " + songDatabase.getTotalLengthOfSongs());
  }
}
