package Calculator;

public class ExtendedInputInterpreter extends InputInterpreter {

  public ExtendedInputInterpreter(CalculationEngine engine) {
    super(engine);
  }


  @Override
  public Operation getOperation(String operation) {
    if (operation.equals("*")) {
      return new MultiplicationOperation();
    } else if (operation.equals("/")) {
      return new DeviseOperation();
    } else if (operation.equals("ms")) {
      return new MemorySaveOperation();
    } else if (operation.equals("mr")) {
      //TODO
    }
    return null;
  }
}
