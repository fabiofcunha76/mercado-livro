package com.mercadolivro.service

import com.mercadolivro.model.CustomerModel
import com.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService ( val customerRepository: CustomerRepository) {

    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        //return CustomerModel("1","Fabio Cunha","fabio.cunha@spdm.org.br")
        name?.let {
            return customers.filter { it.name.contains(name,true) }
        }
        return customers
    }

    fun create(customer: CustomerModel) {

        customerRepository.save(customer)
/*        val id = if(customers.isEmpty()){
            1
        } else{
            customers.last().id!!.toInt() + 1
        }

        customer.id = id*/
        //customers.add(customer)
    }

    fun getCustomer(id:Int): CustomerModel {
        return customers.filter { it.id!!.equals(id) }.first()
    }

    fun update(customer: CustomerModel){
        customers.filter { it.id!!.equals(customer.id)}.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun delete(id: Int){
        customers.removeIf { it.id == id }
    }

}