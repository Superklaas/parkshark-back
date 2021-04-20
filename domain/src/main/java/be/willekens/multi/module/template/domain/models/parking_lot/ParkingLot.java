package be.willekens.multi.module.template.domain.models.parking_lot;

public class ParkingLot {

    private int id;
    private String name;
    private Category category;
    private int maxCapacaity;
    private ContactPerson contactPerson;
    private Address address;
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
}
