package by.epam.task02.dao.source.shop;

import by.epam.task02.dao.source.SourceFilesLocation;
import by.epam.task02.entity.Shop;
import by.epam.task02.entity.SportEquipment;
import by.epam.task02.main.ConsolePrinter;

import java.io.*;
import java.util.LinkedList;

public class SourceShopReader {

    private static final SourceShopReader instance = new SourceShopReader();

    private final String route = "shop";

    private final int startFillShop = 3;

    private SourceShopReader() {}

    public static SourceShopReader getInstance() {
        return instance;
    }

    public void printShopInfo() {
        SourceFilesLocation sourceFilesLocation = SourceFilesLocation.getInstance();
        String sourcePath = sourceFilesLocation.getRoute(route);
        try (FileReader fileReader = new FileReader(sourcePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            ConsolePrinter consolePrinter = new ConsolePrinter();
            while((line = bufferedReader.readLine()) != null) {
                String[] fieldsOfSportEquipment = line.split(" ");
                SportEquipment sportEquipment = SportEquipment.objectByStrings(fieldsOfSportEquipment);
                int amount = Integer.parseInt(fieldsOfSportEquipment[fieldsOfSportEquipment.length - 1]);
                consolePrinter.sportEquipmentPrint(sportEquipment);
                System.out.println("; amount: " + amount + ";");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error();
        }
    }

    public String[] load() {
        SourceFilesLocation sourceFilesLocation = SourceFilesLocation.getInstance();
        String sourcePath = sourceFilesLocation.getRoute(route);
        File sourceFile = new File(sourcePath);
        File outputFile = new File("tmp.txt");
        try (FileWriter fileWriter = new FileWriter(outputFile);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             FileReader fileReader = new FileReader(sourceFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            LinkedList<String> sportEquipmentList = new LinkedList<>();
            String line = null;
            int lineCounter = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (lineCounter < startFillShop) {
                    sportEquipmentList.add(line);
                    lineCounter++;
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
            String[] sportEquipments = sportEquipmentList.toArray(new String[sportEquipmentList.size()]);

            return sportEquipments;

        } catch (Exception e) {
            e.printStackTrace();
            throw new Error();
        }
    }

        public boolean find(SportEquipment sportEquipment) {
            SourceFilesLocation sourceFilesLocation = SourceFilesLocation.getInstance();
            String sourcePath = sourceFilesLocation.getRoute(route);
            Shop shop = Shop.getInstance();
            File sourceFile = new File(sourcePath);
            File outputFile = new File("tmp.txt");
            try (FileWriter fileWriter = new FileWriter(outputFile);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                 FileReader fileReader = new FileReader(sourceFile);
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                boolean flagOfSuccess = false;
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] fieldsAndAmount = line.split(" ");
                    SportEquipment fileSportEquipment = SportEquipment.objectByStrings(fieldsAndAmount);
                    if (sportEquipment.conformity(fileSportEquipment)) {
                        int amount = Integer.parseInt(fieldsAndAmount[fieldsAndAmount.length - 1]);
                        shop.add(fileSportEquipment, amount);
                        flagOfSuccess = true;
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
                return flagOfSuccess;
            } catch (Exception e) {
                e.printStackTrace();
                throw new Error();
            }
        }


}
