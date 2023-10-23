package Presenter;

import Model.Toy.Toy;
import Model.ToyShop.ToyShop;
import View.View;
import FileWork.Writable;

public class Presenter {
    private View view;
    private ToyShop<Toy> toyShop;
    Writable wr;

    public Presenter(View view, Writable wr) {
        this.toyShop = new ToyShop<>();
        this.view = view;
        this.wr = wr;
    }

    public Toy addItem(String name, Integer count, double percent) {
        Toy toy = new Toy(name, count, percent);
        toyShop.addItem(toy);
        return toy;
    }

    public void getToyShopInfo() {
        view.printAnswer(toyShop.getToyShopInfo());
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

    public void saveData(String fileName) {

        if (wr.write(toyShop, fileName))
            view.printAnswer("Файл сохранен");
        else
            view.printAnswer("Ошибка сохранения");
    }

    public void loadData(String fileName) {
        Object obj = wr.read(fileName);
        if (obj instanceof ToyShop) {
            toyShop = (ToyShop) obj;
            view.printAnswer("Данные загружены");
        } else
            view.printAnswer("Ошибка загрузки данных");
    }

    public void findData(String name) {
        boolean flag = false;
        for (Toy toy : toyShop) {
            if (toy.getName().equals(name)) {
                view.printAnswer(toy.getFullInfo());
                flag = true;
            }
        }
        if (flag == false)
            view.printAnswer("Данные не найдены");
    }
}
