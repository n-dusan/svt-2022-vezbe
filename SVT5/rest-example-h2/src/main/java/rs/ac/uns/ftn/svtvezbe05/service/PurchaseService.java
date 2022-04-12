package rs.ac.uns.ftn.svtvezbe05.service;

import rs.ac.uns.ftn.svtvezbe05.model.dto.CreditCardDTO;
import rs.ac.uns.ftn.svtvezbe05.model.entity.PurchaseOrder;

public interface PurchaseService {

    boolean processOrder(PurchaseOrder order, CreditCardDTO card);

}
