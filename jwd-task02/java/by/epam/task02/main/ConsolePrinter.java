package by.epam.task02.main;

import by.epam.task02.entity.*;
import by.epam.task02.service.RentService;
import by.epam.task02.service.RentServiceFactory;
import by.epam.task02.service.ShopService;
import by.epam.task02.service.ShopServiceFactory;

import java.util.Map;

public class ConsolePrinter {

    public void shopHeap(){
        Shop shop = Shop.getInstance();
        Map<SportEquipment, Integer> goods = shop.getGoods();
        for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {
            sportEquipmentPrint(entry.getKey());
            System.out.println("; amount=" + entry.getValue() + ";");
        }
    }

    public void rentPrint() {
        System.out.println("The goods given:");
        RentServiceFactory rentServiceFactory = RentServiceFactory.getInstance();
        RentService rentService = rentServiceFactory.getRentService();
        rentService.printReportAboutRentGoods();
    }

    public void sportEquipmentPrint(SportEquipment sportEquipment) {
        String info = "Category=" + sportEquipment.getCategory().toString() + ", ";
        info += "title=" + sportEquipment.getTitle() + ", ";
        info += "price=" + sportEquipment.getPrice() + ", ";
        info += "color=" + sportEquipment.getColor() + ", ";
        info += "size=" + sportEquipment.getStringSize();
        System.out.print(info);
    }

    public void userPrint(User user) {
        String userName = user.getName();
        System.out.println("$" + userName + ":");
        RentUnit rentUnit = user.getRentUnit();
        rentUnitPrint(rentUnit);
    }

    public void rentUnitPrint(RentUnit rentUnit) {
        for (Map.Entry<SportEquipment, Integer> entry : rentUnit.getUnits().entrySet()) {
            sportEquipmentPrint(entry.getKey());
            System.out.println("; amount=" + entry.getValue() + ";");
        }
    }

    public void shopPrint(){
        System.out.println("Shop content:");
        ShopServiceFactory shopServiceFactory = ShopServiceFactory.getInstance();
        ShopService shopService = shopServiceFactory.getShopService();
        shopService.printReportAboutGoods();
        shopHeap();
    }

}

/*
 public void shopHeap(){
 StringInfo stringInfo = new StringInfo();
 String info = stringInfo.shopInfo();
 System.out.println(info);
 }

 public void rentPrint() {
 RentServiceFactory rentServiceFactory = RentServiceFactory.getInstance();
 RentService rentService = rentServiceFactory.getRentService();
 rentService.printReportAboutRentGoods();
 }

 public void sportEquipmentPrint(SportEquipment sportEquipment) {
 StringInfo stringInfo = new StringInfo();
 String info = stringInfo.sportEquipmentInfo(sportEquipment);
 System.out.println(info);
 }

 public void userPrint(User user) {
 StringInfo stringInfo = new StringInfo();
 String info = stringInfo.userInfo(user);
 System.out.println(info);
 }

 public void rentUnit(RentUnit rentUnit) {
 StringInfo stringInfo = new StringInfo();
 String info = stringInfo.rentUnitInfo(rentUnit);
 System.out.println(info);
 }

 public void shopPrint(){
 ShopServiceFactory shopServiceFactory = ShopServiceFactory.getInstance();
 ShopService shopService = shopServiceFactory.getShopService();
 shopService.printReportAboutGoods();
 StringInfo stringInfo = new StringInfo();
 String info = stringInfo.shopInfo();
 System.out.println(info);
 }
 */