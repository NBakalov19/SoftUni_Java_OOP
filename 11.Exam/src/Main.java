import core.MachinesManagerImpl;

import core.factories.MachineFactoryImpl;
import core.factories.PilotFactoryImpl;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        PilotFactory pilotFactory = new PilotFactoryImpl();
        MachineFactory machineFactory = new MachineFactoryImpl();
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();

        MachinesManager machinesManager = new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        while (!input.equalsIgnoreCase("Over")) {
            String[] commands = input.split("\\s+");
            try {
                System.out.println(executeCommands(commands, machinesManager));
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
            input = reader.readLine();
        }
    }

    private static String executeCommands(String[] commands, MachinesManager machinesManager)
            throws IllegalArgumentException, NullPointerException {
        String command = commands[0];
        String result = "";
        switch (command) {
            case "Hire":
                result = machinesManager.hirePilot(commands[1]);
                break;
            case "Report":
                result = machinesManager.pilotReport(commands[1]);
                break;
            case "ManufactureTank":

                result = machinesManager.manufactureTank(commands[1],
                        Double.parseDouble(commands[2]),
                        Double.parseDouble(commands[3]));
                break;
            case "ManufactureFighter":
                result = machinesManager.manufactureFighter(commands[1],
                        Double.parseDouble(commands[2]),
                        Double.parseDouble(commands[3]));
                break;
            case "Engage":
                result = machinesManager.engageMachine(commands[1], commands[2]);
                break;
            case "Attack":
                result = machinesManager.attackMachines(commands[1], commands[2]);
                break;
            case "DefenseMode":
                result = machinesManager.toggleTankDefenseMode(commands[1]);
                break;
            case "AggressiveMode":
                result = machinesManager.toggleFighterAggressiveMode(commands[1]);
                break;
        }
        return result;
    }
}