package com.example.lesson.Dao;

import com.example.lesson.Entity.ProductRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PgProductDao implements ProductDao{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Override
    public List<ProductRecord> findAll() {
        return jdbcTemplate.query("SELECT * FROM products ORDER BY id",
                new DataClassRowMapper<>(ProductRecord.class));
    }

    @Override
    public ProductRecord findById(int id) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);
        List<ProductRecord> list = jdbcTemplate.query("SELECT * FROM products WHERE id = :id",
                param, new DataClassRowMapper<>(ProductRecord.class));
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public int insert(ProductRecord pr) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("name", pr.name());
        param.addValue("price", pr.price());
        return jdbcTemplate.update("INSERT INTO products (name, price) VALUES(:name, :price)",param);
    }

    @Override
    public int update(ProductRecord pr) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", pr.id());
        param.addValue("name", pr.name());
        param.addValue("price", pr.price());
        return jdbcTemplate.update("UPDATE products SET name = :name, price = :price WHERE id = :id",param);
    }

    @Override
    public int delete(int id) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("id", id);
        return jdbcTemplate.update("DELETE FROM products WHERE id = :id", param);
    }
}
