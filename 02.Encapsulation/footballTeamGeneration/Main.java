package footballTeamGeneration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] input = reader.readLine().split(";");
    Map<String, Team> teams = new HashMap<>();

    while (!input[0].equals("END")) {

      String command = input[0];
      switch (command) {
        case "Team": {
          String teamName = input[1];
          try {
            Team team = new Team(teamName);
            teams.put(teamName, team);
          } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
          }
          break;
        }
        case "Add": {
          String teamName = input[1];
          if (teams.containsKey(teamName)) {
            try {
              String playerName = input[2];
              int endurance = Integer.parseInt(input[3]);
              int sprint = Integer.parseInt(input[4]);
              int dribble = Integer.parseInt(input[5]);
              int passing = Integer.parseInt(input[6]);
              int shooting = Integer.parseInt(input[7]);

              teams.get(teamName)
                      .addPlayer(new Player(playerName, endurance, sprint, dribble, passing, shooting));
            } catch (IllegalArgumentException ex) {
              System.out.println(ex.getMessage());
            }
          } else {
            System.out.println(String.format("Team %s does not exist.", teamName));
          }
          break;
        }
        case "Remove": {
          String teamName = input[1];
          String player = input[2];
          if (teams.containsKey(teamName)) {
            try {
              teams.get(teamName).removePlayer(player);
            } catch (IllegalArgumentException ex) {
              System.out.println(ex.getMessage());
            }
          } else {
            System.out.println(String.format("Team %s does not exist.", teamName));
          }
          break;
        }
        case "Rating": {
          String teamName = input[1];
          if (teams.containsKey(teamName)) {
            int rating = (int) Math.round(teams.get(teamName).getRating());
            System.out.println(String.format("%s - %d", teamName, rating));
          } else {
            System.out.println(String.format("Team %s does not exist.", teamName));
          }
          break;
        }
      }
      input = reader.readLine().split(";");
    }
  }
}