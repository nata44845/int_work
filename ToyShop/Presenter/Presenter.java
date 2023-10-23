package Presenter;

import Model.Toy.Toy;
import Model.ToyShop.ToyShop;
import View.View;
import FileWork.Writable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Presenter {
    private View view;
    private ToyShop<Toy> toyShop;
    Writable wr;
    String fileName;
    DateTimeFormatter formatter;

    public Presenter(View view, Writable wr) {
        this.toyShop = new ToyShop<>();
        this.view = view;
        this.wr = wr;
        fileName = "Lottery.txt";
        wr.write("Результаты лотереи \n", fileName, false);
        formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss");
    }

    public void getToyShopInfo() {
        view.printAnswer(toyShop.getToyShopInfo());
    }

    public Toy addItem(String name, Integer count, Integer weight) {
        Toy toy = new Toy(name, count, weight);
        toyShop.addItem(toy);
        return toy;
    }

    public Toy getToyShopItem(int number) {
        return toyShop.getToyShopItem(number);
    }

    public void getLotteryInfo() {
        view.printAnswer(toyShop.getLotteryInfo());
    }

    public void lottery() {
        if (toyShop.Lottery())
            getLotteryInfo();
        else
            view.printAnswer("Нет призов для розыгрыша");
    }

    public void getPrize() {
        Toy prize = toyShop.getPrize();
        if (prize != null) {
            // Сохранить приз
            wr.write(LocalDateTime.now().format(formatter) + " Получен приз " + prize.getName() + "\n", fileName, true);
            // Сдвинуть очередь
            toyShop.setPrizeList();
            view.printAnswer("Получен приз " + prize.getName());
            getLotteryInfo();
        } else
            getLotteryInfo();
    }

    public boolean findData(Integer id) {
        for (Toy item : toyShop) {
            if (item.getId() == id) {
                view.printAnswer(item.getFullInfo());
                return true;
            }
        }
        return false;
    }

    public void changeWeight(Integer id, Integer weight) {
        for (Toy item : toyShop) {
            if (item.getId() == id) {
                item.setWeight(weight);
                view.printAnswer(item.getFullInfo());
                break;
            }
        }
    }

}
