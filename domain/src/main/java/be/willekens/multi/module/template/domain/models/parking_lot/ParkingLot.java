package be.willekens.multi.module.template.domain.models.parking_lot;

import be.willekens.multi.module.template.domain.models.address.Address;
import be.willekens.multi.module.template.domain.models.price.Price;

import be.willekens.multi.module.template.infrastructure.exceptions.NoParkingSpotLeftException;

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
    private int maxCapacity;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "contact_person_id")
    private ContactPerson contactPerson;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "address_id")
    private Address address;
    @Embedded
    private Price pricePerHour;
    @Column(name = "available_spots_left")
    private int availableSpotsLeft;

    public ParkingLot(String name, Category category, int maxCapacity, ContactPerson contactPerson, Address address, Price pricePerHour) {
        this.name = name;
        this.category = category;
        this.maxCapacity = maxCapacity;
        this.contactPerson = contactPerson;
        this.address = address;
        this.pricePerHour = pricePerHour;
        this.availableSpotsLeft = maxCapacity;
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

    public int getMaxCapacity() {
        return maxCapacity;
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

    public int getAvailableSpotsLeft() {
        return availableSpotsLeft;
    }

    public ParkingLot setName(String name) {
        this.name = name;
        return this;
    }

    public ParkingLot setCategory(Category category) {
        this.category = category;
        return this;
    }

    public ParkingLot setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
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

    public ParkingLot setAvailableSpotsLeft(int availableSpotLeft) {
        this.availableSpotsLeft = availableSpotLeft;
        return this;
    }

    public void reduceAvailableSpotsLeft() {
        if (this.availableSpotsLeft == 0) {
            throw new NoParkingSpotLeftException("There is no parking spot available");
        }
        this.availableSpotsLeft -= 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLot that = (ParkingLot) o;
        return id == that.id && maxCapacity == that.maxCapacity && Objects.equals(name, that.name) && category == that.category && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, maxCapacity, address);
    }
}
