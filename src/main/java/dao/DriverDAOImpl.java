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

    //SELECT * FROM driver WHERE EXTRACT(YEAR FROM employment_date) = 2023;
    @Override
    public List<Driver> findAllDriversEmployedAtTheSameYear(int year) {

        try (var em = emf.createEntityManager()) {
            TypedQuery<Driver> query = em.createQuery("SELECT d FROM Driver d WHERE EXTRACT(YEAR FROM d.employmentDate) = :year ", Driver.class);
            query.setParameter("year", year);
            return query.getResultList();
        }
    }

    @Override
    public List<Driver> fetchAllDriversWithSalaryGreaterThan10000() {
        try (var em = emf.createEntityManager()) {
            TypedQuery<Driver> query = em.createQuery("SELECT d FROM Driver d WHERE d.salary > 10000 ", Driver.class);
            return query.getResultList();
        }
    }

    @Override
    public BigDecimal fetchHighestSalary() {
        try (var em = emf.createEntityManager()) {
            TypedQuery<BigDecimal> query = em.createQuery("SELECT d.salary FROM Driver d ORDER by d.salary DESC LIMIT 1", BigDecimal.class);
            return query.getSingleResult();
        }
        //SELECT * FROM driver ORDER BY salary DESC LIMIT 1;
    }

    @Override
    public List<String> fetchFirstNameOfAllDrivers() {
        try (var em = emf.createEntityManager()) {
            TypedQuery<String> query = em.createQuery("SELECT d.firstName FROM Driver d", String.class);
            return query.getResultList();
        }
    }

    @Override
    public Integer calculateNumberOfDrivers() {
        try (var em = emf.createEntityManager()) {
            TypedQuery<Integer> query = em.createQuery("SELECT COUNT(d) FROM Driver d", Integer.class);
            return query.getSingleResult();
        }
    }

    @Override
    public Driver fetchDriverWithHighestSalary() {
        try (var em = emf.createEntityManager()) {
            TypedQuery<Driver> query = em.createQuery("SELECT d FROM Driver d ORDER by d.salary DESC LIMIT 1", Driver.class);
            return query.getSingleResult();
        }
    }
}
