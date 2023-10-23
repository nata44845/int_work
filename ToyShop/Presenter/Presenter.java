package Presenter;

import Model.Toy.Toy;
import Model.ToyShop.ToyShop;
import View.View;
import FileWork.Writable;

public class Presenter {
    private View view;
    private ToyShop<Toy> toyShop;
    Writable wr;
    String fileName;

    public Presenter(View view, Writable wr) {
        this.toyShop = new ToyShop<>();
        this.view = view;
        this.wr = wr;
        fileName = "Lottery.txt";
        wr.write("Результаты лотереи \n", fileName, false);
    }

    public void getToyShopInfo() {
        view.printAnswer(toyShop.getToyShopInfo());
    }

    public Toy addItem(String name, Integer count, Integer weight) {
        Toy toy = new Toy(name, count, weight);
        toyShop.addItem(toy);
        return toy;
    }

    public void sortByCount() {
        toyShop.sortByCount();
        getToyShopInfo();
    }

    public void sortByName() {
        toyShop.sortByName();
        getToyShopInfo();
    }

    public int getToyShopSize() {
        return toyShop.getToyShopSize();
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
            wr.write("Получен приз " + prize.getName() + "\n", fileName, true);
            // Сдвинуть очередь
            toyShop.setPrizeList();
            view.printAnswer("Получен приз " + prize.getName());
            getLotteryInfo();
        } else
            view.printAnswer("Нет призов в списке разыгранных");
    }

    public void changeWeight(Integer id, Integer weight) {
        getToyShopInfo();
    }

}
