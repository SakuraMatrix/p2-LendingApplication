package com.github.LendingApplication.LenderService;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import java.util.Objects;
import java.util.UUID;

@Table("borrowers3")
public class Lender {
    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
    private UUID id = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private Double funds;
    private Integer creditScore;
    private Integer rating;

    public Lender() {
    }

    public Lender(String firstName, String lastName, Double funds, Integer creditScore, Integer rating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.funds = funds;
        this.creditScore = creditScore;
        this.rating = rating;
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

    public Double getFunds() {
        return funds;
    }

    public void setFunds(Double funds) {
        this.funds = funds;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Lender{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", funds=" + funds +
                ", creditScore=" + creditScore +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lender lender = (Lender) o;
        return Objects.equals(id, lender.id) && Objects.equals(firstName, lender.firstName) && Objects.equals(lastName, lender.lastName) && Objects.equals(funds, lender.funds) && Objects.equals(creditScore, lender.creditScore) && Objects.equals(rating, lender.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, funds, creditScore, rating);
    }
}

