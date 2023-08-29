package dao;

import model.Driver;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.math.BigDecimal;
import java.util.List;

//test
public class DriverDAOImpl implements IDriverDAO {

    //Test


    private static DriverDAOImpl instance;
    private static EntityManagerFactory emf;


    public static DriverDAOImpl getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
        instance = new DriverDAOImpl();
        }
        return instance;
    }


    @Override
    public String saveDriver(String firstName, String lastName, BigDecimal salary) {
        Driver driver = new Driver("Victor", "Musen", new BigDecimal(50000));

        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(driver);
            em.getTransaction().commit();
        }
        return driver.getId();

    }

    @Override
    public Driver getDriverById(String id) {
        Driver driver = null;

        try (var em = emf.createEntityManager()) {
            driver = em.find(Driver.class, id);

        }
        return driver;
    }

    @Override
    public Driver updateDriver(Driver driver) {

        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(driver);
            em.getTransaction().commit();
        }
        return driver;
    }

    @Override
    public void deleteDriver(String id) {

        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Driver driver = getDriverById(id);
            if (driver != null) {
                em.remove(driver);
            }
            em.getTransaction().commit();
        }
    }

    @Override
    public List<Driver> findAllDriversEmployedAtTheSameYear(String year) {

        try (var em = emf.createEntityManager()) {
            TypedQuery<Driver> query = em.createQuery("", Driver.class);
        }
       return null;
    }

    @Override
    public List<BigDecimal> fetchAllDriversWithSalaryGreaterThan10000() {
        return null;
    }

    @Override
    public double fetchHighestSalary() {
        return 0;
    }

    @Override
    public List<String> fetchFirstNameOfAllDrivers() {
        return null;
    }

    @Override
    public long calculateNumberOfDrivers() {
        return 0;
    }

    @Override
    public Driver fetchDriverWithHighestSalary() {
        return null;
    }
}
