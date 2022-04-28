package objects;

import java.util.ArrayList;

public class MileStones {
    String mileStoneName;
    String Description;

    ArrayList<Task> taskArrayList;

    String comments;

    public MileStones(String mileStoneName, String description, ArrayList<Task> taskArrayList) {
        this.mileStoneName = mileStoneName;
        Description = description;
        this.taskArrayList = taskArrayList;
    }

    public String getMileStoneName() {
        return mileStoneName;
    }

    public void setMileStoneName(String mileStoneName) {
        this.mileStoneName = mileStoneName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public ArrayList<Task> getTaskArrayList() {
        return taskArrayList;
    }

    public void setTaskArrayList(ArrayList<Task> taskArrayList) {
        this.taskArrayList = taskArrayList;
    }
}
