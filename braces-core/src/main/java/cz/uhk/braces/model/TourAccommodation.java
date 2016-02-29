package cz.uhk.braces.model;

/**
 * User: Lukas Rezner
 * Date: 27.2.16
 */
public enum TourAccommodation {

	APARTMENT("Apartmán"),
	HOTEL("Hotel"),
	CAMP("Tábor");

	private String displayName;

	TourAccommodation(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
