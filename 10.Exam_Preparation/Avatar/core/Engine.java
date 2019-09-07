package Avatar.core;


import Avatar.utilities.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {
    private BufferedReader reader;
    private CommandParser commandParser;

    public Engine() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.commandParser = new CommandParser();
    }

    public void run() throws IOException {
        String[] commands;
        do {
            commands = this.reader.readLine().split("\\s+");

            this.commandParser.parseCommand(commands);
        } while (!commands[0].equals(Constants.TERMINATING_COMMAND));

    }
}
