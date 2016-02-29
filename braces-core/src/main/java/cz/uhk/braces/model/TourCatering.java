package cz.uhk.braces.model;

/**
 * User: Lukas Rezner
 * Date: 27.2.16
 */
public enum TourCatering {
	FULL_BOARD("Plná penze"),
	HALF_BOARD("Polopenze"),
	WITHOUT("Bez jídla");

	private String displayName;

	TourCatering(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
