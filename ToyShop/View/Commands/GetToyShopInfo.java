package View.Commands;

import View.ConsoleUI;

public class GetToyShopInfo extends Command {
    public GetToyShopInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить список";
    }

    public void execute() {
        consoleUI.getToyShopInfo();
    }
}
