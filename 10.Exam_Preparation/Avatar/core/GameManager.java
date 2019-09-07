package Avatar.core;


import Avatar.entities.Benders.Bender;
import Avatar.entities.Monumets.Monument;
import Avatar.factories.BendersFactory;
import Avatar.factories.MonumentsFactory;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static Avatar.utilities.Constants.*;

public class GameManager {
    private Map<String, List<Bender>> benders;
    private Map<String, List<Monument>> monuments;
    private List<String> issuedWars;

    public GameManager() {
        this.setBenders();
        this.setMonuments();
        this.issuedWars = new ArrayList<>();
    }


    private void setBenders() {
        this.benders = new LinkedHashMap<>();
        this.benders.put(AIR, new ArrayList<>());
        this.benders.put(EARTH, new ArrayList<>());
        this.benders.put(FIRE, new ArrayList<>());
        this.benders.put(WATER, new ArrayList<>());
    }

    public void setMonuments() {
        this.monuments = new LinkedHashMap<>();
        this.monuments.put(AIR, new ArrayList<>());
        this.monuments.put(EARTH, new ArrayList<>());
        this.monuments.put(FIRE, new ArrayList<>());
        this.monuments.put(WATER, new ArrayList<>());
    }

    public void createBender(String benderType, String benderName, int power, double specialPower) {
        Bender bender = BendersFactory.makeBender(benderType, benderName, power, specialPower);
        this.benders.get(benderType).add(bender);
    }

    public void createMonument(String monumentType, String monumentName, int affinity) {
        Monument monument = MonumentsFactory.makeMonument(monumentType, monumentName, affinity);
        this.monuments.get(monumentType).add(monument);
    }

    public String getStatus(String nation) {
        StringBuilder sb = new StringBuilder();
        String separator = System.lineSeparator();
        sb.append(nation).append(" Nation")
                .append(separator).append("Benders:");
        if (this.benders.get(nation).isEmpty()) {
            sb.append(" None").append(separator);
        } else {
            sb.append(separator);
            for (Bender bender : this.benders.get(nation)) {
                sb.append(bender.toString()).append(separator);
            }
        }
        sb.append("Monuments:");
        if (this.monuments.get(nation).isEmpty()) {
            sb.append(" None");
        } else {
            sb.append(System.lineSeparator());
            for (Monument monument : this.monuments.get(nation)) {
                sb.append(monument).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    public void war(String nation) {
        this.issuedWars.add(nation);
        double winnerPower = Double.MIN_VALUE;
        String winnerNation = "";

        for (Map.Entry<String, List<Bender>> benderEntry : this.benders.entrySet()) {
            double currPower = benderEntry.getValue().stream()
                    .mapToDouble(Bender::getBenderTotalPower)
                    .sum() +
                    (((benderEntry.getValue()
                            .stream()
                            .mapToDouble(Bender::getBenderTotalPower)
                            .sum()) / 100) *
                            this.monuments.get(benderEntry.getKey())
                                    .stream().mapToInt(Monument::getAffinity).sum());

            if (currPower > winnerPower) {
                winnerPower = currPower;
                winnerNation = benderEntry.getKey();
            }
        }

        String finalWinnerNation = winnerNation;
        this.benders.entrySet()
                .stream()
                .filter(n -> !n.getKey().equals(finalWinnerNation))
                .forEach(losingNation -> losingNation.getValue().clear());
        this.monuments.entrySet()
                .stream()
                .filter(n -> !n.getKey().equals(finalWinnerNation))
                .forEach(losingNation -> losingNation.getValue().clear());
    }

    public String quit() {
        int counter = 1;
        StringBuilder sb = new StringBuilder();

        for (String issuedWar : this.issuedWars) {
            sb.append(String.format(STRING_FORMAT_ISSUED_WAR, counter, issuedWar))
                    .append(System.lineSeparator());
            counter++;
        }

        return sb.toString().trim();
    }
}