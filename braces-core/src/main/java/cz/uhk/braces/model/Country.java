package cz.uhk.braces.model;

import javax.persistence.*;

/**
 * User: Lukas Rezner
 * Date: 27.2.16
 */
@Entity
@Table
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "country_id")
	private Long countryID;

	@Column(name = "code")
	private String countryCode;

	@Column(name = "name")
	private String countryName;

	public Long getCountryID() {
		return countryID;
	}

	public void setCountryID(Long countryID) {
		this.countryID = countryID;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "Country{" +
				"countryID=" + countryID +
				", countryCode='" + countryCode + '\'' +
				", countryName='" + countryName + '\'' +
				'}';
	}
}
