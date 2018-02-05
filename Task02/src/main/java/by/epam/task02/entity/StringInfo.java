package by.epam.task02.entity;

import by.epam.task02.entity.category.Category;

import java.util.Map;

public class StringInfo {

    public String sportEquipmentInfo(SportEquipment sportEquipment) {
        Category category = sportEquipment.getCategory();
        String title = sportEquipment.getTitle();
        double price = sportEquipment.getPrice();
        String color = sportEquipment.getColor();
        String stringSize = sportEquipment.getStringSize();
        String info = category.toString() + " " + title  + " " + price + " " +
                color + " " + stringSize;
        return info;
    }

    public String rentUnitInfo(RentUnit rentUnit) {
        Map<SportEquipment, Integer> units = rentUnit.getUnits();
        String info = "";
        for (Map.Entry<SportEquipment,Integer> entry : units.entrySet()) {
            info += sportEquipmentInfo(entry.getKey()) + " " + entry.getValue() + "\n";
        }
        return info;
    }

    public String shopInfo() {
        Shop shop = Shop.getInstance();
        Map<SportEquipment, Integer> goods = shop.getGoods();
        String info = "";
        for (Map.Entry<SportEquipment,Integer> entry : goods.entrySet()) {
            info += sportEquipmentInfo(entry.getKey()) + " " + entry.getValue() + "\n";
        }
        return info;
    }

    public String userInfo(User user) {
        String info = user.getName() + "\n";
        info += rentUnitInfo(user.getRentUnit());
        return info;
    }

}
