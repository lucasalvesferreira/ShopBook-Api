package com.shopbook.shopbook.service

import com.shopbook.shopbook.controller.request.PostCustumerRequest
import com.shopbook.shopbook.controller.request.PutCustumerRequest
import com.shopbook.shopbook.model.CustomerModel
import org.springframework.stereotype.Service


@Service
class CustomerService {

    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter {
                it.nome.contains(name, true)
            }
        }
        return customers
    }

    fun create(customer: PostCustumerRequest) {

        val id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id.toInt() + 1
        }.toString()

        customers.add(CustomerModel(id, customer.nome, customer.email))
    }

    fun getCustomer(id: String): CustomerModel {
        return customers.filter { it.id == id }.first()

    }

    fun update(id: String, customer: PutCustumerRequest) {
        customers.filter { it.id == id }.first().let {
            it.nome = customer.nome
            it.email = customer.email

        }

    }

    fun delete(id: String) {
        customers.removeIf {
            it.id == id
        }

    }


}