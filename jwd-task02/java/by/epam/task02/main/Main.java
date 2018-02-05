package by.epam.task02.main;

import by.epam.task02.entity.SportEquipment;
import by.epam.task02.entity.User;
import by.epam.task02.entity.category.Category;
import by.epam.task02.service.RentService;
import by.epam.task02.service.RentServiceFactory;
import by.epam.task02.service.ShopService;
import by.epam.task02.service.ShopServiceFactory;

public class Main {

    public static void main(String[] args) {

        RentServiceFactory rentServiceFactory = RentServiceFactory.getInstance();
        RentService rentService = rentServiceFactory.getRentService();
        ShopServiceFactory shopServiceFactory = ShopServiceFactory.getInstance();
        ShopService shopService = shopServiceFactory.getShopService();

        ConsolePrinter consolePrinter = new ConsolePrinter();

        shopService.load();
        consolePrinter.shopPrint();
        shopService.save();

        System.out.println();
        consolePrinter.rentPrint();

        SportEquipment sportEquipment = new SportEquipment();
        sportEquipment.setCategory(Category.BASKETBALL);
        shopService.findAndLoad(sportEquipment);

        System.out.println("\nresult of search:");
        consolePrinter.shopHeap();

        SportEquipment sportEquipment1 = new SportEquipment(Category.BASKETBALL, "ball", 65.4, "red", "9");
        User user = rentService.findUser("ihnat");
        System.out.println("\nChosen user:");
        consolePrinter.userPrint(user);
        Behavior behavior = new BehaviorImpl();
        System.out.println("\nuser take sport equipment:");
        behavior.userGetSportEquipment(user, sportEquipment1, 1);
        System.out.println("shop result:");
        consolePrinter.shopHeap();
        System.out.println("user result:");
        consolePrinter.userPrint(user);

        System.out.println("\nuser returns sport equipment:");
        behavior.userReturnSportEquipment(user, sportEquipment1, 1);

        System.out.println("shop result:");
        consolePrinter.shopHeap();
        System.out.println("user result:");
        consolePrinter.userPrint(user);

        shopService.save();

    }

}
