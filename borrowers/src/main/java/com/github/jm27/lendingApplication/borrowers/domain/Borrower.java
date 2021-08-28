package com.github.jm27.lendingApplication.borrowers.domain;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Objects;
import java.util.UUID;

@Table("borrowers")
public class Borrower {
    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
    private UUID id = UUID.randomUUID();
    private String first_name;
    private String last_name;
    private Double funds;
    private Integer credit_score;
    private Integer rating;

    public Borrower() {
    }

    public Borrower(UUID id, String first_name, String last_name, Double funds, Integer credit_score, Integer rating) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.funds = funds;
        this.credit_score = credit_score;
        this.rating = rating;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Double getFunds() {
        return funds;
    }

    public void setFunds(Double funds) {
        this.funds = funds;
    }

    public Integer getCredit_score() {
        return credit_score;
    }

    public void setCredit_score(Integer credit_score) {
        this.credit_score = credit_score;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Borrower borrower = (Borrower) o;
        return Objects.equals(id, borrower.id) && Objects.equals(first_name, borrower.first_name) && Objects.equals(last_name, borrower.last_name) && Objects.equals(funds, borrower.funds) && Objects.equals(credit_score, borrower.credit_score) && Objects.equals(rating, borrower.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, funds, credit_score, rating);
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", funds=" + funds +
                ", credit_score=" + credit_score +
                ", rating=" + rating +
                '}';
    }
}
