package by.epam.task02.dao;

import by.epam.task02.entity.User;

public interface RentDAO {

    User findUser(String name);

    void saveUser(User user);

    void deleteUserFromDB(User user);

    void printReportAboutRentGoods();

}
