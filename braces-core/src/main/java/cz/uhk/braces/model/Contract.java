package cz.uhk.braces.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.math.BigDecimal;

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
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime creationDate;
	
	//Zaplacena cast, napr zaloha
	@Column(name = "price_payed", nullable = false)
	private BigDecimal pricePayed;

	@Column
	private Boolean cancel;

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

	public Boolean getCancel() {
		return cancel;
	}

	public void setCancel(Boolean cancel) {
		this.cancel = cancel;
	}
}
