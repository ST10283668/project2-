import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testCheckUserName() {
        Login login = new Login();
        assertTrue(login.checkUserName("john_123"));
        assertFalse(login.checkUserName("abcde"));
    }

    @Test
    public void testCheckPasswordComplexity() {
        Login login = new Login();
        assertTrue(login.checkPasswordComplexity("Password@123"));
        assertFalse(login.checkPasswordComplexity("password123"));
    }

    @Test
    public void testRegisterUser() {
        Login login = new Login();
        assertEquals("User registered successfully.", login.registerUser("john_123", "Password@123"));
        assertEquals("Username is incorrectly formatted.", login.registerUser("abcde", "Password@123"));
        assertEquals("Password does not meet complexity requirements.", login.registerUser("john_123", "password123"));
    }

    @Test
    public void testLoginUser() {
        Login login = new Login();
        assertTrue(login.loginUser("john", "password", "john", "password"));
        assertFalse(login.loginUser("john", "password", "john", "wrongpassword"));
    }

    @Test
    public void testReturnLoginStatus() {
        Login login = new Login();
        assertEquals("Login successful.", login.returnLoginStatus(true));
        assertEquals("Login failed.", login.returnLoginStatus(false));
    }
}
