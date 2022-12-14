package com.shopbook.shopbook.extension;

import com.shopbook.shopbook.controller.request.PostBookRequest
import com.shopbook.shopbook.controller.request.PostCustumerRequest
import com.shopbook.shopbook.controller.request.PutBookRequest
import com.shopbook.shopbook.controller.request.PutCustumerRequest
import com.shopbook.shopbook.enums.BookStatus
import com.shopbook.shopbook.enums.CustumerStatus
import com.shopbook.shopbook.model.BookModel
import com.shopbook.shopbook.model.CustomerModel

fun PostCustumerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel( name= this.nome,email= this.email, status = CustumerStatus.ATIVO)
}
fun PutCustumerRequest.toCustomerModel(previusValues: CustomerModel): CustomerModel {
    return CustomerModel( id= previusValues.id, name= this.nome,email= this.email, status = previusValues.status)
}
fun PostBookRequest.toBookModel(customer : CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}

    fun PutBookRequest.toBookModel(previusValues : BookModel): BookModel{
    return BookModel(
        id = previusValues.id,
        name = this.name ?: previusValues.name,
        price = this.price ?: previusValues.price,
        status = previusValues.status,
        customer = previusValues.customer
    )

}