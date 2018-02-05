package by.epam.task02.service.validation;

import by.epam.task02.entity.SportEquipment;
import by.epam.task02.entity.User;

public class Validator {

    public static boolean sportEquipmentValidation(SportEquipment sportEquipment) {
        return !sportEquipment.equals(new SportEquipment());
    }

    public static boolean userNameValidation(String name) {
        return !name.equals("");
    }

    public static boolean userValidation(User user) {
        String userName = user.getName();
        return userNameValidation(userName);
    }

}
