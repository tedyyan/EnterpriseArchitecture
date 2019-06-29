package edu.mum.cs544;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="product_type",
	discriminatorType=DiscriminatorType.STRING)
public class Product {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	Long id;

	private String name;
	private String description;
}
