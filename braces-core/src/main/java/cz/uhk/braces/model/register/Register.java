package cz.uhk.braces.model.register;

/**
 * User: Lukas Rezner
 * Date: 20.3.16
 */
public enum Register {

	TOUR_TYPE,
	TRANSPORT_TYPE,
	TOUR_CATEGORY,
	TOUR_CATERING,
	TOUR_ACCOMMODATION,
	OPTIONAL_SERVICE;

	public static Register getByCode(String code) {
		for (Register register : values()) {
			if (register.name().equals(code)) {
				return register;
			}
		}
		return null;
	}

}
