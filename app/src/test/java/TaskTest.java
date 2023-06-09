import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {

    @Test
    public void testPrintTaskDetails() {
        // Create a task instance with sample values
        Task task = new Task("Sample Task", "Sample Description", "Developer", 5);

        // Define the expected details string
        String expectedDetails = "Task ID: SAMDEV\n" +
                "Task Name: Sample Task\n" +
                "Task Description: Sample Description\n" +
                "Developer Details: Developer\n" +
                "Task Duration: 5 hours";

        // Call the method being tested
        String actualDetails = task.printTaskDetails();

        // Perform the assertion
        assertEquals(expectedDetails, actualDetails);
    }
}
