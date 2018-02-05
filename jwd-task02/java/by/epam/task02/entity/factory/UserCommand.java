package by.epam.task02.entity.factory;

import by.epam.task02.entity.User;

public interface UserCommand {

    User execute(String name, String[] sportEquipmentOfUser);

}
