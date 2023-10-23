package View;

import Model.Toy.Toy;
import Presenter.Presenter;
import FileWork.FileHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this, new FileHandler());
        work = true;
        menu = new MainMenu(this);
    }

    public void randomToys(int num) {
        Random rnd = new Random();

        String[] names = new String[] { "Кукла", "Медведь", "Машинка", "Робот", "Крокодил" };

        for (int i = 0; i < num; i++) {
            presenter.addItem(names[rnd.nextInt(names.length)], rnd.nextInt(5), rnd.nextInt(100));
        }
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        title();
        while (work) {
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("До свидания");
        work = false;
    }

    public void getToyShopInfo() {
        presenter.getToyShopInfo();
    }

    public void getLotteryInfo() {
        presenter.getLotteryInfo();
    }

    public void addItem() {
        System.out.println("Добавление данных");
        System.out.println("Введите название");
        String name = scanner.nextLine();

        System.out.println("Укажите количество");
        String countString = scanner.nextLine();
        Integer count = 0;
        if (countString != "")
            count = Integer.parseInt(countString);

        System.out.println("Укажите вес в лотерее");
        String weightString = scanner.nextLine();
        Integer weight = 0;
        if (weightString != "")
            weight = Integer.parseInt(weightString);

        presenter.addItem(name, count, weight);
    }

    public void lottery() {
        presenter.lottery();
    }

    public void getPrize() {
        presenter.getPrize();
    }

    private void title() {
        System.out.println("Розыгрыш игрушек");
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)) {
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand <= menu.getSize()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }
}
