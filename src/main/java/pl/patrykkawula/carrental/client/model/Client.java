package pl.patrykkawula.carrental.client.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String bankAccount;
    private LocalDate dateOfBirth;
    private String drivingLicenseNumber;
//    @OneToMany(mappedBy = "client")
//    List<Rent> rentList = new ArrayList<>();
    @ManyToOne
    private Address address;

    public Client() {
    }
}
