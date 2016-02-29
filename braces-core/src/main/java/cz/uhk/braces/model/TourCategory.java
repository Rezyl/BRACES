package cz.uhk.braces.model;

/**
 * User: Lukas Rezner
 * Date: 27.2.16
 */
public enum TourCategory {

	RELAX("Relaxační");

	private String displayName;

	TourCategory(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
