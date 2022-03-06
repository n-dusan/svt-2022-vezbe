package rs.ac.uns.ftn.svtvezbe02.primer01;

import org.springframework.stereotype.Component;

@Component
public class PaymentBean implements Payment {

    @Override
    public boolean processCreditCard(CreditCard card) {
        return true;
    }
}
