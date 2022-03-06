package rs.ac.uns.ftn.svtvezbe05.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.svtvezbe05.model.entity.Supplier;
import rs.ac.uns.ftn.svtvezbe05.repository.SupplierRepository;
import rs.ac.uns.ftn.svtvezbe05.service.SupplierService;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public Supplier findOne(Integer supplierId) {
        return supplierRepository.findById(supplierId).orElse(null);
    }

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public void remove(Integer id) {
        supplierRepository.deleteById(id);
    }
}
