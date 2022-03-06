package rs.ac.uns.ftn.svtvezbe02.primer02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PurchaseBean implements Purchase {

    @Autowired
    private Payment payment;

    @Override
    public boolean processOrder(Order order) {
        return payment.processCreditCard(order.getCreditCard());
    }
}
