package by.epam.task02.dao.source;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class PropertyFileLocation {

    private static final PropertyFileLocation instance = new PropertyFileLocation();

    private final String propertyPathLocation = "resources/property.txt";

    private String[] paths;

    private PropertyFileLocation() {
        try (FileReader fileReader = new FileReader(propertyPathLocation);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            LinkedList<String> stringList = new LinkedList<>();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
            paths = stringList.toArray(new String[stringList.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error();
        }
    }

    public static PropertyFileLocation getInstance() {
        return instance;
    }

    public String getPropertyLocation() {
        return propertyPathLocation;
    }

    public String[] getPaths() {
        return paths;
    }

}
