package com.tul.carrito

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository


interface ProductRepositories : CrudRepository<Products, Long>

interface ProductCartRepositories : CrudRepository<ProductCarts, Long>

interface CrudProductCartRepositories : CrudRepository<CrudProductCarts, Long>{

    @Query("SELECT p.nombre, p.sku, p.descripcion, c.status," +
            " product_carts.quantity, product_carts.product_id, product_carts.id, product_carts.cart_id FROM product_carts" +
            " INNER JOIN products as p ON p.id = product_carts.product_id INNER JOIN carts as c" +
            " ON c.id = product_carts.cart_id",
        nativeQuery = true)
    fun getDataProductCarts() : List<CrudProductCarts>
}

interface CartRepositories : CrudRepository<Carts, Long>