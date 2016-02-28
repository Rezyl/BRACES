package cz.uhk.braces.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * User: Lukas Rezner
 * Date: 20.2.16
 */
@Entity
@Table
public class Tour {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tour_id")
	private Long tourID;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "country_fk", referencedColumnName = "country_id", nullable = false)
	private Country country;

	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private TransportType transportType;

	@Column(name = "category")
	@Enumerated(EnumType.STRING)
	private TourCategory category;

	@Column(name = "catering")
	@Enumerated(EnumType.STRING)
	private TourCatering catering;

	@Column(name = "accommodation")
	@Enumerated(EnumType.STRING)
	private TourAccommodation accommodation;

	@Column(name = "length")
	private int tourLength;

	@Column(name = "date")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime date;

	@Column
	private BigDecimal price;

	public Long getTourID() {
		return tourID;
	}

	public void setTourID(Long tourID) {
		this.tourID = tourID;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public TransportType getTransportType() {
		return transportType;
	}

	public void setTransportType(TransportType transportType) {
		this.transportType = transportType;
	}

	public TourCategory getCategory() {
		return category;
	}

	public void setCategory(TourCategory category) {
		this.category = category;
	}

	public TourCatering getCatering() {
		return catering;
	}

	public void setCatering(TourCatering catering) {
		this.catering = catering;
	}

	public TourAccommodation getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(TourAccommodation accommodation) {
		this.accommodation = accommodation;
	}

	public int getTourLength() {
		return tourLength;
	}

	public void setTourLength(int tourLength) {
		this.tourLength = tourLength;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Tour{" +
				"tourID=" + tourID +
				", country=" + country +
				", transportType=" + transportType +
				", category=" + category +
				", catering=" + catering +
				", accommodation=" + accommodation +
				", tourLength=" + tourLength +
				", date=" + date +
				", price=" + price +
				'}';
	}
}
