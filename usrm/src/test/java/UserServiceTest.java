import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import usrm.model.User;
import usrm.service.api.UserService;

/**
 * Created with IntelliJ IDEA.
 * User: rezy
 * Date: 5.11.13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:usrm-test-context.xml"})
@Transactional
public class UserServiceTest {

	private static final String TEST_USER = "test_user";
	private static final String EDITED_TEST_USER = "test_user_edited";
	private static final String PASSWORD = "password";

	@Autowired
	private UserService userService;

	@Test
	public void createUserTest() {
		User testUser = createTestUser();
		userService.save(testUser);

		User user = userService.getByID(testUser.getUserID());
		Assert.assertNotNull(user);
		Assert.assertEquals(TEST_USER, user.getLogin());
	}

	@Test
	public void editUserTest() {
		User newUser = createTestUser();
		userService.save(newUser);

		User loadedUser = userService.getByID(newUser.getUserID());
		loadedUser.setLogin(EDITED_TEST_USER);
		userService.edit(loadedUser);

		User user = userService.getByID(newUser.getUserID());

		Assert.assertNotNull(user);
		Assert.assertEquals(EDITED_TEST_USER, user.getLogin());
	}

	@Test
	public void deleteUserTest() {
		User newUser = createTestUser();
		userService.save(newUser);

		User loadedUser = userService.getByID(newUser.getUserID());
		Assert.assertNotNull(loadedUser);

		userService.delete(loadedUser.getUserID());
		User user = userService.getByID(loadedUser.getUserID());

		Assert.assertNull(user);
	}

	private User createTestUser() {
		User testUser = new User();
		testUser.setLogin(TEST_USER);
		testUser.setPassword(PASSWORD);
		return testUser;
	}
}
