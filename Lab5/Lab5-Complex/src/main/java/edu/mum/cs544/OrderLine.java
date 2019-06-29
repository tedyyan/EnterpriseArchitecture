package edu.mum.cs544;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class OrderLine {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private Integer quantity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Product product;
	
}
