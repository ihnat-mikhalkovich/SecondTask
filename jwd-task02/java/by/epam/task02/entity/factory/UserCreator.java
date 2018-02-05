package by.epam.task02.entity.factory;

import by.epam.task02.entity.RentUnit;
import by.epam.task02.entity.User;

public class UserCreator implements UserCommand {

    @Override
    public User execute(String name, String[] sportEquipmentsOfUser){
        User user = new User(name);
        RentUnitCommand rentUnitCommand = new RentUnitCreator();
        RentUnit rentUnit = rentUnitCommand.execute(sportEquipmentsOfUser);
        user.setRentUnit(rentUnit);
        return user;
    }

}
