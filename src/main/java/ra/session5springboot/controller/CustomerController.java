package ra.session5springboot.controller;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.session5springboot.model.dto.request.CustomerRequest;
import ra.session5springboot.model.dto.response.CustomerResponse;
import ra.session5springboot.service.ICustomerService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v2/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll(){
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CustomerResponse> create(@RequestBody @Valid CustomerRequest customerRequest) throws UserException {
        return new ResponseEntity<>(customerService.save(customerRequest), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@RequestBody @Valid CustomerRequest customerRequest, @PathVariable Long id){
        return new ResponseEntity<>(customerService.update(customerRequest,id), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerResponse> deleteById(@PathVariable Long id ){
        return  new ResponseEntity<>(customerService.delete(id),HttpStatus.OK);
    }
}
