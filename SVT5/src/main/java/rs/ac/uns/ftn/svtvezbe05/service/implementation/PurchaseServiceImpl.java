package rs.ac.uns.ftn.svtvezbe05.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.svtvezbe05.model.dto.CreditCardDTO;
import rs.ac.uns.ftn.svtvezbe05.model.entity.PurchaseOrder;
import rs.ac.uns.ftn.svtvezbe05.service.PaymentService;
import rs.ac.uns.ftn.svtvezbe05.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PaymentService paymentService;

    @Override
    public boolean processOrder(PurchaseOrder order, CreditCardDTO card) {
        return paymentService.processCreditCard(card);
    }
}
