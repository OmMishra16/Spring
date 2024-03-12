package com.example.Product.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Product.dto.FakeStoreProductDto;

@Service
public class ProductService {

    RestTemplate restTemplate = new RestTemplate();
    String url = "https://fakestoreapi.com";

    // ProductService(RestTemplate rs) {
    // restTemplate = rs;
    // }

    public FakeStoreProductDto[] getAllProducts() {
        FakeStoreProductDto response[] = restTemplate.getForObject(url + "/products/", FakeStoreProductDto[].class);
        return response;
    }

    public FakeStoreProductDto getProductbyId(Long id) {
        FakeStoreProductDto response = restTemplate.getForObject(url + "/products/" + id, FakeStoreProductDto.class);
        return response;
    }

    public FakeStoreProductDto[] getAllCategories() {
        FakeStoreProductDto response[] = restTemplate.getForObject(url + "products/categories",
                FakeStoreProductDto[].class);
        return response;
    }

    public FakeStoreProductDto getProductByCategory(String category) {
        FakeStoreProductDto response = restTemplate.getForObject(url + "products/category/" + category,
                FakeStoreProductDto.class);
        return response;
    }

}