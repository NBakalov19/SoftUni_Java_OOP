package pr0304Barracks.core;

import pr0304Barracks.contracts.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpretImpl implements CommandInterpreter {
  private static final String COMMAND_PACKAGE = "pr0304Barracks.core.commands.";
  private Repository repository;
  private UnitFactory unitFactory;

  public CommandInterpretImpl(Repository repository, UnitFactory unitFactory) {
    this.repository = repository;
    this.unitFactory = unitFactory;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Executable interpretCommand(String[] data) {
    String commandName = Character.toUpperCase(data[0].charAt(0)) + data[0].substring(1);
    Executable executable = null;

    try {
      Class<? extends Executable> commandClass =
              (Class<? extends Executable>) Class.forName(CommandInterpretImpl.COMMAND_PACKAGE + commandName);

      Constructor constructor = commandClass
              .getDeclaredConstructor(String[].class);
      constructor.setAccessible(true);

      executable = (Executable) constructor.newInstance(new Object[]{data});

      Field[] executableFields = executable.getClass().getDeclaredFields();
      Field[] thisCommandImpl = this.getClass().getDeclaredFields();

      for (Field executableField : executableFields) {
        if (executableField.isAnnotationPresent(Inject.class)) {
          for (Field field : thisCommandImpl) {
            if (executableField.getType().equals(field.getType())) {
              executableField.setAccessible(true);
              executableField.set(executable, field.get(this));
            }
          }
        }
      }
    } catch (ClassNotFoundException
            | NoSuchMethodException
            | IllegalAccessException
            | InstantiationException
            | InvocationTargetException e) {
      e.printStackTrace();
    }
    return executable;
  }
}