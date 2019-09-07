package Avatar.core;


public class CommandParser {
    private GameManager gameManager;

    public CommandParser() {
        this.gameManager = new GameManager();
    }

    public void parseCommand(String[] split) {
        String command = split[0];
        switch (command) {
            case "Bender":
                String benderType = split[1];
                String benderName = split[2];
                int power = Integer.parseInt(split[3]);
                double specialPower = Double.parseDouble(split[4]);

                this.gameManager.createBender(benderType, benderName, power, specialPower);
                break;
            case "Monument":
                String monumentType = split[1];
                String monumentName = split[2];
                int affinity = Integer.parseInt(split[3]);

                this.gameManager.createMonument(monumentType, monumentName, affinity);
                break;
            case "Status":
                String nation = split[1];
                System.out.println(this.gameManager.getStatus(nation));
                break;
            case "War":
                nation = split[1];
                this.gameManager.war(nation);
                break;
            case "Quit":
                System.out.println(this.gameManager.quit());
                break;
        }
    }
}
