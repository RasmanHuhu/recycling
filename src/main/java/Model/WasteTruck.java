package Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@ToString

@Table(name = "truck")
@Entity
public class WasteTruck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "capacity")
    private int capacity;

    @Column(name ="isAvailable")
    private boolean isAvailable;

    @Setter(AccessLevel.PRIVATE)
    @Column(name = "registration_number")
    private String registrationNumber;

    @OneToMany
    @JoinColumn(name = "truck_id")
    private Set<Driver> drivers = new HashSet<>();

    public WasteTruck(String brand, int capacity, String registrationNumber) {
        this.brand = brand;
        this.capacity = capacity;
        this.registrationNumber = registrationNumber;
    }

    public WasteTruck(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}

