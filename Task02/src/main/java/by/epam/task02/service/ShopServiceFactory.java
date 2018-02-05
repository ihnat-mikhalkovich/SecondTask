package by.epam.task02.service;

import by.epam.task02.service.impl.ShopServiceImpl;

public class ShopServiceFactory {

    private static final ShopServiceFactory instance = new ShopServiceFactory();

    private final ShopService shopService = new ShopServiceImpl();

    private ShopServiceFactory() {}

    public static ShopServiceFactory getInstance() {
        return instance;
    }

    public ShopService getShopService() {
        return shopService;
    }

}
