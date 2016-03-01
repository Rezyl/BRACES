package usrm.model;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 6.11.14
 */
public enum Role {

	ROLE_ADMIN("Administrátor"), ROLE_JUDGE("Rozhodčí");

	private String displayName;

	Role(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static Map<String, String> getNamesToMap() {
		Map<String, String> result = new TreeMap<>();
		for (Role role : values()) {
			result.put(role.name(), role.getDisplayName());
		}
		return result;
	}
}
