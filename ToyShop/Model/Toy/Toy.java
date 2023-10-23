package Model.Toy;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import Model.ToyShop.ToyShopItem;

public class Toy implements Serializable, ToyShopItem {
    private int id;
    private String name;
    private Integer count;

    private double percent;

    public Toy() {
    }

    public Toy(String name, Integer count) {
        this(name, count, 0);
    }

    public Toy(String name, Integer count, double percent) {
        this.name = name;
        this.count = count;
        this.percent = percent;

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

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d %s %d %f", id, name, count, percent));
        return sb.toString();
    }

    public String getFullInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        sb.append("\n------------------------");
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
