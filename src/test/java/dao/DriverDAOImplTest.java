package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.Driver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DriverDAOImplTest {

    private static EntityManagerFactory emf;

    private static EntityManager em;

    private static DriverDAOImpl dao;

    @BeforeEach
    void setUp() {
       // em.createNamedQuery("Driver.deleteAllDrivers").executeUpdate();
    }

    @BeforeAll
    static void setUpAll() {
        emf = HibernateConfig.getEntityManagerFactoryConfig("recycledb");
        em = emf.createEntityManager();
        dao = DriverDAOImpl.getInstance(emf);

    }

    @Test
    void saveDriver() {
    }

    @Test
    void getDriverById() {
    }

    @Test
    void updateDriver() {
    }

    @Test
    void deleteDriver() {
    }

    @Test
    void findAllDriversEmployedAtTheSameYear() {
        int expectedAmount = 4;
        List<Driver> listOfDrivers = dao.findAllDriversEmployedAtTheSameYear(2023);
        int actualAmount = listOfDrivers.size();
        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    void fetchAllDriversWithSalaryGreaterThan10000() {
        int expectedAmount = 9;
        List<Driver> listOfDrivers = dao.fetchAllDriversWithSalaryGreaterThan10000();
        int actualAmount = listOfDrivers.size();
        assertEquals(expectedAmount, actualAmount);

    }

    @Test
    void fetchHighestSalary() {
        BigDecimal expectedAmount = new BigDecimal(65800.00);
        BigDecimal actualAmount = dao.fetchHighestSalary();
        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    void fetchFirstNameOfAllDrivers() {

    }

    @Test
    void calculateNumberOfDrivers() {
        Integer expectedAmount = 10;
        Integer actualAmount = dao.calculateNumberOfDrivers();
        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    void fetchDriverWithHighestSalary() {

    }
}