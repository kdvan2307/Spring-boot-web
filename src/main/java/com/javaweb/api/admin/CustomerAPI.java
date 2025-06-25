package com.javaweb.api.admin;



import com.javaweb.model.request.CustomerRequest;
import com.javaweb.model.response.CustomerResponse;
import com.javaweb.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "customerAPIOfAdmin")
@RequestMapping("/api/customer")
@RequiredArgsConstructor
@Validated
public class CustomerAPI {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerResponse> getCustomer() {
        return customerService.getList();
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> addOrUpdateCustomer(@RequestBody @Validated CustomerRequest customerRequest) {
        return ResponseEntity.ok(customerService.addOrUpdateCustomer(customerRequest));
    }

    @DeleteMapping("/{ids}")
    public void deleteCustomer (@PathVariable Long[] ids){
        customerService.removeCustomer(ids);
    }
}
