import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class FrontEnd {
    public static void main(String[] args) {
        String firstName = JOptionPane.showInputDialog("Enter your first name:");//(Jdevelop & Taras Lazarenko, 1958)
        String lastName = JOptionPane.showInputDialog("Enter your last name:");
        String username = "";
        String password = "";

        while (true) {
            username = JOptionPane.showInputDialog("Enter your username:");//(Jdevelop & Taras Lazarenko, 1958)

            if (isUsernameValid(username)) {
                JOptionPane.showMessageDialog(null, "Username successfully captured.");//(trashgod and matoni, 1963)
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");//(trashgod and matoni, 1963)
            }
        }

        while (true) {
            password = JOptionPane.showInputDialog("Enter your password:");//(Jdevelop & Taras Lazarenko, 1958)

            if (isPasswordValid(password)) {
                JOptionPane.showMessageDialog(null, "Password successfully captured."); //(trashgod and matoni, 1963)
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that your password meets the complexity requirements.");//(trashgod and matoni, 1963)
            }
        }

        String welcomeMessage = "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        JOptionPane.showMessageDialog(null, welcomeMessage);

        String reenteredUsername = "";
        String reenteredPassword = "";

        while (true) {
            reenteredUsername = JOptionPane.showInputDialog("Enter your username for login:");//(Jdevelop & Taras Lazarenko, 1958)
            reenteredPassword = JOptionPane.showInputDialog("Enter your password for login:");

            if (reenteredUsername.equals(username) && reenteredPassword.equals(password)) {
                JOptionPane.showMessageDialog(null, "Login successful.");//(trashgod and matoni, 1963)
                JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!");//(trashgod and matoni, 1963)
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Username or password incorrect. Please try again.");
            }
        }

        while (true) {
            String[] options = {"Add Task", "Show Report", "Quit"};
            int choice = JOptionPane.showOptionDialog(null, "Select an option:", "EasyKanban Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);//(Anto & Sean, 1957)

            if (choice == 0) {
                // Add Task option
                int taskCount = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));//(Jdevelop & Taras Lazarenko, 1958)
                int totalHours = 0;

                // Displaying task details for each task
                for (int i = 0; i < taskCount; i++) {
                    String taskName = JOptionPane.showInputDialog("Enter the task name:");//(Jdevelop & Taras Lazarenko, 1958)
                    String taskDescription = "";

                    while (true) {
                        taskDescription = JOptionPane.showInputDialog("Enter the task description (up to 50 characters):");

                        if (taskDescription.length() <= 50) {
                            break; // Task description is valid, exit the loop
                        } else {
                            JOptionPane.showMessageDialog(null, "Task description exceeds the maximum length of 50 characters. Please try again.");//(trashgod and matoni, 1963)
                        }
                    }

                    String developerFirstName = JOptionPane.showInputDialog("Enter the developer's first name:");//(Jdevelop & Taras Lazarenko, 1958)
                    String developerLastName = JOptionPane.showInputDialog("Enter the developer's last name:");
                    int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter the task duration in hours:"));

                    String taskID = generateTaskID(taskName, i, developerLastName);

                    String[] taskStatusOptions = {"To Do", "Done", "Doing"};
                    JComboBox<String> taskStatusComboBox = new JComboBox<>(taskStatusOptions);
                    JOptionPane.showMessageDialog(null, taskStatusComboBox, "Select the task status:", JOptionPane.QUESTION_MESSAGE);
                    String taskStatus = (String) taskStatusComboBox.getSelectedItem();//(Simon Mills et al., 1962)

                    String developerDetails = developerFirstName + " " + developerLastName;//(Jdevelop & Taras Lazarenko, 1958)
                    String taskNumber = "Task Number: " + (i + 1);

                    String taskDetails = "Task Status: " + taskStatus + "\n" +
                            "Developer Details: " + developerDetails + "\n" +
                            taskNumber + "\n" +
                            "Task Name: " + taskName + "\n" +
                            "Task Description: " + taskDescription + "\n" +
                            "Task ID: " + taskID + "\n" +
                            "Duration: " + taskDuration + " hours";

                    JOptionPane.showMessageDialog(null, taskDetails);
                    JOptionPane.showMessageDialog(null, "Returning to the main menu...");//(trashgod and matoni, 1963)
                    break;
                }
            } else if (choice == 1) {
                // Show Report option
                JOptionPane.showMessageDialog(null, "Coming soon...");//(trashgod and matoni, 1963)
            } else if (choice == 2) {
                // Quit option
                break; // Exit the program
            }
        }
    }

    private static boolean isUsernameValid(String username) {
        // Check if the username contains an underscore and is no more than 5 characters long
        return username.matches("[a-zA-Z0-9]{1,5}_[a-zA-Z0-9]{1,5}");
    }

    private static boolean isPasswordValid(String password) {
        // Check if the password meets the complexity rules
        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        if (password.length() >= 8) {
            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    hasUppercase = true;
                } else if (Character.isDigit(c)) {
                    hasDigit = true;
                } else if (!Character.isLetterOrDigit(c)) {
                    hasSpecialChar = true;
                }
            }
        }

        return hasUppercase && hasDigit && hasSpecialChar;
    }

    private static String generateTaskID(String taskName, int taskNumber, String developerLastName) {
        String firstTwoLetters = taskName.substring(0, 2).toUpperCase();
        String lastThreeLetters = developerLastName.substring(developerLastName.length() - 3).toUpperCase();

        return firstTwoLetters + ":" + taskNumber + ":" + lastThreeLetters;
    }
}

// refrence lsit 
/*Anto&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  and Sean (1957) Returning the dialog from joptionpane.showoptiondialog, Stack Overflow. Available at: https://stackoverflow.com/questions/3883778/returning-the-dialog-from-joptionpane-showoptiondialog (Accessed: 09 June 2023). 
Jdevelop and Taras Lazarenko (1958) Joptionpane.showinputdialog() in GWT, Stack Overflow. Available at: https://stackoverflow.com/questions/9799879/joptionpane-showinputdialog-in-gwt (Accessed: 09 June 2023). 
Riské and camickr (1969) Put a jbutton on a jbutton on Java Swing, Stack Overflow. Available at: https://stackoverflow.com/questions/75024163/put-a-jbutton-on-a-jbutton-on-java-swing (Accessed: 09 June 2023). 
trashgodtrashgod&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;   and matonimatoni&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  (1963) Show message(joptionpane) from swingworker thread- doInBackground(), Stack Overflow. Available at: https://stackoverflow.com/questions/43469594/show-messagejoptionpane-from-swingworker-thread-doinbackground (Accessed: 09 June 2023). 
Simon Mills, Bon and user1803551 (1962) JComboBox getSelectedItem, Stack Overflow. Available at: https://stackoverflow.com/questions/33197323/jcombobox-getselecteditem (Accessed: 09 June 2023). 
*/
//