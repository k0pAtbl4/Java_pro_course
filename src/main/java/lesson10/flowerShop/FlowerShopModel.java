package lesson10.flowerShop;

import lesson10.exception.InvalidStemLengthException;

public interface FlowerShopModel {
    void start();
    void addFlower() throws InvalidStemLengthException;
    void addAccessory();
}
