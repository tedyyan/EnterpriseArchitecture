package lab4.prob2.domain.sub2;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import lombok.Data;

//@Data
@Entity(name="sub2Book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	String name;
	
	String author;
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable( name="book_publisher", 
			joinColumns= { @JoinColumn(name = "book_id") },
			inverseJoinColumns= { @JoinColumn(name = "publisher_id") })
	Publisher publisher;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
		
	}

	public Book(String name, String author ){
		this.name = name;
		this.author = author;
	}
	
	
}
