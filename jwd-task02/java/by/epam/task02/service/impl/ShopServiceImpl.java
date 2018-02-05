package by.epam.task02.service.impl;

import by.epam.task02.dao.DAOShopFactory;
import by.epam.task02.dao.ShopDAO;
import by.epam.task02.entity.SportEquipment;
import by.epam.task02.service.ShopService;
import by.epam.task02.service.validation.Validator;

public class ShopServiceImpl implements ShopService {

    @Override
    public void load() {
        DAOShopFactory shopFactory = DAOShopFactory.getInstance();
        ShopDAO shopDAO = shopFactory.getShopDAO();
        shopDAO.load();
    }

    @Override
    public void save() {
        DAOShopFactory shopFactory = DAOShopFactory.getInstance();
        ShopDAO shopDAO = shopFactory.getShopDAO();
        shopDAO.save();
    }

    @Override
    public boolean findAndLoad(SportEquipment sportEquipment) {
        if (!Validator.sportEquipmentValidation(sportEquipment)) {
            return false;
        }
        DAOShopFactory shopFactory = DAOShopFactory.getInstance();
        ShopDAO shopDAO = shopFactory.getShopDAO();
        return shopDAO.findAndLoad(sportEquipment);
    }

    @Override
    public void printReportAboutGoods() {
        DAOShopFactory shopFactory = DAOShopFactory.getInstance();
        ShopDAO shopDAO = shopFactory.getShopDAO();
        shopDAO.printReportAboutGoods();
    }

}
