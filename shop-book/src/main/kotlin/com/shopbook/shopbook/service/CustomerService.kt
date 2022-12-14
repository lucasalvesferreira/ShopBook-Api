package com.shopbook.shopbook.service

import com.shopbook.shopbook.enums.CustumerStatus
import com.shopbook.shopbook.model.CustomerModel
import com.shopbook.shopbook.repository.CustomerRepository
import org.springframework.stereotype.Service


@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val bookService: BookService
) {

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContainingIgnoreCase(it)
        }
        return customerRepository.findAll().toList()
    }

    fun create(customer: CustomerModel) {

        customerRepository.save(customer)
    }

    fun findById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow()

    }

    fun update(customer: CustomerModel) {
        if (customerRepository.existsById(customer.id!!)) {
            throw Exception()
        }

        customerRepository.save(customer)

    }

    fun delete(id: Int) {
        val customer = findById(id)
        bookService.deleteByCustomer(customer)

        customer.status = CustumerStatus.INATIVO

        customerRepository.save(customer)

    }


}