package dao;

import model.Driver;

import java.math.BigDecimal;
import java.util.List;

public interface IDriverDAO {

    // Driver
    String saveDriver(String name, String surname, BigDecimal salary);
    Driver getDriverById(String id);
    Driver updateDriver(Driver driver);
    void deleteDriver(String id);
    List<Driver> findAllDriversEmployedAtTheSameYear(int year);
    List<Driver> fetchAllDriversWithSalaryGreaterThan10000();
    BigDecimal fetchHighestSalary();
    List<String> fetchFirstNameOfAllDrivers();
    Integer calculateNumberOfDrivers();
    Driver fetchDriverWithHighestSalary();

}
