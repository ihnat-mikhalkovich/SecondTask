package by.epam.task02.main;

import by.epam.task02.dao.RentDAO;
import by.epam.task02.dao.ShopDAO;
import by.epam.task02.dao.impl.RentDAOImpl;
import by.epam.task02.dao.impl.ShopDAOImpl;
import by.epam.task02.entity.Shop;
import by.epam.task02.entity.SportEquipment;
import by.epam.task02.entity.User;
import by.epam.task02.service.RentService;
import by.epam.task02.service.RentServiceFactory;

public class BehaviorImpl implements Behavior {

    @Override
    public boolean userGetSportEquipment(User user, SportEquipment sportEquipment, int amount) {
        if (!user.hasPlace()) {
            return false;
        }
        Shop shop = Shop.getInstance();
        boolean activityApproved = shop.remove(sportEquipment, amount);
        if (activityApproved) {
            user.add(sportEquipment, amount);
            RentServiceFactory rentServiceFactory = RentServiceFactory.getInstance();
            RentService rentService = rentServiceFactory.getRentService();
            rentService.saveUser(user);
        }
        return activityApproved;
    }

    @Override
    public boolean userReturnSportEquipment(User user, SportEquipment sportEquipment, int amount) {
        boolean activityApproved = user.remove(sportEquipment, amount);
        if (activityApproved) {
            Shop shop = Shop.getInstance();
            shop.add(sportEquipment, amount);
            RentServiceFactory rentServiceFactory = RentServiceFactory.getInstance();
            RentService rentService = rentServiceFactory.getRentService();
            rentService.saveUser(user);
        }
        return activityApproved;
    }

}
