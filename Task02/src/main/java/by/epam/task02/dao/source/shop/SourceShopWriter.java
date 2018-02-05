package by.epam.task02.dao.source.shop;

import by.epam.task02.dao.source.Routable;
import by.epam.task02.dao.source.SourceFilesLocation;

import java.io.*;

public class SourceShopWriter implements Routable {

    private static SourceShopWriter instance = new SourceShopWriter();

    private final String route = "shop";

    public static SourceShopWriter getInstance() {
        return instance;
    }

    private SourceShopWriter() {}

    public void write(String[] records) {
        SourceFilesLocation sourceFilesLocation = SourceFilesLocation.getInstance();
        String sourcePath = sourceFilesLocation.getRoute(route);
        if (records.equals("")) {
            return;
        }
        try (FileWriter fileWriter = new FileWriter(sourcePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (String record : records) {
                bufferedWriter.write(record);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error();
        }
    }

    public void deleteEmptyLines() {
        SourceFilesLocation sourceFilesLocation = SourceFilesLocation.getInstance();
        String sourcePath = sourceFilesLocation.getRoute(route);
        File sourceFile = new File(sourcePath);
        File outputFile = new File("tmp.txt");
        try (FileWriter fileWriter = new FileWriter(outputFile);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             FileReader fileReader = new FileReader(sourceFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals("")) {
                    continue;
                }
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.flush();
            bufferedWriter.close();
            sourceFile.delete();
            outputFile.renameTo(sourceFile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error();
        }
    }

}
