package com.example.lesson;

import com.example.lesson.Entity.ProductRecord;
import com.example.lesson.Service.PgProductService;
import com.example.lesson.Service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LessonApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context =
				SpringApplication.run(LessonApplication.class, args);

		ProductService productService = context.getBean(PgProductService.class);
		//全件表示
		productService.findAll().stream().forEach(System.out::println);
		line();
		//ID検索
		System.out.println(productService.findById(7));
		line();
		//追加
		System.out.println(productService.insert(ProductRecord.productRecordNoId("お菓子", 100)));
		productService.findAll().stream().forEach(System.out::println);
		line();
		//更新
		System.out.println(productService.update(new ProductRecord(10, "高級なお菓子", 2500)));
		productService.findAll().stream().forEach(System.out::println);
		line();
		//削除
		System.out.println(productService.delete(4));
		productService.findAll().stream().forEach(System.out::println);
		line();
	}

	public static void line(){
		System.out.println("----------------------------------------------");
	}



}
