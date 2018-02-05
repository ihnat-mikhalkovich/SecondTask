package by.epam.task02.entity;

public class User {

    private String name;

    private RentUnit rentUnit = new RentUnit();

    public User() {}

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public RentUnit getRentUnit() {
        return rentUnit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRentUnit(RentUnit rentUnit) {
        this.rentUnit = rentUnit;
    }

    public boolean add(SportEquipment sportEquipment) {
        return rentUnit.add(sportEquipment, 1);
    }

    public boolean add(SportEquipment sportEquipment, int amount) {
        return rentUnit.add(sportEquipment, amount);
    }

    public boolean remove(SportEquipment sportEquipment) {
        return rentUnit.remove(sportEquipment);
    }

    public boolean remove(SportEquipment sportEquipment, int amount){
        return rentUnit.remove(sportEquipment, amount);
    }

    public boolean hasPlace() {
        return rentUnit.hasPlace();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return rentUnit != null ? rentUnit.equals(user.rentUnit) : user.rentUnit == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (rentUnit != null ? rentUnit.hashCode() : 0);
        return result;
    }
}
