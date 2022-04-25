package users;

import objects.Project;

import java.util.ArrayList;

public class Tester extends TeamMember{

    ArrayList<Project> projectArrayList = new ArrayList<>();

    public Tester(String memberName, String memberEmail, String memberPassword){
        super(memberName, memberEmail, memberPassword);
    }

    public Tester(TeamMember teamMember) {
        super(teamMember.memberName, teamMember.memberEmail, teamMember.memberPassword);
    }

    public void doTesting(){

    }

    public void testerWorks(){

    }
}
