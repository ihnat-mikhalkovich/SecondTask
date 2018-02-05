package by.epam.task02.dao.source.rent;

import by.epam.task02.dao.source.Routable;
import by.epam.task02.dao.source.SourceFilesLocation;
import by.epam.task02.entity.User;
import by.epam.task02.entity.factory.UserCommand;
import by.epam.task02.entity.factory.UserCreator;
import by.epam.task02.main.ConsolePrinter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class SourceRentReader implements Routable {

    private static final SourceRentReader instance = new SourceRentReader();

    private final String route = "rent";

    public SourceRentReader() {}

    public static SourceRentReader getInstance() {
        return instance;
    }

    public String[] findUser(String name) {
        SourceFilesLocation sourceFilesLocation = SourceFilesLocation.getInstance();
        String sourcePath = sourceFilesLocation.getRoute(route);
        String[] sportEquipmentsOfUser;
        try (FileReader fileReader = new FileReader(sourcePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            LinkedList<String> userList = new LinkedList<>();
            String line = null;
            String searchName = "$" + name;
            boolean userPlace = false;
            while ((line = bufferedReader.readLine()) != null) {
                if (userPlace && line.contains("$")) {
                    break;
                }
                if (line.contains("$") && !line.equals(searchName)) {
                    userPlace = false;
                    continue;
                }
                if (line.equals(searchName)) {
                    userPlace = true;
                    continue;
                }
                if (!userPlace) {
                    continue;
                }
                userList.add(line);
            }
        sportEquipmentsOfUser = userList.toArray(new String[userList.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error();
        }
        return sportEquipmentsOfUser;
    }

    public void printRentInfo(){
        SourceFilesLocation sourceFilesLocation = SourceFilesLocation.getInstance();
        String sourcePath = sourceFilesLocation.getRoute(route);
        try (FileReader fileReader = new FileReader(sourcePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            LinkedList<String> userList = new LinkedList<>();
            String line = null;
            String userName = null;
            boolean firstLineCheck = true;
            User user;
            UserCommand userCommand = new UserCreator();
            ConsolePrinter consolePrinter = new ConsolePrinter();
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("$")) {
                    if (!firstLineCheck) {
                        String[] sportEquipmentList = userList.toArray(new String[userList.size()]);
                        user = userCommand.execute(userName, sportEquipmentList);
                        consolePrinter.userPrint(user);
                        userList.clear();
                    }
                    userName = line.replace("$", "");
                    firstLineCheck = false;
                } else {
                    userList.add(line);
                }
            }
            String[] sportEquipmentList = userList.toArray(new String[userList.size()]);
            user = userCommand.execute(userName, sportEquipmentList);
            consolePrinter.userPrint(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error();
        }
    }

}
