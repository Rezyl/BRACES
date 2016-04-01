package cz.uhk.braces.model;

import cz.uhk.braces.model.register.RegisterItem;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type", referencedColumnName = "code", nullable = false)
	private RegisterItem type;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "transport", referencedColumnName = "code", nullable = false)
	private RegisterItem transportType;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category", referencedColumnName = "code", nullable = false)
	private RegisterItem category;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "catering", referencedColumnName = "code", nullable = false)
	private RegisterItem catering;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "accommodation", referencedColumnName = "accomodation_id", nullable = false)
	private Accomodation accommodation;

	@Column(name = "length")
	private int tourLength;

	@Column(name = "date_from")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dateFrom;

	@Column(name = "date_to")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dateTo;

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

	public RegisterItem getType() {
		return type;
	}

	public void setType(RegisterItem type) {
		this.type = type;
	}

	public RegisterItem getTransportType() {
		return transportType;
	}

	public void setTransportType(RegisterItem transportType) {
		this.transportType = transportType;
	}

	public RegisterItem getCategory() {
		return category;
	}

	public void setCategory(RegisterItem category) {
		this.category = category;
	}

	public RegisterItem getCatering() {
		return catering;
	}

	public void setCatering(RegisterItem catering) {
		this.catering = catering;
	}

	public Accomodation getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(Accomodation accommodation) {
		this.accommodation = accommodation;
	}

	public int getTourLength() {
		return tourLength;
	}

	public void setTourLength(int tourLength) {
		this.tourLength = tourLength;
	}

	public DateTime getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(DateTime dateFrom) {
		this.dateFrom = dateFrom;
	}

	public DateTime getDateTo() {
		return dateTo;
	}

	public void setDateTo(DateTime dateTo) {
		this.dateTo = dateTo;
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
				", type=" + type +
				", transportType=" + transportType +
				", category=" + category +
				", catering=" + catering +
				", accommodation=" + accommodation +
				", tourLength=" + tourLength +
				", dateFrom=" + dateFrom +
				", dateTo=" + dateTo +
				", price=" + price +
				'}';
	}
}
