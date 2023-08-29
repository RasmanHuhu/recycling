package model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

@Getter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "driver")
@NamedQueries({@NamedQuery(name = "Driver.deleteAllDrivers", query = "DELETE FROM Driver d")})
public class Driver {


    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String Id;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Setter(AccessLevel.NONE)
    @Column(name = "employment_date", nullable = false)
    private LocalDateTime employmentDate;

    @Column(name = "salary")
    private BigDecimal salary;

    public Driver(String firstName, String lastName, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    private String generateID() {

        String driverId = "";
        LocalDateTime now = LocalDateTime.now();
        driverId += now.getYear() % 100;      //boolean      //true              //false
        driverId += now.getMonthValue() < 10 ? "0" + now.getMonthValue() : now.getMonthValue();
        driverId += now.getDayOfMonth() < 10 ? "0" + now.getDayOfMonth() : now.getDayOfMonth();
        driverId += "-";
        driverId += firstName.toUpperCase().charAt(0);
        driverId += lastName.toUpperCase().charAt(0);
        driverId += "-";
        driverId += (int) (Math.random() * 900) + 100;
        driverId += new Random().nextInt(899) + 100;
        driverId += lastName.toUpperCase().charAt(lastName.length() - 1);
        return driverId;

        /*
        LocalDateTime ldtnow = LocalDateTime.now();
        String driverId = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");
        driverId += ldtnow.format(formatter);
        driverId += '-';
        driverId += firstName.charAt(0);
        driverId += lastName.charAt(0);
        driverId += "";
        driverId += '-';
        driverId += new Random().nextInt(899)+100;
*/

    }

    public Boolean validateDriverId(String driverId) {
        return driverId.matches("[0-9][0-9][0-9][0-9][0-9][0-9]-[A-Z][A-Z]-[0-9][0-9][0-9][A-Z]");

    }

    @PrePersist
    private void onPrePersist() {

        employmentDate = LocalDateTime.now();
        Id = generateID();


    }
}
