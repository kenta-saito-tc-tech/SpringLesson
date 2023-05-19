package com.example.lesson.Entity;

public record ProductRecord(int id, String name, int price){
    public static ProductRecord productRecordNoId(String name, int id){
        return new ProductRecord(1000, name,id);
    }
}
