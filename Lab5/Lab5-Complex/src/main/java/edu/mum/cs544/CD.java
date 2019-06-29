package edu.mum.cs544;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
@DiscriminatorValue("CD")
public class CD  extends Product{
	private String artist;
}
