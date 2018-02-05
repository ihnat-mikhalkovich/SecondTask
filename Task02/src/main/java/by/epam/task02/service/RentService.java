package by.epam.task02.service;

import by.epam.task02.entity.User;

public interface RentService {

    User findUser(String name);

    void saveUser(User user);

    void deleteUserFromDB(User user);

    void printReportAboutRentGoods();

}
