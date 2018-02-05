package by.epam.task02.dao.impl;

import by.epam.task02.dao.RentDAO;
import by.epam.task02.dao.source.rent.SourceRentReader;
import by.epam.task02.dao.source.rent.SourceRentWriter;
import by.epam.task02.entity.User;
import by.epam.task02.entity.factory.UserCommand;
import by.epam.task02.entity.factory.UserCreator;

public class RentDAOImpl implements RentDAO {

    @Override
    public User findUser(String name) {
        SourceRentReader sourceRentReader = SourceRentReader.getInstance();
        String[] sportEquipmentOfUser = sourceRentReader.findUser(name);
        UserCommand userCommand = new UserCreator();
        User user = userCommand.execute(name, sportEquipmentOfUser);
        return user;
    }

    @Override
    public void saveUser(User user){
        deleteUserFromDB(user);
        SourceRentWriter sourceRentWriter = SourceRentWriter.getInstance();
        sourceRentWriter.saveUser(user);
    }

    @Override
    public void deleteUserFromDB(User user){
        SourceRentWriter sourceRentWriter = SourceRentWriter.getInstance();
        sourceRentWriter.deleteUser(user);
    }

    @Override
    public void printReportAboutRentGoods() {
        SourceRentReader sourceRentReader = SourceRentReader.getInstance();
        sourceRentReader.printRentInfo();
    }

}
