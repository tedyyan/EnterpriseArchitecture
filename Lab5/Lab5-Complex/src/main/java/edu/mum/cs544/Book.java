package edu.mum.cs544;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
@DiscriminatorValue("book")
public class Book extends Product{
	private String title;
}
