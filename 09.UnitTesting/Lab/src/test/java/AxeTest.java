import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

import static org.junit.Assert.assertEquals;
import static utils.Constants.*;

public class AxeTest {
  private Axe axe;
  private Dummy dummy;

  @Before
  public void beforeEach() {
    this.axe = new Axe(ATTACK, DURABILITY);
    this.dummy = new Dummy(BASE_HP, BASE_XP);
  }

  @Test
  public void axeShouldLoseDurability() {

    this.axe.attack(this.dummy);

    assertEquals(9, this.axe.getDurabilityPoints());
  }

  @Test(expected = IllegalStateException.class)
  public void axeCantAttackIfIsItBroken() {
    Axe axe = new Axe(ATTACK, -DURABILITY);
    axe.attack(this.dummy);
  }
}