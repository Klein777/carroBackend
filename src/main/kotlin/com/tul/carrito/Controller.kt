package com.tul.carrito

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException

@CrossOrigin
@RestController
class ProductController(val repo : ProductRepositories){

    @PostMapping("/product")
    fun addProducts(@RequestBody product : Products) = repo.save(product)

    @GetMapping("/product")
    fun read() : List<Products> = repo.findAll().toList()

}

@CrossOrigin
@RestController
class ProductCartController(val repo : ProductCartRepositories, val repo2 : CrudProductCartRepositories){

    @GetMapping("/carritodetalles")
    fun read() : List<CrudProductCarts> = repo2.getDataProductCarts().toList()

    @PostMapping("/carritodetalles")
    fun addProductsToCart(@RequestBody product : ProductCarts) = repo.save(product)

    @PutMapping("/carritodetalles/{id}")
    fun update(@PathVariable id: Long, @RequestBody product: ProductCarts): ResponseEntity<ProductCarts>{
        val saved = repo.save(product)
        return ResponseEntity.ok(saved)
    }

    @DeleteMapping("/carritodetalles/{id}")
    fun delete(@PathVariable id: Long) = repo.deleteById(id)

}

@CrossOrigin
@RestController
class CartController(val repo : CartRepositories){

    @PutMapping("/updatecard/{id}")
    fun update(@PathVariable id: Long, @RequestBody cart: Carts): ResponseEntity<Carts>{
        val saved = repo.save(cart)
        return ResponseEntity.ok(saved)
    }

}