package by.epam.task02.dao;

import by.epam.task02.dao.impl.ShopDAOImpl;

public class DAOShopFactory {

    private static final DAOShopFactory instance = new DAOShopFactory();

    private final ShopDAO shopDAO = new ShopDAOImpl();

    private DAOShopFactory() {}

    public static DAOShopFactory getInstance() {
        return instance;
    }

    public ShopDAO getShopDAO() {
        return shopDAO;
    }

}
