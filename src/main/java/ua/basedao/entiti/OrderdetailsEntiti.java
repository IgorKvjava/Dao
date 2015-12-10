package ua.basedao.entiti;

import javax.persistence.*;

/**
 * Created by liny on 10.12.15.
 */
@Entity
@Table(name = "orderdetails", schema = "classicmodels")
@IdClass(OrderdetailsEntitiPK.class)
public class OrderdetailsEntiti {
    private int orderNumber;
    private String productCode;
    private int quantityOrdered;
    private double priceEach;
    private short orderLineNumber;

    @Id
    @Column(name = "orderNumber")
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Id
    @Column(name = "productCode")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Basic
    @Column(name = "quantityOrdered")
    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    @Basic
    @Column(name = "priceEach")
    public double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
    }

    @Basic
    @Column(name = "orderLineNumber")
    public short getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(short orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderdetailsEntiti that = (OrderdetailsEntiti) o;

        if (orderNumber != that.orderNumber) return false;
        if (quantityOrdered != that.quantityOrdered) return false;
        if (Double.compare(that.priceEach, priceEach) != 0) return false;
        if (orderLineNumber != that.orderLineNumber) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = orderNumber;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + quantityOrdered;
        temp = Double.doubleToLongBits(priceEach);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) orderLineNumber;
        return result;
    }
}
