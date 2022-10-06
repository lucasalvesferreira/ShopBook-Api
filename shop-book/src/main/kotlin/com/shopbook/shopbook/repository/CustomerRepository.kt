package com.shopbook.shopbook.repository

import com.shopbook.shopbook.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<CustomerModel,Int>{

    fun findByNameContainingIgnoreCase(name: String): List<CustomerModel>


}