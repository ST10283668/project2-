public class Task {
    private String taskID;
    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;

    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskID = createTaskID();
    }

    public String getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    private String createTaskID() {
        String taskID = taskName.substring(0, Math.min(taskName.length(), 3)).toUpperCase();
        taskID += developerDetails.substring(0, Math.min(developerDetails.length(), 3)).toUpperCase();
        return taskID;
    }

    public String printTaskDetails() {
        String details = "Task ID: " + taskID + "\n";
        details += "Task Name: " + taskName + "\n";
        details += "Task Description: " + taskDescription + "\n";
        details += "Developer Details: " + developerDetails + "\n";
        details += "Task Duration: " + taskDuration + " hours";
        return details;
    }
}

