package com.mercadolivro.controller

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy
import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("customers")
class CustomerController {

    val customers = mutableListOf<CustomerModel>()

    @GetMapping()
    fun getCustomer(): MutableList<CustomerModel> {
        //return CustomerModel("1","Fabio Cunha","fabio.cunha@spdm.org.br")
        return customers
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer : PostCustomerRequest) {

        val id = if(customers.isEmpty()){
            1
        } else{
            customers.last().id.toInt() + 1
        }.toString()

        customers.add(CustomerModel(id,customer.name,customer.email))
    }

}