package com.busraciftlik.starbucksproject.adapters;

import com.busraciftlik.starbucksproject.business.abstracts.CustomerCheckService;
import com.busraciftlik.starbucksproject.entities.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tr.gov.nvi.tckimlik.ws.KPSPublic;
import tr.gov.nvi.tckimlik.ws.KPSPublicSoap;
@Service
@AllArgsConstructor
public class MernisCustomerCheckManager implements CustomerCheckService {
    @Override
    public boolean checkIfRealCustomer(Customer customer) {
        KPSPublic kpsPublic = new KPSPublic();
        KPSPublicSoap kpsPublicSoap = kpsPublic.getKPSPublicSoap();
        return kpsPublicSoap.tcKimlikNoDogrula(customer.getNationalIdentity(),
                                               customer.getFirstName(),
                                               customer.getLastName(),
                                               customer.getDateOfBirth().getYear());
    }
}
