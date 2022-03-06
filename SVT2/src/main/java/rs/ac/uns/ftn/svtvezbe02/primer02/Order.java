package rs.ac.uns.ftn.svtvezbe02.primer02;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {

    private Date date;
    private CreditCard creditCard;
    private List<String> items;
    private List<Integer> quantities;
    private BigDecimal total;

    public Order() {
    }

    public Order(Date date, CreditCard creditCard, List<String> items, List<Integer> quantities, BigDecimal total) {
        this.date = date;
        this.creditCard = creditCard;
        this.items = items;
        this.quantities = quantities;
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<Integer> quantities) {
        this.quantities = quantities;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
