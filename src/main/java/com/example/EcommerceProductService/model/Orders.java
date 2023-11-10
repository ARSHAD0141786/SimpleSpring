package com.example.EcommerceProductService.model;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.CurrentTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ecomm_orders")
public class Orders extends BaseModel {
	@CurrentTimestamp
	Date timestamp;
	
	@ManyToMany
	List<Product> products;
}
