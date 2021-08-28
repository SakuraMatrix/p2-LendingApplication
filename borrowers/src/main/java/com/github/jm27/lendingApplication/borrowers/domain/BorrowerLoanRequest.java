package com.github.jm27.lendingApplication.borrowers.domain;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Objects;
import java.util.UUID;

@Table("borrowersLoanRequests")
public class BorrowerLoanRequest {
    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
    private UUID id = UUID.randomUUID();
    private UUID borrower_id;
    private double loan_amount;
    private Integer loan_length;
    private double interest;
    private String loan_reason;

    public BorrowerLoanRequest() {
    }

    public BorrowerLoanRequest(UUID id, UUID borrower_id, double loan_amount, Integer loan_length, double interest, String loan_reason) {
        this.id = id;
        this.borrower_id = borrower_id;
        this.loan_amount = loan_amount;
        this.loan_length = loan_length;
        this.interest = interest;
        this.loan_reason = loan_reason;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getBorrower_id() {
        return borrower_id;
    }

    public void setBorrower_id(UUID borrower_id) {
        this.borrower_id = borrower_id;
    }

    public double getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(double loan_amount) {
        this.loan_amount = loan_amount;
    }

    public Integer getLoan_length() {
        return loan_length;
    }

    public void setLoan_length(Integer loan_length) {
        this.loan_length = loan_length;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public String getLoan_reason() {
        return loan_reason;
    }

    public void setLoan_reason(String loan_reason) {
        this.loan_reason = loan_reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowerLoanRequest that = (BorrowerLoanRequest) o;
        return Double.compare(that.loan_amount, loan_amount) == 0 && Double.compare(that.interest, interest) == 0 && Objects.equals(id, that.id) && Objects.equals(borrower_id, that.borrower_id) && Objects.equals(loan_length, that.loan_length) && Objects.equals(loan_reason, that.loan_reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, borrower_id, loan_amount, loan_length, interest, loan_reason);
    }

    @Override
    public String toString() {
        return "BorrowerLoanRequest{" +
                "id=" + id +
                ", borrower_id=" + borrower_id +
                ", loan_amount=" + loan_amount +
                ", loan_length=" + loan_length +
                ", interest=" + interest +
                ", loan_reason='" + loan_reason + '\'' +
                '}';
    }
}
