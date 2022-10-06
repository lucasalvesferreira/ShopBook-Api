package com.shopbook.shopbook.controller

import com.shopbook.shopbook.controller.request.PostBookRequest
import com.shopbook.shopbook.controller.request.PutBookRequest
import com.shopbook.shopbook.extension.toBookModel
import com.shopbook.shopbook.model.BookModel
import com.shopbook.shopbook.service.BookService
import com.shopbook.shopbook.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/book")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService

){

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun created(@RequestBody request: PostBookRequest){
        val customer = customerService.getById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }

    @GetMapping
    fun findAll(): List<BookModel> {
      return bookService.findAll();
    }

    @GetMapping("/active")
    fun findActives(): List<BookModel> =
        bookService.findActives();

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookModel{
        return bookService.findById(id)
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int){
        bookService.delete(id)

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int , @RequestBody book: PutBookRequest){
        val booSaved = bookService.findById(id)
        bookService.update(book.toBookModel(booSaved))

    }

}