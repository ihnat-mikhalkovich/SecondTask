package by.epam.task02.dao;

import by.epam.task02.dao.impl.RentDAOImpl;

public class DAOUserFactory {

    private static final DAOUserFactory instance = new DAOUserFactory();

    private final RentDAO rentDAO = new RentDAOImpl();

    private DAOUserFactory() {}

    public static DAOUserFactory getInstance() {
        return instance;
    }

    public RentDAO getRentDAO() {
        return rentDAO;
    }

}
