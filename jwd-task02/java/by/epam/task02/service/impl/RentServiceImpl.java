package by.epam.task02.service.impl;

import by.epam.task02.dao.DAOUserFactory;
import by.epam.task02.dao.RentDAO;
import by.epam.task02.entity.User;
import by.epam.task02.service.RentService;
import by.epam.task02.service.validation.Validator;

public class RentServiceImpl implements RentService {

    @Override
    public User findUser(String name) {
        if (!Validator.userNameValidation(name)) {
            return null;
        }
        DAOUserFactory userFactory = DAOUserFactory.getInstance();
        RentDAO rentDAO = userFactory.getRentDAO();
        return rentDAO.findUser(name);
    }

    @Override
    public void saveUser(User user) {
        if (!Validator.userValidation(user)) {
            return;
        }
        DAOUserFactory userFactory = DAOUserFactory.getInstance();
        RentDAO rentDAO = userFactory.getRentDAO();
        rentDAO.saveUser(user);
    }

    @Override
    public void deleteUserFromDB(User user) {
        if (!Validator.userValidation(user)) {
            return;
        }
        DAOUserFactory userFactory = DAOUserFactory.getInstance();
        RentDAO rentDAO = userFactory.getRentDAO();
        rentDAO.deleteUserFromDB(user);
    }

    @Override
    public void printReportAboutRentGoods() {
        DAOUserFactory userFactory = DAOUserFactory.getInstance();
        RentDAO rentDAO = userFactory.getRentDAO();
        rentDAO.printReportAboutRentGoods();
    }
}
