package Model.ToyShop;

public interface ToyShopItem {
    int getId();

    void setId(int id);

    String getFullInfo();

    String getPrizeInfo();

    String getName();

    Integer getCount();

    void setCount(Integer i);

    Integer getCountInLottery();

    void setCountInLottery(Integer i);

    Integer getWeight();

}
