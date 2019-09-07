package panzer.core;

import panzer.contracts.Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {
    private Manager gameManager;
    private BufferedReader reader;
    private List<String> commands;

    public Engine() {
        this.gameManager = new ManagerImpl();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.commands = new ArrayList<>();
    }

    public void run() throws IOException {
        while (true) {
            String[] input = this.reader.readLine().split("\\s+");
            String command = input[0];
            this.commands = Arrays.stream(input).skip(1).collect(Collectors.toList());
            String output = "";
            switch (command) {
                case "Vehicle":
                    output = this.gameManager.addVehicle(this.commands);
                    break;
                case "Part":
                    output = this.gameManager.addPart(this.commands);
                    break;
                case "Inspect":
                    output = this.gameManager.inspect(this.commands);
                    break;
                case "Battle":
                   output = this.gameManager.battle(this.commands);
                    break;
                case "Terminate":
                    output = this.gameManager.terminate(this.commands);
                    break;
            }

            if (!output.isEmpty()) {
                System.out.println(output);
            }

            if (command.equals("Terminate")) {
                break;
            }
        }
    }
}