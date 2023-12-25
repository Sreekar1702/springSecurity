package com.example.demoSecirity.entity;

import jakarta.persistence.*;

@Entity
@Table(name="seller")
public class Seller {

	// define fields


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name="spacename")
	private String spacename;
	
	@Column(name="dimensions")
	private String dimensions;
	
	@Column(name="location")
	private String location;

	@Column(name="price")
	private String price;

	@Column(name="duration")
	private String duration;

	@Column(name="status")
	private String status = "In BID";

	@Column(name="Mediastatus")
	private String mediastatus ="Approve Media Content";

	public String getMediastatus() {
		return mediastatus;
	}

	public void setMediastatus(String mediastatus) {
		this.mediastatus = mediastatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSpacename(String spacename) {
		this.spacename = spacename;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

// define constructors

	public String getSpacename() {
		return spacename;
	}

	public String getDimensions() {
		return dimensions;
	}

	public String getLocation() {
		return location;
	}

	public String getPrice() {
		return price;
	}

	public String getDuration() {
		return duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Seller() {
		
	}

	public Seller(String spacename, String dimensions, String location, String price, String duration) {
		this.spacename = spacename;
		this.dimensions = dimensions;
		this.location = location;
		this.price = price;
		this.duration = duration;
	}
}











