package Client;

import View.ConsoleUI;

public class Program {
    public static void main(String[] args) {
        ConsoleUI console = new ConsoleUI();
        console.randomToys(20);
        console.start();
    }

}
