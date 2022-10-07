package com.shopbook.shopbook.controller

import com.shopbook.shopbook.controller.request.PostCustumerRequest
import com.shopbook.shopbook.controller.request.PutCustumerRequest
import com.shopbook.shopbook.extension.toCustomerModel
import com.shopbook.shopbook.model.CustomerModel
import com.shopbook.shopbook.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/customers")
class CustomerController(val customerService: CustomerService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustumerRequest) {

        customerService.create(customer.toCustomerModel())
    }

    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        return customerService.getAll(name)
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): CustomerModel {
        return customerService.findById(id)

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: PutCustumerRequest) {
        val customerSaved = customerService.findById(id)
        customerService.update(customer.toCustomerModel(customerSaved))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        customerService.delete(id)
    }

}





