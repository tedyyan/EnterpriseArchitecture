package edu.mum.cs544;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;

import lombok.Data;

@Entity
@Data	
@SecondaryTables(
	@SecondaryTable(name="Address", pkJoinColumns= {
		@PrimaryKeyJoinColumn(name="patient_id", referencedColumnName="id")
	})
)
public class Patient {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String name;
	@Column(table="Address")
	private String street;
	@Column(table="Address")
	private String zip;
	@Column(table="Address")
	private String city;

}
