package com.atcs.olx.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Description;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(nullable = false)
	private String prod_name;
	
	@Column(nullable = false)
    private double prod_price;
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="product")
	private Location location;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Category category;
	
	@Column(nullable = false)
	private String description;
	
    @Column(nullable = false)
    private LocalDateTime created_date = LocalDateTime.now();
    
    @Column(nullable = false)
	private boolean bookmark=false;
    
    @OneToOne(fetch=FetchType.LAZY,mappedBy="product")
    private Contact contact;
	

	
   
}
