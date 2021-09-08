package com.github.LendingApplication.LenderService;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import java.util.Objects;
import java.util.UUID;

@Table("lenders")
public class Lender {
    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
    private UUID id = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Integer taxId;
    private Double investmentLimit;

    public Lender() {
    }

    public Lender(String firstName, String lastName, String phoneNumber, Integer taxId, Double investmentLimit) {
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
        Lender lenders = (Lender) o;
        return Objects.equals(id, lenders.id) && Objects.equals(firstName, lenders.firstName) && Objects.equals(lastName, lenders.lastName) && Objects.equals(phoneNumber, lenders.phoneNumber) && Objects.equals(taxId, lenders.taxId) && Objects.equals(investmentLimit, lenders.investmentLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, taxId, investmentLimit);
    }

    @Override
    public String toString() {
        return "Lenders{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", taxId=" + taxId +
                ", investmentLimit=" + investmentLimit +
                '}';
    }
}
