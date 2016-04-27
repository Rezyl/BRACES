package cz.uhk.braces.dto;

import cz.uhk.braces.model.Accomodation;
import cz.uhk.braces.model.Country;
import cz.uhk.braces.model.Tour;
import cz.uhk.braces.service.CRUDService;
import cz.uhk.braces.service.RegisterItemService;
import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * User: Lukas Rezner
 * Date: 26.4.16
 */
public class TourDTO {

	private Long tourID;

	private Long country;

	private String type;

	private String transportType;

	private String category;

	private String catering;

	private Long accommodation;

	private int tourLength;

	private DateTime dateFrom;

	private DateTime dateTo;

	private BigDecimal price;

	private String description;

	private String catalog;

	public TourDTO() {
	}

	public TourDTO(Tour tour) {
		this.tourID = tour.getTourID();
		this.country = tour.getCountry().getCountryID();
		this.type = tour.getType().getCode();
		this.transportType = tour.getTransportType().getCode();
		this.category = tour.getCategory().getCode();
		this.catering = tour.getCatering().getCode();
		this.accommodation = tour.getAccommodation().getAccomodationID();
		this.tourLength = tour.getTourLength();
		this.dateFrom = tour.getDateFrom();
		this.dateTo = tour.getDateTo();
		this.price = tour.getPrice();
		this.description = tour.getDescription();
		this.catalog = tour.getCatalog().toString();
	}

	public Tour transformToEntity(RegisterItemService registerItemService, CRUDService<Country> countryService, CRUDService<Accomodation> accommodationService) {
		Tour tour = new Tour();

		if (this.country != null) {
			tour.setCountry(countryService.getByID(this.country));
		}

		if (this.type != null) {
			tour.setType(registerItemService.getByRegisterItemCode(this.type));
		}

		if (this.transportType != null) {
			tour.setTransportType(registerItemService.getByRegisterItemCode(this.transportType));
		}

		if (this.category != null) {
			tour.setCategory(registerItemService.getByRegisterItemCode(this.category));
		}

		if (this.catering != null) {
			tour.setCatering(registerItemService.getByRegisterItemCode(this.catering));
		}

		if (this.accommodation != null) {
			tour.setAccommodation(accommodationService.getByID(this.accommodation));
		}

		tour.setCatalog(Boolean.valueOf(catalog));

		tour.setTourID(this.tourID);
		tour.setTourLength(this.tourLength);
		tour.setDateFrom(this.dateFrom);
		tour.setDateTo(this.dateTo);
		tour.setPrice(this.price);
		tour.setDescription(this.description);

		return tour;
	}

	public Long getTourID() {
		return tourID;
	}

	public void setTourID(Long tourID) {
		this.tourID = tourID;
	}

	public Long getCountry() {
		return country;
	}

	public void setCountry(Long country) {
		this.country = country;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTransportType() {
		return transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCatering() {
		return catering;
	}

	public void setCatering(String catering) {
		this.catering = catering;
	}

	public Long getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(Long accommodation) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
}
