package cz.uhk.braces.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class TourParticipant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tour_participant_id")
	private Long tourParticipantID;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "birth_date", nullable = false)
	private Date birthDate;
	
	//"Rodné číslo" ale v zahraničí může být jinak, nechal bych zvlášť jako String 
	@Column(name = "pin", nullable = false)
	private String PIN;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_fk", referencedColumnName = "address_id", nullable = true)
	private Address address;
	
	@Column(name = "phone_number", nullable = true)
	private String PhoneNumber;
	
	@Column(name = "email", nullable = true)
	private String email;

	public Long getTourParticipantID() {
		return tourParticipantID;
	}

	public void setTourParticipantID(Long tourParticipantID) {
		this.tourParticipantID = tourParticipantID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPIN() {
		return PIN;
	}

	public void setPIN(String pIN) {
		PIN = pIN;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
