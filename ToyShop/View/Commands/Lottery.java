package View.Commands;

import View.ConsoleUI;

public class Lottery extends Command {

    public Lottery(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Розыгрыш";
    }

    public void execute() {
        consoleUI.lottery();
    }
}
