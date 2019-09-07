package cresla.core;

import cresla.interfaces.Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {
    private Manager manager;
    private BufferedReader bufferedReader;
    private List<String> commands;

    public Engine() {
        this.manager = new ManagerImpl();
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.commands = new ArrayList<>();
    }

    public void run() throws IOException {
        while (true) {
            String[] input = this.bufferedReader.readLine().split("\\s+");
            String command = input[0];
            this.commands = Arrays.stream(input).skip(1).collect(Collectors.toList());

            String output = "";
            switch (command) {
                case "Reactor":
                    output = this.manager.reactorCommand(this.commands);
                    break;
                case "Module":
                    output = this.manager.moduleCommand(this.commands);
                    break;
                case "Report":
                    output = this.manager.reportCommand(this.commands);
                    break;
                case "Exit":
                    output = this.manager.exitCommand(new ArrayList<>());
                    break;
            }
            if (!output.isEmpty()){
                System.out.println(output);
            }

            if (command.equalsIgnoreCase("Exit")) {
                break;
            }
        }
    }
}