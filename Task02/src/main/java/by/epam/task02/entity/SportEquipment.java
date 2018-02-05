package by.epam.task02.entity;

import by.epam.task02.entity.category.Category;

public class SportEquipment {

    private Category category = null;

    private String title = "";

    private double price = 0.0;

    private String color = "";

    private String stringSize = "";

    public SportEquipment() {}

    public SportEquipment(Category category, String title, double price, String color, String stringSize) {
        this.category = category;
        this.title = title;
        this.price = price;
        this.color = color;
        this.stringSize = stringSize;
    }

    public static SportEquipment objectByStrings(String[] strings) {
        Category category = Category.valueOf(strings[0].toUpperCase());
        String title = strings[1];
        double price = Double.parseDouble(strings[2]);
        String color = strings[3];
        String stringSize = strings[4];
        return new SportEquipment(category, title, price, color, stringSize);
    }

    public Category getCategory() {
        return category;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public String getStringSize() {
        return stringSize;
    }

    public String getTitle() {
        return title;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStringSize(double size) {
        this.stringSize = stringSize;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean conformity(SportEquipment sportEquipment) {
        int notDefaultFields = 0;
        if (this.category != null) {
            notDefaultFields++;
        }
        if (!this.title.equals("")) {
            notDefaultFields++;
        }
        if (this.price != 0.0) {
            notDefaultFields++;
        }
        if (!this.color.equals("")){
            notDefaultFields++;
        }
        if (!this.stringSize.equals("")) {
            notDefaultFields++;
        }

        int numberEqualFields = 0;
        if (this.category == sportEquipment.category) {
            numberEqualFields++;
        }
        if (this.title.equals(sportEquipment.title)) {
            numberEqualFields++;
        }
        if (this.price == sportEquipment.price) {
            numberEqualFields++;
        }
        if (this.color.equals(sportEquipment.color)) {
            numberEqualFields++;
        }
        if (this.stringSize.equals(sportEquipment.stringSize)) {
            numberEqualFields++;
        }

        return (notDefaultFields == numberEqualFields);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SportEquipment that = (SportEquipment) o;

        if (Double.compare(that.price, price) != 0) return false;
        if (category != that.category) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        return stringSize != null ? stringSize.equals(that.stringSize) : that.stringSize == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = category != null ? category.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (stringSize != null ? stringSize.hashCode() : 0);
        return result;
    }
}
