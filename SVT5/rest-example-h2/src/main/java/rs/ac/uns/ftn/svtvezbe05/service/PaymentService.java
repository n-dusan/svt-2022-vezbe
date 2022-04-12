package rs.ac.uns.ftn.svtvezbe05.service;

import rs.ac.uns.ftn.svtvezbe05.model.dto.CreditCardDTO;

public interface PaymentService {

    boolean processCreditCard(CreditCardDTO card);
    
}
