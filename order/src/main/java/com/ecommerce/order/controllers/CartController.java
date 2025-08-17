package com.ecommerce.order.controllers;


import com.ecommerce.order.dto.CartItemRequest;
import com.ecommerce.order.models.CartItem;
import com.ecommerce.order.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<String> addToCard(
            @RequestHeader("X-User-ID") String userId,
            @RequestBody CartItemRequest request){
        if(!cartService.addToCart(userId, request)){
            return ResponseEntity.badRequest().body("Not able to complete the request");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("items/{productId}")
    public ResponseEntity<Void> removeFromCart(
            @RequestHeader("X-User-ID") String userId,
            @PathVariable String productId){
        boolean delete = cartService.deleteItemFromCart(userId, productId);

        return delete ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<CartItem>> getAllUsers(@RequestHeader("X-User-ID") String userId){

        return ResponseEntity.ok(cartService.getCart(userId));
    }


}
