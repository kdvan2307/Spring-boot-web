package com.javaweb.api.admin;



import com.javaweb.model.dto.AssignmentCutomerDTO;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.response.TransactionResponse;
import com.javaweb.model.request.CustomerRequest;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.service.AssignmentCustomerService;
import com.javaweb.service.CustomerService;
import com.javaweb.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController(value = "customerAPIOfAdmin")
@RequestMapping("/api/customer")
@RequiredArgsConstructor
@Validated
public class CustomerAPI {

    private final CustomerService customerService;

    private final AssignmentCustomerService assignmentCustomerService;

    private final TransactionService transactionService;

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
    public void updateAssingmentCustomer(@RequestBody AssignmentCutomerDTO assignmentCutomerDTO) {
        assignmentCustomerService.addAssignmentCustomerEntity(assignmentCutomerDTO);

    }

    @PostMapping("/transaction")
    public ResponseEntity<TransactionDTO> addOrUpdateTransaction(@RequestBody TransactionDTO transactionDTO) {
        return ResponseEntity.ok(transactionService.addOrUpdateTransaction(transactionDTO));
    }

    @GetMapping("/transaction/{id}/detail")
    public ResponseDTO loadTransactionDetails(@PathVariable Long id){
        return transactionService.loadTransactionDetail(id);
    }
}
