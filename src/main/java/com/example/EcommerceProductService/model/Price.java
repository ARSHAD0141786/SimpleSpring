package com.example.EcommerceProductService.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Price extends BaseModel {
	double amount;
	String currency;
	int discount;
}
