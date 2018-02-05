package by.epam.task02.dao.source;

import java.util.HashMap;
import java.util.Map;

public class SourceFilesLocation {

    private static final SourceFilesLocation instance = new SourceFilesLocation();

    private final String[] names = {"shop", "rent"};

    private Map<String, String> routeMap = new HashMap<>();

    private SourceFilesLocation() {
        PropertyFileLocation propertyFileLocation = PropertyFileLocation.getInstance();
        String[] paths = propertyFileLocation.getPaths();
        for (int i = 0; i < names.length; i++) {
            routeMap.put(names[i], paths[i]);
        }
    }

    public static SourceFilesLocation getInstance() {
        return instance;
    }

    public String getRoute(String string) {
        if (!routeMap.containsKey(string)) {
            return null;
        }
        return routeMap.get(string);
    }

}
