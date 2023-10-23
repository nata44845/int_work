package Model.Comparators;

import java.util.Comparator;

import Model.ToyShop.ToyShopItem;

public class ComparatorByName<E extends ToyShopItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
