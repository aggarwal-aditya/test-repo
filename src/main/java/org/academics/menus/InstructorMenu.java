package org.academics.menus;

import org.academics.users.Instructor;
import org.academics.users.specialPrivileges;
import org.academics.utility.Utils;

public class InstructorMenu {
    public static void instructorMenu(Instructor instructor) {
        System.out.println("1. View your courses");
        System.out.println("2. Float a new course");
        System.out.println("3. Delist a course");
        System.out.println("4. Download Student List");
        System.out.println("5. Upload Grades");
        System.out.println("6. View student grades");
        System.out.println("7. View your profile");
        System.out.println("8. Logout");
        System.out.println("Enter your choice:");
        int choice = Utils.getUserChoice(8);
        switch (choice) {
            case 1 -> {
                try {
                    instructor.viewCourses();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Unable to fetch courses at the moment. Please try again later.");
                }
                instructorMenu(instructor);
            }
            case 2 -> {
                try {
                    instructor.floatCourse();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Unable to float course at the moment. Please try again later.");
                }
                instructorMenu(instructor);
            }
            case 3 -> {
                try {
                    instructor.delistCourse();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Unable to delist course at the moment. Please try again later.");
                }
                instructorMenu(instructor);
            }
            case 4 -> {
                try {
                    instructor.downloadAndExportStudentList();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Unable to download student list at the moment. Please try again later.");
                }
                instructorMenu(instructor);
            }
            case 5 -> {
                try {
                    instructor.uploadGrades();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Unable to upload grades at the moment. Please try again later.");
                }
                instructorMenu(instructor);
            }
            case 6 -> {
                try {
                    specialPrivileges.viewStudentGrades();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Unable to fetch student grades at the moment. Please try again later.");
                }
                instructorMenu(instructor);
            }
            case 7 -> {
                try {
                    instructor.viewProfile();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Unable to fetch profile at the moment. Please try again later.");
                }
                instructorMenu(instructor);
            }
            case 8 -> {
                System.out.println("Logging out...");
                MainMenu.mainMenu();
            }
        }

    }
}
