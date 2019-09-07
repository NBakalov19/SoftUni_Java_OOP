import fakes.FakeAxe;
import fakes.FakeTarget;
import org.junit.Test;
import rpg_lab.Hero;
import rpg_lab.Target;

import static org.junit.Assert.assertEquals;
import static utils.Constants.BASE_XP;

public class HeroTest {

  @Test
  public void shouldReceiveXpWhenTargetDie() {
    Hero hero = new Hero("name", new FakeAxe());
    Target target = new FakeTarget();
    hero.attack(target);
    assertEquals(hero.getExperience(), BASE_XP);
  }
}
