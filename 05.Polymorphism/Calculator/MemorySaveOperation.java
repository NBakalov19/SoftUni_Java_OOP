package Calculator;

import java.util.ArrayDeque;

public class MemorySaveOperation implements Operation {
  private ArrayDeque<Integer> operands;


  public MemorySaveOperation() {
    this.operands = new ArrayDeque<>();
  }

  @Override
  public void addOperand(int operand) {

  }

  @Override
  public int getResult() {
    return 0;
  }

  @Override
  public boolean isCompleted() {
    return false;
  }
}