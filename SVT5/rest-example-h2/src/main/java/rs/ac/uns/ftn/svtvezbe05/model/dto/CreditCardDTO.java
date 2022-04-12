package rs.ac.uns.ftn.svtvezbe05.model.dto;

import java.io.Serializable;

public class CreditCardDTO implements Serializable {

    private String number;

    private int expiryMonth;

    private int expiryYear;

    private String holderName;

    public CreditCardDTO() {
    }

    public CreditCardDTO(String number, int expiryMonth, int expiryYear, String holderName) {
        this.number = number;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.holderName = holderName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(int expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public int getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
}
