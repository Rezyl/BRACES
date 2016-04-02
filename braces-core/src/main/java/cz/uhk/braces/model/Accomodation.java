package cz.uhk.braces.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import cz.uhk.braces.model.register.RegisterItem;

@Entity
@Table
public class Accomodation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "accomodation_id")
	private Long accomodationID;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type", referencedColumnName = "code", nullable = false)
	private RegisterItem accomodationType;
	
	@Column
	private String name;
		
	

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "accomodation_optional_services", joinColumns = { 
			@JoinColumn(name = "accomodation_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "id", 
					nullable = false, updatable = false) })
	private List<RegisterItem> optionalServices;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_fk", referencedColumnName = "address_id", nullable = false)
	private Address address;
	
	@Column
	private BigDecimal price;
	
	@Column
	private int capacity;
	
	@Min(1)
	@Max(5)
	@Column
	private int rating;
	
	public Long getAccomodationID() {
		return accomodationID;
	}

	public void setAccomodationID(Long accomodationID) {
		this.accomodationID = accomodationID;
	}

	public RegisterItem getAccomodationType() {
		return accomodationType;
	}

	public void setAccomodationType(RegisterItem accomodationType) {
		this.accomodationType = accomodationType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RegisterItem> getOptionalServices() {
		return optionalServices;
	}

	public void setOptionalServices(List<RegisterItem> optionalServices) {
		this.optionalServices = optionalServices;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
