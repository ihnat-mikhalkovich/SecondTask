package by.epam.task02.entity.factory;

import by.epam.task02.entity.RentUnit;

public interface RentUnitCommand {

    RentUnit execute(String[] sportEquipments);

}
