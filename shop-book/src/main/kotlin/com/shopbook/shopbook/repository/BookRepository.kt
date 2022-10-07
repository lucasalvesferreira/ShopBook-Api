package com.shopbook.shopbook.repository

import com.shopbook.shopbook.enums.BookStatus
import com.shopbook.shopbook.model.BookModel
import com.shopbook.shopbook.model.CustomerModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel,Int>{

    fun findByStatus(status: BookStatus): List<BookModel>
    fun findByCustomer(customer :CustomerModel): List<BookModel>


}