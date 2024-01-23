package com.mercadolivro.service

import com.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.model.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomerService {

    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        //return CustomerModel("1","Fabio Cunha","fabio.cunha@spdm.org.br")
        name?.let {
            return customers.filter { it.name.contains(name,true) }
        }
        return customers
    }

    fun create(customer: CustomerModel) {

        val id = if(customers.isEmpty()){
            1
        } else{
            customers.last().id.toInt() + 1
        }.toString()

        customers.add(CustomerModel(id,customer.name,customer.email))
    }

    fun getCustomer(id:String): CustomerModel {
        return customers.filter { it.id.equals(id) }.first()
    }

    fun update(id: String, customer: PutCustomerRequest){
        customers.filter { it.id.equals(id)}.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun delete(id: String){
        customers.removeIf { it.id == id }
    }

}