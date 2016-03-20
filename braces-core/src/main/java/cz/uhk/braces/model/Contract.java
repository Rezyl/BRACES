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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table
public class Contract {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contract_id")
	private Long contractID;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "contact_participant", referencedColumnName = "tour_participant_id", nullable = false)
	private TourParticipant contactParticipant;
	
//	private List<TourParticipant> participants;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tour", referencedColumnName = "tour_id", nullable = false)
	private Tour tour;
	
	@Column(name = "creation_date", nullable = false)
	private DateTime creationDate;
	
	//Zaplacena cast, napr zaloha
	@Column(name = "price_payed", nullable = false)
	private BigDecimal pricePayed;

	public Long getContractID() {
		return contractID;
	}

	public void setContractID(Long contractID) {
		this.contractID = contractID;
	}

	public TourParticipant getContactParticipant() {
		return contactParticipant;
	}

	public void setContactParticipant(TourParticipant contactParticipant) {
		this.contactParticipant = contactParticipant;
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	public DateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(DateTime creationDate) {
		this.creationDate = creationDate;
	}

	public BigDecimal getPricePayed() {
		return pricePayed;
	}

	public void setPricePayed(BigDecimal pricePayed) {
		this.pricePayed = pricePayed;
	}


}
