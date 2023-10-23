package Model.ToyShop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import Model.Comparators.ComparatorByCount;
import Model.Comparators.ComparatorByName;

public class ToyShop<E extends ToyShopItem> implements Serializable, Iterable<E> {
    private int id_toy;
    private List<E> itemList;
    private List<E> prizeList;

    public ToyShop() {
        itemList = new ArrayList<>();
        prizeList = new ArrayList<>();
        id_toy = 1;
    }

    public void addItem(E item) {
        item.setId(id_toy++);
        itemList.add(item);
    }

    public List<E> getToyList() {
        return itemList;
    }

    public List<E> getPrizeList() {
        return prizeList;
    }

    public String getToyShopInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Список игрушек: \n");
        for (E item : itemList) {
            sb.append(item.getFullInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new ToyShopIterator<>(itemList);
    }

    public void sortByName() {
        itemList.sort(new ComparatorByName<>());
    }

    public void sortByCount() {
        itemList.sort(new ComparatorByCount<>());
    }

    public int getToyShopSize() {
        return itemList.size();
    }

    public E getToyShopItem(int number) {
        for (int i = 0; i < itemList.size(); i++)
            if (itemList.get(i).getId() == number)
                return itemList.get(i);
        return null;
    }

    public String getLotteryInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Список разыгранных игрушек: \n");
        for (E item : prizeList) {
            sb.append(item.getPrizeInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    public boolean Lottery() {
        List<E> lotteryList = new ArrayList<>();
        Random rnd = new Random();
        // Сформировать список
        int count = 0;
        for (E item : itemList) {
            if ((item.getCount() - item.getCountInLottery() > 0 && item.getWeight() > 0)) {
                lotteryList.add(item);
                count = count + item.getWeight();
            }
        }
        // Нет игрушек к розыгрышу
        if (count == 0)
            return false;

        // Получить случайное число
        Integer cnt = rnd.nextInt(count) + 1;
        count = 0;
        for (E item : lotteryList) {
            count = count + item.getWeight();
            if (cnt <= count) {
                prizeList.add(item);
                item.setCountInLottery(item.getCountInLottery() + 1);
                return true;
            }
        }
        return false;
    }

    public E getPrize() {
        if (prizeList.size() > 0) {
            return prizeList.get(0);
        }
        return null;
    }

    public void setPrizeList() {

        if (prizeList.size() > 0) {
            // Снижение счетчика на 1
            E prize = prizeList.get(0);
            if (prize.getCountInLottery() > 0)
                prize.setCountInLottery(prize.getCountInLottery() - 1);
            if (prize.getCount() > 0)
                prize.setCount(prize.getCount() - 1);

            if (prizeList.size() == 1) {
                prizeList = new ArrayList<>();
            } else {
                // Сдвиг очереди
                List<E> prizeTemp = new ArrayList<>();
                for (int i = 1; i < prizeList.size(); i++) {
                    prizeTemp.add(prizeList.get(i));
                }
                prizeList = prizeTemp;
            }
        }
    }

}
