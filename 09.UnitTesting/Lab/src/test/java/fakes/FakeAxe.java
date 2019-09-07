package fakes;

import rpg_lab.Target;
import rpg_lab.Weapon;

import static utils.Constants.ATTACK;

public class FakeAxe implements Weapon {

  public void attack(Target target) {

  }

  public int getAttackPoints() {
    return ATTACK;
  }

  public int getDurabilityPoints() {
    return 0;
  }
}
