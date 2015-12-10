package ua.basedao.entiti;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by liny on 10.12.15.
 */
@Entity
@Table(name = "payments", schema = "classicmodels")
@IdClass(PaymentsEntitiPK.class)
public class PaymentsEntiti {
    private int customerNumber;
    private String checkNumber;
    private Serializable paymentDate;
    private double amount;

    @Id
    @Column(name = "customerNumber")
    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Id
    @Column(name = "checkNumber")
    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Basic
    @Column(name = "paymentDate")
    public Serializable getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Serializable paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Basic
    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentsEntiti that = (PaymentsEntiti) o;

        if (customerNumber != that.customerNumber) return false;
        if (Double.compare(that.amount, amount) != 0) return false;
        if (checkNumber != null ? !checkNumber.equals(that.checkNumber) : that.checkNumber != null) return false;
        if (paymentDate != null ? !paymentDate.equals(that.paymentDate) : that.paymentDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = customerNumber;
        result = 31 * result + (checkNumber != null ? checkNumber.hashCode() : 0);
        result = 31 * result + (paymentDate != null ? paymentDate.hashCode() : 0);
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
