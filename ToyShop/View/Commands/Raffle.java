package View.Commands;

import View.ConsoleUI;

public class Raffle extends Command {

    public Raffle(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Розыгрыш";
    }

    public void execute() {
        consoleUI.addItem();
    }
}
