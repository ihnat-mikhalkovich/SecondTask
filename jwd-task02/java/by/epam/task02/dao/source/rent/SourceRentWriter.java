package by.epam.task02.dao.source.rent;

import by.epam.task02.dao.source.Routable;
import by.epam.task02.dao.source.SourceFilesLocation;
import by.epam.task02.entity.StringInfo;
import by.epam.task02.entity.User;

import java.io.*;

public class SourceRentWriter implements Routable {

    private static final SourceRentWriter instance = new SourceRentWriter();

    private final String route = "rent";

    private SourceRentWriter() {}

    public static SourceRentWriter getInstance() {
        return instance;
    }

    public void deleteUser(User user) {
        SourceFilesLocation sourceFilesLocation = SourceFilesLocation.getInstance();
        String sourcePath = sourceFilesLocation.getRoute(route);
        File sourceFile = new File(sourcePath); //
        File outputFile = new File("tmp.txt");
        try (FileWriter fileWriter = new FileWriter(outputFile);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             FileReader fileReader = new FileReader(sourceFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = null;
            boolean writeLine = true;
            String userNameInFile = "$" + user.getName();
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals(userNameInFile)) {
                    writeLine = false;
                    continue;
                }
                if (!writeLine && line.contains("$")) {
                    writeLine = true;
                }
                if (!writeLine) {
                    continue;
                }
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedReader.close();
            bufferedWriter.close();
            sourceFile.delete();
            outputFile.renameTo(new File(sourcePath));
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error();
        }
    }

    public void saveUser(User user) {
        SourceFilesLocation sourceFilesLocation = SourceFilesLocation.getInstance();
        String sourcePath = sourceFilesLocation.getRoute(route);
        try (FileWriter fileWriter = new FileWriter(sourcePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            StringInfo stringInfo = new StringInfo();
            bufferedWriter.write("$" + stringInfo.userInfo(user));
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error();
        }
    }

}
