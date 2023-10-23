package Model.Toy;

import java.io.Serializable;

import Model.ToyShop.ToyShopItem;

public class Toy implements Serializable, ToyShopItem {
    private int id;
    private String name;
    private Integer count;
    private Integer countInLottery;

    private Integer weight;

    public Toy() {
    }

    public Toy(String name, Integer count) {
        this(name, count, 0);
    }

    public Toy(String name, Integer count, Integer weight) {
        this.name = name;
        this.count = count;
        this.weight = weight;
        this.countInLottery = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCountInLottery() {
        return countInLottery;
    }

    public void setCountInLottery(Integer countInLottery) {
        this.countInLottery = countInLottery;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d %s %d %d", id, name, count, weight));
        return sb.toString();
    }

    public String getFullInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        sb.append("\n------------------------");
        return sb.toString();
    }

    public String getPrizeInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d %s %d %d", id, name, count, countInLottery));
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Toy))
            return false;
        Toy toy = (Toy) obj;
        // System.out.println(human.getFirstName()+human.getMiddleName()+human.getLastName()+human.getBirthDate());
        return ((toy.toString()).equals(this.toString()));
    }

}
