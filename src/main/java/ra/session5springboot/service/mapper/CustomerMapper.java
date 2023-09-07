package ra.session5springboot.service.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ra.session5springboot.model.domain.Customer;
import ra.session5springboot.model.dto.request.CustomerRequest;
import ra.session5springboot.model.dto.response.CustomerResponse;
import ra.session5springboot.service.IGenericMapper;
@Component
public class CustomerMapper implements IGenericMapper<Customer, CustomerRequest, CustomerResponse> {
    @Override
    public Customer toEntity(CustomerRequest customerRequest) {
        return Customer.builder().fullName(customerRequest.getFullName())
                .sex(customerRequest.isSex())
                .age(customerRequest.getAge())
                .email(customerRequest.getEmail())
                .phoneNumber(customerRequest.getPhoneNumber()).build();
    }

    @Override
    public CustomerResponse toResponse(Customer customer) {
        return CustomerResponse.builder().id(customer.getId())
                .sex(customer.isSex())
                .age(customer.getAge())
                .email(customer.getEmail())
                .fullName(customer.getFullName())
                .phoneNumber(customer.getPhoneNumber()).build();
    }
}
