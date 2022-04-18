package designs;

import users.Manager;
import users.Member;
import users.TeamLead;

import java.util.ArrayList;

public class Models {
    public static ArrayList<Manager> managers = new ArrayList<>();
    public static ArrayList<Member> members = new ArrayList<>();
    public static ArrayList<TeamLead> teamLeads = new ArrayList<>();
    public static ArrayList<String> status = new ArrayList<>();
    public static ArrayList<String> priority = new ArrayList<>();
    public static ArrayList<String> discussionBox = new ArrayList<>();

    public static ArrayList<Manager> getManagers() {
        return managers;
    }

    public static void setManagers() {
        managers.add(new Manager("manager1", "manager1@gmail.com", "manager1"));
        managers.add(new Manager("manager2", "manager2@gmail.com", "manager2"));
        managers.add(new Manager("m", "m@gmail.com", "123"));
    }

    public static ArrayList<Member> getMembers() {
        return members;
    }

    public static void setMembers() {
        members.add(new Member("member1", "member1@gmail.com", "member1"));
        members.add(new Member("member2", "member2@gmail.com", "member2"));
        members.add(new Member("member3", "member3@gmail.com", "member3"));
        members.add(new Member("member4", "member4@gmail.com", "member4"));
        members.add(new Member("member5", "member5@gmail.com", "member5"));
        members.add(new Member("member6", "member6@gmail.com", "member6"));
        members.add(new Member("member7", "member7@gmail.com", "member7"));
        members.add(new Member("member8", "member8@gmail.com", "member8"));
        members.add(new Member("member9", "member9@gmail.com", "member9"));
        members.add(new Member("member10", "member10@gmail.com", "member10"));

    }

    public static ArrayList<TeamLead> getTeamLeads() {
        return teamLeads;
    }

    public static ArrayList<String> getStatus() {
        return status;
    }

    public static void setStatus() {
        status.add("RequirementAnalysing");
        status.add("Design stage");
        status.add("Implementation");
        status.add("Debugging");
        status.add("Completed");
    }

    public static ArrayList<String> getPriority() {
        return priority;
    }

    public static void setPriority() {
        priority.add("Low");
        priority.add("Medium");
        priority.add("High");
        priority.add("Very High");
    }

    public static ArrayList<String> getDiscussionBox() {
        return discussionBox;
    }
}
