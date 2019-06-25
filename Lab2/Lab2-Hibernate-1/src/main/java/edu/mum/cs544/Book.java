package edu.mum.cs544;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Book {
	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private String ISBN;
	private String author;
	private double price;
	private java.util.Date publish_date;
	
	public Book(String title,String ISBN,String author,double price,java.util.Date publish_date){
		this.title = title;
		this.ISBN = ISBN;
		this.author = author;
		this.price = price;
		this.publish_date = publish_date;
	}
	
	@Override
	public String toString() {
		
		return "title= " + this.title + ", author= " 
                + this.getAuthor() + ", ISBN= " + this.getISBN() + ", price= "
                + this.getPrice() + ", publish_date= " + this.getPublish_date();
		
	}
}

