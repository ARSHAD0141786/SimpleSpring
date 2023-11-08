package com.example.EcommerceProductService.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name="ECOMM_USER")
@Getter
@Setter
public class User extends BaseModel {
	String name;
	
}
