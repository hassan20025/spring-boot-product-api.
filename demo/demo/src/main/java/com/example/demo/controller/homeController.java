package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.product;
import com.example.demo.service.productService;

@RestController
@RequestMapping("api")
public class homeController {
    @Autowired
    public productService service;

    @GetMapping("products")
    public List<product> home(){
        return service.getAllProducts();
    }

    @PostMapping("product/{productId}")
    // used ResponseEntity to get status of https
    public ResponseEntity<product> getProduct(@PathVariable int productId){
        product pro = service.getProduct(productId);

        if(pro != null)
            return new ResponseEntity<>(pro,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }   

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart product product, @RequestPart MultipartFile imageFile) {
        product savedProduct = null;
        savedProduct = service.addNewProduct(product, imageFile);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);

    }

    @GetMapping("product/{productId}/image")
    public ResponseEntity<byte[]> getImageById(@PathVariable int productId){
        product pro = service.getProduct(productId);
        if(pro.getId() > 0 )
            return new ResponseEntity<>(pro.getImageData(),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id ,@RequestPart product product, @RequestPart MultipartFile imageFile) throws IOException{
        service.updateProduct(product, imageFile);
        return new ResponseEntity<>("update",HttpStatus.OK);
    }

    @DeleteMapping("product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        product productAvalible = service.getProduct(id);
        if(productAvalible != null){
            service.deleteProduct(id);
            return new ResponseEntity<>("okay",HttpStatus.OK);

        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}


