package com.example.demo.controller;

import com.example.demo.model.dto.response.ApiDataResponse;
import com.example.demo.model.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping
    public ResponseEntity<ApiDataResponse<List<Customer>>> getAllCustomers() {
       return new ResponseEntity<>(new ApiDataResponse<>(
               true,
               "lấy dữ liệu thành công",
               customerService.getAllCustomers(),
               HttpStatus.OK
       ),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ApiDataResponse<Customer>> insertCustomer(@RequestBody Customer customer) {
       return new ResponseEntity<>(new ApiDataResponse<>(
               true,
               "thêm dữ liệu thành công",
               customerService.insertCustomer(customer),
               HttpStatus.CREATED
       ),HttpStatus.CREATED);
    }
    @PutMapping("/{cusId}")
    public ResponseEntity<ApiDataResponse<Customer>> updateCustomer(@PathVariable Long cusId,@RequestBody Customer customer) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "cập nhật dữ liệu thành công",
                customerService.updateCustomer(cusId,customer),
                HttpStatus.OK
        ),HttpStatus.OK);
    }
    @GetMapping("/{cusId}")
    public ResponseEntity<ApiDataResponse<Customer>> getCustomerById(@PathVariable Long cusId) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "lấy dữ liệu với id : " + cusId + " thành công",
                customerService.getCustomerById(cusId),
                HttpStatus.OK
        ), HttpStatus.OK);
    }
    @DeleteMapping("/{cusId}")
    public ResponseEntity<ApiDataResponse<Boolean>> deleteCustomer(@PathVariable Long cusId) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "xóa dữ liệu với id : "+cusId+" thành công",
                customerService.deleteCustomer(cusId),
                HttpStatus.NO_CONTENT
        ),HttpStatus.NO_CONTENT);
    }
    @GetMapping("/name/{cusName}")
    public ResponseEntity<ApiDataResponse<List<Customer>>> getCustomersByName(@PathVariable String cusName) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "lấy dữ liệu với tên : " + cusName + " thành công",
                customerService.getCustomersByName(cusName),
                HttpStatus.OK
        ), HttpStatus.OK);
    }
}
