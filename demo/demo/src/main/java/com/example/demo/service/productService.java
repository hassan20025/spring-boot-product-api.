package com.example.demo.service;
import java.util.List;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.product;
import com.example.demo.repository.productRepo;

@Service
public class productService {
    @Autowired
    public productRepo repo;
    public List<product> getAllProducts(){
        return repo.findAll();
    }
   
    public product getProduct(int productId) {
       return repo.findById(productId).orElse(null);
    }

    public product addNewProduct(product product, MultipartFile imageFile) {
    try {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
    }catch(IOException e){
        e.printStackTrace();
    }

        return repo.save(product);

    }

    public product updateProduct(product product, MultipartFile imageFile) {
           try {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
    }catch(IOException e){
        e.printStackTrace();
    }

        return repo.save(product); 
    }

    public String  deleteProduct(int id) {
        repo.deleteById(id);
        return "it's work";
    }   
    
}
