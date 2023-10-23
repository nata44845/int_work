package Model.Comparators;

import java.util.Comparator;

import Model.ToyShop.ToyShopItem;

public class ComparatorByCount<E extends ToyShopItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        if (o1.getCount() == null && o2.getCount() == null)
            return 0;
        if (o1.getCount() == null && o2.getCount() != null)
            return 1;
        if (o1.getCount() != null && o2.getCount() == null)
            return -1;
        return o1.getCount().compareTo(o2.getCount());
    }
}