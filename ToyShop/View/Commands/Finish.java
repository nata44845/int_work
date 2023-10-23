package View.Commands;

import View.ConsoleUI;

public class Finish extends Command {
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Закончить работу";
    }

    public void execute() {
        consoleUI.finish();
    }
}
