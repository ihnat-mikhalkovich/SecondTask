package by.epam.task02.dao.impl;

import by.epam.task02.dao.ShopDAO;
import by.epam.task02.dao.source.shop.SourceShopReader;
import by.epam.task02.dao.source.shop.SourceShopWriter;
import by.epam.task02.entity.Shop;
import by.epam.task02.entity.SportEquipment;
import by.epam.task02.entity.StringInfo;

public class ShopDAOImpl implements ShopDAO {

    @Override
    public void load() {
        Shop shop = Shop.getInstance();
        SourceShopReader sourceShopReader = SourceShopReader.getInstance();
        String[] sportEquipments = sourceShopReader.load();
        for (String sportEquipmentAndAmount : sportEquipments) {
            String[] fieldsAndAmount = sportEquipmentAndAmount.split(" ");
            SportEquipment sportEquipment = SportEquipment.objectByStrings(fieldsAndAmount);
            int amount = Integer.parseInt(fieldsAndAmount[fieldsAndAmount.length -1]);
            shop.add(sportEquipment, amount);
        }
    }

    @Override
    public void save() {
        Shop shop = Shop.getInstance();
        StringInfo stringInfo = new StringInfo();
        String shopInfo = stringInfo.shopInfo();
        String[] records = shopInfo.split("\n");
        SourceShopWriter sourceShopWriter = SourceShopWriter.getInstance();
        sourceShopWriter.write(records);
        shop.clear();
        sourceShopWriter.deleteEmptyLines();
    }

    @Override
    public void printReportAboutGoods() {
        SourceShopReader sourceShopReader = SourceShopReader.getInstance();
        sourceShopReader.printShopInfo();
    }

    @Override
    public boolean findAndLoad(SportEquipment sportEquipment) {
        save();
        SourceShopReader sourceShopReader = SourceShopReader.getInstance();
        boolean flagOfSuccess = sourceShopReader.find(sportEquipment);
        return flagOfSuccess;
    }

}