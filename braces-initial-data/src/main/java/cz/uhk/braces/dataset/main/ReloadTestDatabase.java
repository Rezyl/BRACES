package cz.uhk.braces.dataset.main;

/**
 * User: Lukas Rezner
 * Date: 21.3.16
 */
public class ReloadTestDatabase {

	public static void main(String[] args) {
		ClearDatabaseDataset.main(args);
		CreateTestDataset.main(args);
	}
}
