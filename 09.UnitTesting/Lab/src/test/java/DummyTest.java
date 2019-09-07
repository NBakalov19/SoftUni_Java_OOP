import org.junit.Before;
import org.junit.Test;
import rpg_lab.Dummy;

import static org.junit.Assert.assertEquals;
import static utils.Constants.*;

public class DummyTest {
  private Dummy aliveDummy;
  private Dummy deadDummy;

  @Before
  public void beforeEach() {
    this.aliveDummy = new Dummy(BASE_HP, BASE_XP);
    this.deadDummy = new Dummy(-BASE_HP, BASE_XP);
  }

  @Test
  public void ShouldLoseHealthWhenAttack() {
    this.aliveDummy.takeAttack(ATTACK);
    assertEquals(BASE_HP - ATTACK, this.aliveDummy.getHealth());
  }

  @Test(expected = IllegalStateException.class)
  public void CantBeAttackedIfIsDead() {
    this.deadDummy.takeAttack(ATTACK);
  }

  @Test
  public void ShouldTakeExperienceWhenIsDead() {
    assertEquals(BASE_XP, this.deadDummy.giveExperience());
  }

  @Test(expected = IllegalStateException.class)
  public void ShouldThrowExceptionIfGetExperienceIfIsAlive() {
    this.aliveDummy.giveExperience();
  }
}