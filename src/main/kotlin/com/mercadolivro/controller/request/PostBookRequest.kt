package com.mercadolivro.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class PostBookRequest (
    var name: String,
    var price: BigDecimal,

    @JsonAlias
    var customer_id : Int
)
