package by.epam.task02.entity;

import java.util.*;

public class RentUnit {

    public static final int MAX_SIZE = 3;

    private Map<SportEquipment, Integer> units = new HashMap<>();

    public RentUnit() {}

    public Map<SportEquipment, Integer> getUnits() {
        return units;
    }

    public boolean add(SportEquipment sportEquipment, int amount) {
        if (!hasPlace()) {
            return false;
        }
        units.put(sportEquipment, units.getOrDefault(sportEquipment, 0) + amount);
        return true;
    }

    public boolean remove(SportEquipment sportEquipment) {
        if (!units.containsKey(sportEquipment)) {
            return false;
        }
        units.put(sportEquipment, units.get(sportEquipment) - 1);
        if (units.get(sportEquipment) < 1) {
            units.remove(sportEquipment);
        }
        return true;
    }

    public boolean remove(SportEquipment sportEquipment, int amount) {
        if (!units.containsKey(sportEquipment)) {
            return false;
        }
        if (units.get(sportEquipment) < amount) {
            return false;
        }
        units.put(sportEquipment, units.get(sportEquipment) - amount);
        if (units.get(sportEquipment) < 1) {
            units.remove(sportEquipment);
        }
        return true;
    }

    public boolean hasPlace() {
        Collection<Integer> amounts = units.values();
        int allAmount = 0;
        for (Integer amount : amounts) {
            allAmount += amount;
        }
        return allAmount < MAX_SIZE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RentUnit rentUnit = (RentUnit) o;

        return units != null ? units.equals(rentUnit.units) : rentUnit.units == null;
    }

    @Override
    public int hashCode() {
        return units != null ? units.hashCode() : 0;
    }
}
