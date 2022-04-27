import activities.WelcomePage;
import models.DataModel;
import models.DesignModel;

public class Main {

    public static void main(String[] args){

        DataModel.setManagerArrayList();
        DataModel.setModelProjectStatus();
        DataModel.setPriority();
        DataModel.setIssueStatus();
        DataModel.setTaskStatus();
        DataModel.setMemberIssueStatus();
        DataModel.setMemberTaskStatus();
        DataModel.setTeamMembers();
        DataModel.setRecurringTaskType();
        DataModel.setIssueClassification();
        DataModel.setIssueSeverity();

        DesignModel.printTitle();
        WelcomePage.loginDisplay();

    }
}
