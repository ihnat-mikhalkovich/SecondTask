package by.epam.task02.entity;

import java.util.HashMap;
import java.util.Map;

public class Shop {

    private static final Shop instance = new Shop();

    private final Map<SportEquipment, Integer> goods = new HashMap<>();

    private Shop() {}

    public static Shop getInstance() {
        return instance;
    }

    public Map<SportEquipment, Integer> getGoods() {
        return goods;
    }

    public void add(SportEquipment sportEquipment) {
        goods.put(sportEquipment, goods.getOrDefault(sportEquipment, 0) + 1);
    }

    public void add(SportEquipment sportEquipment, int amount) {
        goods.put(sportEquipment, goods.getOrDefault(sportEquipment, 0) + amount);
    }

    public boolean remove(SportEquipment sportEquipment) {
        if (!goods.containsKey(sportEquipment)) {
            return false;
        }
        goods.put(sportEquipment, goods.get(sportEquipment) - 1);
        if (goods.get(sportEquipment) < 1) {
            goods.remove(sportEquipment);
        }
        return true;
    }

    public boolean remove(SportEquipment sportEquipment, int amount) {
        if (!goods.containsKey(sportEquipment)) {
            return false;
        }
        if (goods.get(sportEquipment) < amount) {
            return false;
        }
        goods.put(sportEquipment, goods.get(sportEquipment) - amount);
        if (goods.get(sportEquipment) < 1) {
            goods.remove(sportEquipment);
        }
        return true;
    }

    public void clear() {
        goods.clear();
    }

}
