package ra.session5springboot.service;

import org.omg.CORBA.UserException;
import ra.session5springboot.model.dto.request.CustomerRequest;
import ra.session5springboot.model.dto.response.CustomerResponse;

import java.util.List;

public interface ICustomerService{
    List<CustomerResponse> findAll();
    CustomerResponse findById(Long id);
    CustomerResponse save(CustomerRequest customerRequest) throws UserException;
    CustomerResponse update(CustomerRequest customerRequest, Long id);
    CustomerResponse delete(Long id);
}
