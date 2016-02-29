package cz.uhk.braces.model;

/**
 * User: Lukas Rezner
 * Date: 27.2.16
 */
public enum TransportType {

	PLANE("Letadlo"),
	BUS("Autobus"),
	OWN("Vlastní");

	private String displayName;

	TransportType(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
