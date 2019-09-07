package footballTeamGeneration;

import java.util.ArrayList;
import java.util.List;

public class Team {
  private String name;
  private List<Player> players;

  public Team(String name) {
    this.setName(name);
    this.players = new ArrayList<>();
  }

  private void setName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("A name should not be empty.");
    }
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void addPlayer(Player player) {
    this.players.add(player);
  }

  public void removePlayer(String playerName) {
    int index = -1;
    for (Player player : players) {
      if (player.getName().equals(playerName)) {
        this.players.remove(player);
        index = 0;
        break;
      }
    }

    if (index == -1) {
      throw new IllegalArgumentException(
              String.format("Player %s is not in %s team.", playerName, getName()));
    }
  }

  public double getRating() {
    double result = 0d;
    if (this.players.size() > 0) {
      result = this.players.stream()
              .mapToDouble(Player::overallSkillLevel)
              .average()
              .getAsDouble();
    }
    return result;
  }
}