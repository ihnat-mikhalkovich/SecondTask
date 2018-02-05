package by.epam.task02.main;

import by.epam.task02.entity.SportEquipment;
import by.epam.task02.entity.User;

public interface Behavior {

    boolean userGetSportEquipment(User user, SportEquipment sportEquipment, int amount);

    boolean userReturnSportEquipment(User user, SportEquipment sportEquipment, int amount);

}
