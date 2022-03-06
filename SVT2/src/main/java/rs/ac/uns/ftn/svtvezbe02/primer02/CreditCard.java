package rs.ac.uns.ftn.svtvezbe02.primer02;

import java.io.Serializable;

public class CreditCard implements Serializable {

    private String number;
    private int expiryMonth;
    private int expiryYear;
    private String holderName;

    public CreditCard() {
    }

    public CreditCard(String number, int expiryMonth, int expiryYear, String holderName) {
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
