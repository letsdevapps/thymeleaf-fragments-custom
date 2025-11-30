package com.pro.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "price")
	private Double price;

	@Column(name = "created_at")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate createdAt;

	@Column(name = "updated_at")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate updatedAt;

	@Column(name = "available")
	private Boolean available;
}