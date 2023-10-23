package View.Commands;

import View.ConsoleUI;

public class GetPrize extends Command {

    public GetPrize(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить приз";
    }

    public void execute() {
        consoleUI.addItem();
    }
}
