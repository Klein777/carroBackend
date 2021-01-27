package com.tul.carrito

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Products(
    @Id var id: Long,
    var nombre: String,
    var sku: String,
    var descripcion: String
)

@Entity
class ProductCarts(
    var quantity: Int,
    var product_id: Long,
    @Id var id: Long,
    var cart_id: Long
)

@Entity
class CrudProductCarts(
    var nombre: String,
    var sku: String,
    var descripcion: String,
    var status: String,
    var quantity: Int,
    var product_id: Long,
    @Id var id: Long,
    var cart_id: Long
)


@Entity
class Carts(
    @Id var id: Long,
    var status: String
)