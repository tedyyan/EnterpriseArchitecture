package edu.mum.cs544;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="order1")
public class Order {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String orderID;

	private Date date;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<OrderLine> orderLines = new ArrayList<OrderLine>();
	
	public void addOrderLine(OrderLine orderLine) {
		orderLines.add(orderLine);
	}
}
