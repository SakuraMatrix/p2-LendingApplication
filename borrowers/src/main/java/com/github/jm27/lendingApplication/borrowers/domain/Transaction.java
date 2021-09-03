package com.github.jm27.lendingApplication.borrowers.domain;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Table("transactions")
public class Transaction {

    @PrimaryKeyColumn(name="id", type= PrimaryKeyType.PARTITIONED)
    private UUID id = UUID.randomUUID();
    private UUID lenderId;
    private UUID borrowerId;
    private LocalDate startDate = LocalDate.now();
    private int repaymentTerm; //loan duration in months 24 or 60 months
    private double amount;
    private double interestRate;
    private double monthlyPayment;
    private LoanStatus status = LoanStatus.PROCESSED;
    // balance
    public enum LoanStatus {
        PROCESSED,
        FULFILLED,
        UNPAID,
        PAID,
        CLOSED
    }
    public Transaction(){}

    public Transaction(UUID lenderId, UUID borrowerId, int repaymentTerm, double amount, double interestRate) {
        this.id = UUID.randomUUID();
        this.lenderId = lenderId;
        this.borrowerId = borrowerId;
        this.startDate = LocalDate.now();
        this.repaymentTerm = repaymentTerm;
        this.amount = amount;
        this.interestRate = interestRate;
        this.monthlyPayment = amount *(( (interestRate/1200) * Math.pow((1 + (interestRate/1200)), repaymentTerm)) / ((Math.pow((1 +(interestRate/1200)), repaymentTerm)) - 1));
        this.status = LoanStatus.PROCESSED;
    }
    public Transaction(UUID id, UUID lenderId, UUID borrowerId, LocalDate startDate, int repaymentTerm, double amount, double interestRate, double monthlyPayment, String status) {
        this.id = id;
        this.lenderId = lenderId;
        this.borrowerId = borrowerId;
        this.startDate = startDate;
        this.repaymentTerm = repaymentTerm;
        this.amount = amount;
        this.interestRate = interestRate;
        this.monthlyPayment = monthlyPayment;
        this.status = LoanStatus.valueOf(status);
    }


    public double calculatePayment(){
        return this.amount *(( (this.interestRate/1200) * Math.pow((1 + (this.interestRate/1200)), this.repaymentTerm)) / ((Math.pow((1 +(this.interestRate/1200)), this.repaymentTerm)) - 1));
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getLenderId() {
        return lenderId;
    }

    public void setLenderId(UUID lenderId) {
        this.lenderId = lenderId;
    }

    public UUID getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(UUID borrowerId) {
        this.borrowerId = borrowerId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getRepaymentTerm() {
        return repaymentTerm;
    }

    public void setRepaymentTerm(int repaymentTerm) {
        this.repaymentTerm = repaymentTerm;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
//    public void setMonthlyPayment() {
//        this.monthlyPayment = this.amount *(( (this.interestRate/1200) * Math.pow((1 + (this.interestRate/1200)), this.repaymentTerm)) / ((Math.pow((1 +(this.interestRate/1200)), this.repaymentTerm)) - 1));
//    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }
    public void setStatus(String status) {
        this.status = LoanStatus.valueOf(status);
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", lenderId=" + lenderId +
                ", borrowerId=" + borrowerId +
                ", startDate=" + startDate +
                ", repaymentTerm=" + repaymentTerm +
                ", amount=" + amount +
                ", interestRate=" + interestRate +
                ", monthlyPayment=" + monthlyPayment +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return repaymentTerm == that.repaymentTerm && Double.compare(that.amount, amount) == 0 && Double.compare(that.interestRate, interestRate) == 0 && Double.compare(that.monthlyPayment, monthlyPayment) == 0 && Objects.equals(id, that.id) && Objects.equals(lenderId, that.lenderId) && Objects.equals(borrowerId, that.borrowerId) && Objects.equals(startDate, that.startDate) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lenderId, borrowerId, startDate, repaymentTerm, amount, interestRate, monthlyPayment, status);
    }
}
