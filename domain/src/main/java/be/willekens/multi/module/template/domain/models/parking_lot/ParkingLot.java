package be.willekens.multi.module.template.domain.models.parking_lot;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="parking_lot")
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_id")
    private int id;
    @Column(name="parking_lot_name")
    private String name;
    @Enumerated(value=EnumType.STRING)
    private Category category;
    @Column(name="max_capacity")
    private int maxCapacaity;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    private ContactPerson contactPerson;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    private Address address;
    @Embedded
    private Price pricePerHour;

    public ParkingLot(String name, Category category, int maxCapacaity, ContactPerson contactPerson, Address address, Price pricePerHour) {
        this.name = name;
        this.category = category;
        this.maxCapacaity = maxCapacaity;
        this.contactPerson = contactPerson;
        this.address = address;
        this.pricePerHour = pricePerHour;
    }

    public ParkingLot() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getMaxCapacaity() {
        return maxCapacaity;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public Address getAddress() {
        return address;
    }

    public Price getPricePerHour() {
        return pricePerHour;
    }

    public ParkingLot setName(String name) {
        this.name = name;
        return this;
    }

    public ParkingLot setCategory(Category category) {
        this.category = category;
        return this;
    }

    public ParkingLot setMaxCapacaity(int maxCapacaity) {
        this.maxCapacaity = maxCapacaity;
        return this;
    }

    public ParkingLot setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }

    public ParkingLot setAddress(Address address) {
        this.address = address;
        return this;
    }

    public ParkingLot setPricePerHour(Price pricePerHour) {
        this.pricePerHour = pricePerHour;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLot that = (ParkingLot) o;
        return id == that.id && maxCapacaity == that.maxCapacaity && Objects.equals(name, that.name) && category == that.category && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, maxCapacaity, address);
    }
}
