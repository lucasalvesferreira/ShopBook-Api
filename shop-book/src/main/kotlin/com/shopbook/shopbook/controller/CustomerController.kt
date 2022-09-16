package com.shopbook.shopbook.controller

import com.shopbook.shopbook.controller.request.PostCustumerRequest
import com.shopbook.shopbook.controller.request.PutCustumerRequest
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

        customerService.create(customer)
    }

    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        return customerService.getAll(name)
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel {
        return customerService.getCustomer(id)

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @RequestBody customer: PutCustumerRequest) {
        customerService.update(id, customer)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        customerService.delete(id)
    }

}





