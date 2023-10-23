package Model.ToyShop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

}
