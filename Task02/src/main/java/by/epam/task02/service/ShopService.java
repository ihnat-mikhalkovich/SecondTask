package by.epam.task02.service;

import by.epam.task02.entity.SportEquipment;

public interface ShopService {

    void load();

    void save();

    boolean findAndLoad(SportEquipment sportEquipment);

    void printReportAboutGoods();

}
