package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverImplTest {

    private static EntityManagerFactory emf;

    private static EntityManager em;

    private static DriverImpl dao;

    @BeforeEach
    @Test
    void setUp() {
        em.createNamedQuery("Driver.deleteAllDrivers").executeUpdate();
    }

    @BeforeAll
    static void setUpAll() {
        emf = HibernateConfig.getEntityManagerFactoryConfig();
        em = emf.createEntityManager();
        dao = DriverImpl.getInstance(emf);

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
    }

    @Test
    void fetchAllDriversWithSalaryGreaterThan10000() {
    }

    @Test
    void fetchHighestSalary() {
    }

    @Test
    void fetchFirstNameOfAllDrivers() {
    }

    @Test
    void calculateNumberOfDrivers() {
    }

    @Test
    void fetchDriverWithHighestSalary() {
    }
}