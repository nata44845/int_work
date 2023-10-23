package Model.ToyShop;

import java.util.Iterator;
import java.util.List;

public class ToyShopIterator<E extends ToyShopItem> implements Iterator<E> {
    private int index;
    private List<E> itemList;

    public ToyShopIterator(List<E> itemList) {
        this.itemList = itemList;
    }

    @Override
    public boolean hasNext() {
        return itemList.size() > index;
    }

    @Override
    public E next() {
        return itemList.get(index++);
    }
}
