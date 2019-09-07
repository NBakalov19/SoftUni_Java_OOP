package core.factories;

import core.interfaces.PilotFactory;
import entities.interfaces.Pilot;
import entities.PilotImpl;

public final class PilotFactoryImpl implements PilotFactory {

    public PilotFactoryImpl() {
    }

    @Override
    public Pilot createPilot(String name) {
        return new PilotImpl(name);
    }
}
