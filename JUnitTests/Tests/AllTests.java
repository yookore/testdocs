import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ FriendsTasksTest.class, NativeTasksTest.class,
		PostContentTest.class, ProfileManagerTest.class, SocialTasksTest.class,
		VerificationTest.class })
public class AllTests {

}
