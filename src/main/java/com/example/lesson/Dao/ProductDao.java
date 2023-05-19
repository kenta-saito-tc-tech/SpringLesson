package com.example.lesson.Dao;

import com.example.lesson.Entity.ProductRecord;

import java.util.List;

public interface ProductDao {
    public List<ProductRecord> findAll();
    public ProductRecord findById(int id);
    public int insert(ProductRecord pr);
    public int update(ProductRecord pr);
    public int delete(int id);
}
