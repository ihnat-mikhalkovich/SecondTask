package by.epam.task02.entity.factory;

import by.epam.task02.entity.SportEquipment;

public class SportEquipmentCreator implements SportEquipmentCommand {

    @Override
    public SportEquipment execute(String[] strings) {
        SportEquipment sportEquipment = SportEquipment.objectByStrings(strings);
        return sportEquipment;
    }

}
