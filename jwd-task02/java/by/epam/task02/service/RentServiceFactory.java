package by.epam.task02.service;

import by.epam.task02.service.impl.RentServiceImpl;

public class RentServiceFactory {

    private static final RentServiceFactory instance = new RentServiceFactory();

    private final RentService rentService = new RentServiceImpl();

    private RentServiceFactory() {}

    public static RentServiceFactory getInstance() {
        return instance;
    }

    public RentService getRentService() {
        return rentService;
    }

}
