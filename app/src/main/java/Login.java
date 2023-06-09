public class Login {
    public boolean checkUserName(String username) {
        return username.matches(".{1,5}_.*");
    }

    public boolean checkPasswordComplexity(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$");
    }

    public String registerUser(String username, String password) {
        if (!checkUserName(username)) {
            return "Username is incorrectly formatted.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password does not meet complexity requirements.";
        }

        // Registration successful
        return "User registered successfully.";
    }

    public boolean loginUser(String enteredUsername, String enteredPassword, String storedUsername, String storedPassword) {
        return enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword);
    }

    public String returnLoginStatus(boolean loginSuccessful) {
        if (loginSuccessful) {
            return "Login successful.";
        } else {
            return "Login failed.";
        }
    }
}

