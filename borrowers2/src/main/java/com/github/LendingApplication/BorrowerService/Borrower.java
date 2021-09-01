package com.github.LendingApplication.BorrowerService;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import java.util.Objects;
import java.util.UUID;

@Table("borrowers2")
public class Borrower {
    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
    private UUID id = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Integer taxId;
    private Double investmentLimit;

    public Borrower() {
    }

    public Borrower(String firstName, String lastName, String phoneNumber, Integer taxId, Double investmentLimit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.taxId = taxId;
        this.investmentLimit = investmentLimit;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) { this.id = id; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getTaxId() {
        return taxId;
    }

    public void setTaxId(Integer taxId) {
        this.taxId = taxId;
    }

    public Double getInvestmentLimit() {
        return investmentLimit;
    }

    public void setInvestmentLimit(Double investmentLimit) {
        this.investmentLimit = investmentLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Borrower borrowers = (Borrower) o;
        return Objects.equals(id, borrowers.id) && Objects.equals(firstName, borrowers.firstName) && Objects.equals(lastName, borrowers.lastName) && Objects.equals(phoneNumber, borrowers.phoneNumber) && Objects.equals(taxId, borrowers.taxId) && Objects.equals(investmentLimit, borrowers.investmentLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, taxId, investmentLimit);
    }

    @Override
    public String toString() {
        return "Borrowers2{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", taxId=" + taxId +
                ", investmentLimit=" + investmentLimit +
                '}';
    }
}
