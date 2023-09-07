package ra.session5springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.session5springboot.model.domain.Customer;
import ra.session5springboot.model.dto.request.CustomerRequest;
import ra.session5springboot.model.dto.response.CustomerResponse;
import ra.session5springboot.repository.ICustomerRepository;
import ra.session5springboot.service.ICustomerService;
import ra.session5springboot.service.mapper.CustomerMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public List<CustomerResponse> findAll() {
        return customerRepository.findAll().stream()
                .map(c -> customerMapper.toResponse(c))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponse findById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(customerOptional.isPresent()) {
            return customerMapper.toResponse(customerOptional.get());
        }
        return null;
    }

    @Override
    public CustomerResponse save(CustomerRequest customerRequest) {
        Customer cus = customerRepository.save(customerMapper.toEntity(customerRequest));
        return customerMapper.toResponse(cus);
    }

    @Override
    public CustomerResponse update(CustomerRequest customerRequest, Long id) {
        Customer customer = customerMapper.toEntity(customerRequest);
        customer.setId(id);
        return customerMapper.toResponse(customerRepository.save(customer));
    }

    @Override
    public CustomerResponse delete(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(customerOptional.isPresent()) {
            customerRepository.delete(customerOptional.get());
            return customerMapper.toResponse(customerOptional.get());
        }
        return null;
    }
}
