package by.epam.task02.entity.factory;

import by.epam.task02.entity.RentUnit;
import by.epam.task02.entity.SportEquipment;

public class RentUnitCreator implements RentUnitCommand {

    @Override
    public RentUnit execute(String[] sportEquipments) {
        RentUnit rentUnit = new RentUnit();
        for (String record : sportEquipments) {
            String[] fields = record.split(" ");
            SportEquipment sportEquipment = SportEquipment.objectByStrings(fields);
            int amount = Integer.parseInt(fields[fields.length - 1]);
            rentUnit.add(sportEquipment, amount);
        }
        return rentUnit;
    }

}
