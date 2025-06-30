package com.javaweb.controller.admin;




import com.javaweb.converter.CustomerConverter;
import com.javaweb.entity.CustomerEntity;

import com.javaweb.model.request.CustomerRequest;
import com.javaweb.model.request.CustomerSearchRequest;

import com.javaweb.model.response.CustomerResponse;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.service.CustomerService;
import com.javaweb.service.impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@Controller(value="customerControllerOfAdmin")
public class CustomerController {


    private final CustomerRepository customerRepository;

    private final CustomerService customerService;

    private final CustomerConverter customerConverter;

    @GetMapping(value="/admin/customer-list")
    public ModelAndView customerList(@ModelAttribute CustomerSearchRequest customerSearchRequest, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/customer/list");
        mav.addObject("modelSearchCustomer", customerSearchRequest);
        List<CustomerResponse> reponseList = customerService.getList();
        mav.addObject("customerList", reponseList);
        return mav;

    }
    @GetMapping(value="/admin/customer-edit")
    public ModelAndView buildingEdit(@ModelAttribute("customerEdit") CustomerRequest customerRequest, HttpServletRequest request) {
        return new ModelAndView("admin/customer/edit");

    }
    @RequestMapping(value="/admin/customer-edit-{id}",method = RequestMethod.GET)
    public ModelAndView buildingEdit(@PathVariable("id") Long Id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        // xuong DB tim theo id
        CustomerEntity customerEntity = customerRepository.findById(Id).get();
        CustomerResponse customerResponse = customerConverter.toResponse(customerEntity);
        mav.addObject("customerResponse", customerResponse);
        return mav;

    }

}
