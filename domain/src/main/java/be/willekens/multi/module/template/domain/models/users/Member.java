package be.willekens.multi.module.template.domain.models.users;


import be.willekens.multi.module.template.domain.models.LicencePlate;
import be.willekens.multi.module.template.domain.models.parking_lot.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "members")
@NoArgsConstructor
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    private Address address;
    @Column(name = "phone_number")
    private String phoneNumber;

    @Embedded
    private LicencePlate licencePlate;
    @Column(name = "registration_date",columnDefinition = "DATE")
    private LocalDate registrationDate;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    private Account account;

    public Member setAccount(Account account) {
        this.account = account;
        return this;
    }

    public Member setId(int id) {
        this.id = id;
        return this;
    }

    public Member setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Member setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Member setAddress(Address address) {
        this.address = address;
        return this;
    }

    public Member setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }


    public Member setLicencePlate(LicencePlate licencePlate) {
        this.licencePlate = licencePlate;
        return this;
    }

    public Member setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }
}
