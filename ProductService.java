package com.myapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.myapp.beans.Product;

public class ProductService {

	private List<Product> list;
	public ProductService() {
		list=new ArrayList<>();
		Product p1=new Product(1,"Thar","jeep",1500000);
		Product p2=new Product(2,"Breeza","car",500000);
		Product p3=new Product(3,"Creta","car",700000);
		Product p4=new Product(4,"Seltos","car",1000000);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
	}
	public List<Product> getList(){
		return list;
	}
	public List<Product> filterListBySearchQuery(String search){
		List<Product>list1 =new ArrayList<>();
		for(Product p:list) {
			if(p.getName().toLowerCase().contains(search.toLowerCase())) {
				list1.add(p);
			}
		}
		return list1;
	}
	public List<Product> filterListBySearchQueryStream(String search) {
		return list.stream()
				.filter(p->p.getName().toLowerCase().contains(search.toLowerCase()))
				.collect(Collectors.toList());
	}
	public Product fetchProductInfoStream(int id) {
		return list.stream()
				.filter(p->p.getId()==id)
				.collect(Collectors.toList())
				.get(0);
	}
	public Product fetchProductInfo(int id) {
		for (Product p : list) {
			if(p.getId()==id) {
				return p;
			}
		}
		return null;
	}
}
/**
 * list -> convert it into stream -> perform ops(filter) -> recovert to list
 * introduced in Java 1.8 - breakthru - lambda exps - streams
 * /
 */