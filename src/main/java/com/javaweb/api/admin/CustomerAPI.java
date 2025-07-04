package com.javaweb.api.admin;



import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.AssignmentCutomerDTO;
import com.javaweb.model.request.CustomerRequest;
import com.javaweb.model.response.CustomerResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.service.AssignmentCustomerService;
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

    private final AssignmentCustomerService assignmentCustomerService;

    @PostMapping
    public ResponseEntity<CustomerRequest> addOrUpdateCustomer(@RequestBody @Validated CustomerRequest customerRequest) {
        return ResponseEntity.ok(customerService.addOrUpdateCustomer(customerRequest));
    }

    @DeleteMapping("/{ids}")
    public void deleteCustomer (@PathVariable Long[] ids){
        customerService.removeCustomer(ids);
    }

    @GetMapping("/{id}/staffs")
    public ResponseDTO loadStaffs(@PathVariable Long id){
        ResponseDTO result = customerService.listStaffs(id);
        return result;
    }
    @PostMapping("/assignment")
    public void updateAssingmentBuilding(@RequestBody AssignmentCutomerDTO assignmentCutomerDTO) {
        assignmentCustomerService.addAssignmentCustomerEntity(assignmentCutomerDTO);

    }
}
