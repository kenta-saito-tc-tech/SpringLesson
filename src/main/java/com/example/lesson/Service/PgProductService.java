package com.example.lesson.Service;

import com.example.lesson.Dao.ProductDao;
import com.example.lesson.Entity.ProductRecord;
import com.example.lesson.Exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PgProductService implements ProductService{
    @Autowired
    private ProductDao productDao;

    @Override
    public List<ProductRecord> findAll() {
        return productDao.findAll();
    }

    @Override
    public ProductRecord findById(int id) {
        if(productDao.findById(id) == null){
            throw new ProductNotFoundException();
        }
        return (productDao.findById(id));
    }

    @Override
    @Transactional
    public int insert(ProductRecord pr) {
        return productDao.insert(pr);
    }

    @Override
    public int update(ProductRecord pr) {
        return productDao.update(pr);
    }

    @Override
    public int delete(int id) {
        return productDao.delete(id);
    }
}
