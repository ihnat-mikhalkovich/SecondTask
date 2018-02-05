package by.epam.task02.dao;

import by.epam.task02.entity.SportEquipment;

public interface ShopDAO {

    void load();

    void save();

    boolean findAndLoad(SportEquipment sportEquipment);

    void printReportAboutGoods();

}
