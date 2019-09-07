package fakes;

import rpg_lab.Target;

import static utils.Constants.BASE_XP;

public class FakeTarget implements Target {
  public int getHealth() {
    return 0;
  }

  public void takeAttack(int attackPoints) {

  }

  public int giveExperience() {
    return BASE_XP;
  }

  public boolean isDead() {
    return true;
  }
}
