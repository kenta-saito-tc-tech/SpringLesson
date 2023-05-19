package com.example.lesson.Service;

import com.example.lesson.Entity.ProductRecord;

import java.util.List;

public interface ProductService {
    public List<ProductRecord> findAll();
    public ProductRecord findById(int id);
    public int insert(ProductRecord pr);
    public int update(ProductRecord pr);
    public int delete(int id);
}
