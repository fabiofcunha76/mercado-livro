package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.extension.toBookModel
import com.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
class BookController(
    val bookService: CustomerService,
    val customerServices : CustomerService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request : PostBookRequest){
        val customer = customerServices.getById(request.customerId)
        bookService.create(request.toBookModel(customer)) //algum bug que não está salvando as informações do livro
    }



}
