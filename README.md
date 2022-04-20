Task Management System – Console Application


**Introduction:**

`	`To construct a fully functioning console based task management application, using object oriented programming concepts of Java. 

**Requirement Analysis:**

1. Language : java 17.0.2 
1. Operating System : Windows 10 Operating system
1. Development : Intellij Idea Java IDE
1. Design : Draw.io
1. Backup : Github

**Background Theory:**
**
`	`Task management tools address a general need to organize, prioritize and visualize work. Through analysis, you learn how to get things done in more effective ways.

At its most basic level, a task management tool is used to help individuals, teams or businesses stay organized. Part of being organized includes setting priorities for tasks, visualizing the progress of tasks as they pass through stages of completion and compiling analysis or reports to direct future tasks and workflows.

1. **Prioritization:**

A task board lets you [organize your tasks by priority](https://www.planview.com/resources/articles/what-is-task-board/ "Article about task boards") so you can ensure that the most important things are completed first. That being said, task management tools are easy to update. By prioritizing tasks we are able to focus on how work should be attacked, rather than jumping from one item to another without any direction.

1. **Visualization :**

Not only will visualizing tasks help you remember what you need to do, but it helps you better understand a project as a whole. This means task management tools are easily accessible by everyone. When every item is laid out in a way that is easy to comprehend, dependencies become clear and collaboration is natural.

1. **Analysis:**	

Task management tools always provide for some form of analysis, whether it is a formula that you have created or something built into the tool.

**Document Scope and Purpose:**
**
`	`This document provides a description of the technical design for Summer Intern in Zoho-Corporation – Task Management System. This document’s primary purpose is to describe the architectural overview of the system. 

`	`Please note that this is a baseline document and may be updated as development progresses.

**Target Audience**
**
`	`This document is targeted (but not limited) to technical stakeholders:

·  IT Management

` `It is assumed that the reader has a technical background in software design and development

**Overview:** 
**
`	`In this task management system project, We are going to implement the uses of task management system in console using object oriented programming concepts of Java.  

`	`The project will be open to all such that any individual/ organization can create their account and use this task management system. The person who gives his credentials and logins into the account will be the Manager of his account.

`	`The manager can add members under his organization to his account members, so that those members can be assigned to projects. He gives them the member access, so that the members can login and update their status.

The manager will create a project and put members to the project. He assigns the team Lead/Leads to the project and he also assigns a Quality Assurance Engineer (QA) to the project. Instantly a chat Group is created so that the members of the group can interact with other group members.

The manager has the rights to deploy a completed project or to deploy a beta version. The manager can fully deploy a project, if all the tasks under the project are in “fully completed” stage or in “completed with reports” stage.

The Functionalities of **Manager** are, 

1. Manager creates his task management system account for the organization
1. Manager adds all the workers to the system, so that he can include them in projects later.
1. Manager can use the settings to change his password. 
1. Manager can create projects and add members to the project
1. Manager can edit the details of the project.
1. Manager can add more users to a particular project later after creating.
1. Manager can decide the Deployment status of the Project
1. Join chats in group chat box

A project contains:

1. Project Name
1. Project Description
1. Project Deadline
1. Project chat Group
1. Project Status
1. Project Deployment Status

After the creation of the project, the team lead/leads have the right to create tasks under the projects. They create projects and appoint members to the tasks from the given list of members for the project. Functionalities of a **Team lead** are,

1. As everyone except the Manager has a temporary password initially set by manager. Thus, they have change password option.
1. Team lead can create several tasks under the assigned projects and divide the project members among the tasks
1. They have projects assigned to themselves, thus they can alter the status of the tasks assigned to them.
1. They can view and alter the details of the tasks they created.
1. Join chats in group chat box

A Task contains:

1. Task Name
1. Task Description
1. Task Deadline
1. Task Status
1. Task Priority

Now, the organization has its project and the corresponding tasks ready, now the members of the project, can start doing their tasks and update the tasks of the status. Functionalities of **Members** are,

1. They can change their user password.
1. They can progress on their assigned tasks and update the status of the respective tasks.
1. Join chats in group chat box

When a member, completes his work on the tasks, He will update the status of the task to “submitted for test”. These tasks will be sent to the QA. He and his team will run tests on the tasks and complete all the testing to get into one of the two following results.

1. Task Test Success
1. Task Test Failure
1. Minor Failure
1. Major Failure

When the Test is success it is sent back as “Completed”, If it has a minor failure, then the task is sent as “Completed with Reports”. When a major failure is encountered, the task is reverted as “Issue Reported”

`	`**Status :**

1. Project Status :
1. Not yet started
1. Implementation
1. Testing
1. Completed
1. Completed with Reports
1. Deployment Status :
1. Not yet Deployed
1. Beta version Deployed
1. Deployed
1. Tasks Status:
1. Not yet Started
1. Requirement Analysis
1. Designing
1. Implementation
1. Optimization
1. Submitted for Test
1. Issue Reported
1. Completed 
1. Completed with Reports
1. Task status after Bug tracking :
1. Completed with Bug Analyzing
1. Completed with Bug Correction
1. Completed Bug submitted for test

**Code Organization:**

1. **Main.java**:	 The main.java file is the igniter of the project. The project runs from here. All model invokes are done in this file. 

1. **Activities package**:	The activities package contains the common activities which are used by all the Objects inside the project. For example, Login, Signup and Validations.

1. **Designs package**:	The designs package contains the model class which contains all the static details used in the project.

1. **Objects package:**	The objects package contains the objects that are used in the project. For example, the Project, the Task, and the Bugs.

1. **Users package:**		The users package contains all objects of the users of this task management system. This includes the Manager, Team Lead, Member, and the Tester


**Sample Screenshots:**










Page 10

