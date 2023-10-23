package View.Commands;

import View.ConsoleUI;

public class ChangeWeight extends Command {

    public ChangeWeight(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Изменить вес";
    }

    public void execute() {
        consoleUI.changeWeight();
    }
}
