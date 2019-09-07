package panzer.core;

import panzer.contracts.Manager;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.Parts.ArsenalPart;
import panzer.models.Parts.EndurancePart;
import panzer.models.Parts.ShellPart;
import panzer.models.vehicle.Revenger;
import panzer.models.vehicle.Vanguard;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {

    private Map<String, Vehicle> vehicles;
    private Map<String, Part> parts;
    private List<String> undefeatedVehicles;
    private List<String> defeatedVehicles;
    private PanzerBattleOperator battleArena;

    public ManagerImpl() {
        this.vehicles = new LinkedHashMap<>();
        this.parts = new LinkedHashMap<>();
        this.undefeatedVehicles = new LinkedList<>();
        this.defeatedVehicles = new LinkedList<>();
        this.battleArena = new PanzerBattleOperator();
    }


    @Override
    public String addVehicle(List<String> arguments) {
        String type = arguments.get(0);
        String model = arguments.get(1);
        double weight = Double.parseDouble(arguments.get(2));
        BigDecimal price = new BigDecimal(arguments.get(3));
        int attack = Integer.parseInt(arguments.get(4));
        int defence = Integer.parseInt(arguments.get(5));
        int hitPoints = Integer.parseInt(arguments.get(6));

        Vehicle vehicle;

        if (type.equals("Vanguard")) {
            vehicle = new Vanguard(model, weight, price, attack, defence, hitPoints);
        } else {
            vehicle = new Revenger(model, weight, price, attack, defence, hitPoints);
        }

        this.vehicles.putIfAbsent(model, vehicle);
        this.undefeatedVehicles.add(vehicle.getModel());

        return String.format("Created %s Vehicle – %s", type, model);
    }

    @Override
    public String addPart(List<String> arguments) {
        String vehicleModel = arguments.get(0);
        String partType = arguments.get(1);
        String partModel = arguments.get(2);
        double weight = Double.parseDouble(arguments.get(3));
        BigDecimal price = new BigDecimal(arguments.get(4));
        int additionalParameter = Integer.parseInt(arguments.get(5));

        Part part = null;

        switch (partType) {
            case "Arsenal":
                part = new ArsenalPart(partModel, weight, price, additionalParameter);
                this.vehicles.get(vehicleModel).addArsenalPart(part);
                break;
            case "Shell":
                part = new ShellPart(partModel, weight, price, additionalParameter);
                this.vehicles.get(vehicleModel).addShellPart(part);
                break;
            case "Endurance":
                part = new EndurancePart(partModel, weight, price, additionalParameter);
                this.vehicles.get(partModel).addEndurancePart(part);
                break;
        }
        this.parts.putIfAbsent(partModel, part);
        return String.format("Added %s - %s to Vehicle - %s", partType, partModel, vehicleModel);
    }

    @Override
    public String inspect(List<String> arguments) {
        String model = arguments.get(0);
        String result;
        if (this.vehicles.containsKey(model)) {
            result = this.vehicles.get(model).toString();
        } else {
            result = this.parts.get(model).toString();
        }

        return result;
    }

    @Override
    public String battle(List<String> arguments) {
        String attackerModel = arguments.get(0);
        String defenderModel = arguments.get(1);

        Vehicle attacker = this.vehicles.get(attackerModel);
        Vehicle defender = this.vehicles.get(defenderModel);

        String winner = this.battleArena.battle(attacker, defender);

        if (attackerModel.equals(winner)) {
            this.vehicles.remove(defenderModel);
            this.undefeatedVehicles.remove(defenderModel);
            this.defeatedVehicles.add(defenderModel);
        } else {
            this.vehicles.remove(attackerModel);
            this.undefeatedVehicles.remove(attackerModel);
            this.defeatedVehicles.add(attackerModel);
        }

        return String.format("%s versus %s -> %s Wins! Flawless Victory!", attackerModel, defenderModel, winner);
    }

    @Override
    public String terminate(List<String> arguments) {
        StringBuilder sb = new StringBuilder();
        String separator = System.lineSeparator();

        sb.append("Remaining Vehicles: ");
        if (this.undefeatedVehicles.isEmpty()) {
            sb.append("None").append(separator);
        } else {
            sb.append(String.join(", ", this.undefeatedVehicles)).append(separator);
        }

        sb.append("Defeated Vehicles: ");
        if (this.defeatedVehicles.isEmpty()) {
            sb.append("None").append(separator);
        } else {
            sb.append(String.join(", ", this.defeatedVehicles)).append(separator);
        }

        final int[] usedParts = {0};
        this.vehicles.values()
                .forEach(vehicle -> {
                    for (Part ignored : vehicle.getParts()) {
                        usedParts[0]++;
                    }
                });
        sb.append("Currently Used Parts: ").append(usedParts[0]);

        return sb.toString().trim();
    }
}