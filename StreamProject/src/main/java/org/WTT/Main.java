package org.WTT;

import org.WTT.entity.Student;
import org.WTT.service.CarOps;
import org.WTT.service.StudentOps;
import java.time.Month;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarOps carOps = new CarOps();
        StudentOps studentOps = new StudentOps();

        System.out.println(carOps.getCarCount());

        while (true)
        {
            System.out.println("""
                    *==========Horrorcore-Software================================*
                    |                                                             |
                    |        Basic Filtering Tasks                                |
                    |1-Find all students with GPA above 3.5                       |
                    |2-List students under 20 years old                           |
                    |3-Identify all international students                        |
                    |4-Find students in Computer Science major                    |
                    |5-List students from specific universities                   |
                    |6-Identify students with scholarship                         |
                    |7-Filter students by graduation year                         |
                    |8-Find students with exactly 60 credit hours                 |
                    |                                                             |
                    |         Advanced Filtering Tasks                            |
                    |9-Students with GPA between 3.0 and 3.5                      |
                    |10-International students in STEM majors                     |
                    |11-Scholarship recipients with high credit hours             |
                    |12- Students in top 10% of their class by GPA                |
                    |13-Students with phone numbers from specific area codes      |
                    |14-Find students born in specific months                     |
                    |15-Identify students near graduation (within 2 years)        |
                    |                                                             |
                    |      Aggregation and Statistical Analysis                   |
                    |                                                             |
                    |16-Calculate total number of students per major              |
                    |17-Find average GPA by major                                 |
                    |18-Determine percentage of international students            |
                    |19-Calculate average age of students                         |
                    |20- Find total credit hours across all students              |
                    |21-Compute median GPA                                        |
                    |22-Find the youngest and oldest students                     |
                    |23-Calculate scholarship distribution percentage             |
                    |24-Determine gender ratio in different majors                |
                    |25-Find universities with highest average GPA                |
                    |                                                             |
                    |   Complex Analytical Tasks                                  |
                    |                                                             |
                    |26- Identify students matching multiple criteria:            |
                    |     GPA > 3.7                                               |
                    |      International student                                  |
                    |      STEM major                                             |
                    |      Scholarship recipient                                  |
                    |27-Create a comprehensive student profile ranking system     |
                    |28-Develop a predictive model for scholarship likelihood     |
                    |29-Analyze correlation between age and academic performance  |
                    |30-Group students by complex multi-dimensional criteria      |
                                                                                  |
                    *=============================================================*
                   \s""");
            Scanner input = new Scanner(System.in);
            int answer = input.nextInt();
            switch (answer){

                case 1:
                    //display list of options
                    //surround with switch statement:
                    System.out.println("Students with gpa at or higher than 3.5:");
                    studentOps.getStudentsAboveGpa().forEach(System.out:: println);
                    break;
                case 2:
                    System.out.println("List students under 20 years old");
                    studentOps.getStudentsUnder20().forEach(System.out:: println);
                    break;
                case 3:
                    System.out.println("Identify all international students");
                    studentOps.isInternational().forEach(System.out:: println);
                    break;
                case 4:
                    System.out.println("Find students in Computer Science major");
                    studentOps.getMajor().forEach(System.out:: println);
                    break;
                case 5:
                    System.out.println("List students from specific universities (Northern college)");
                    studentOps.getUniversity().forEach(System.out:: println);
                    break;
                case 6:
                    System.out.println("Identify students with scholarship");
                    studentOps.isScholarshipRecipient().forEach(System.out:: println);
                    break;
                case 7:
                    System.out.println("Filter students by graduation year");
                    studentOps.graduationYear().forEach(System.out:: println);
                    break;
                case 8:
                    System.out.println("Find students with exactly 60 credit hours");
                    studentOps.creditHours().forEach(System.out:: println);
                    break;
                case 9:
                    System.out.println("Students with GPA between 3.0 and 3.5");
                    studentOps.gpaBetween3and3point5().forEach(System.out:: println);
                    break;
                case 10:
                    System.out.println("International students in STEM major");
                    studentOps.internationStemStudents().forEach(System.out:: println);
                    break;
                case 11:
                    System.out.println("Scholarship recipients with high credit hours");
                    studentOps.scholarshipWithHighCreditHours().forEach(System.out:: println);
                    break;
                case 12:
                    System.out.println("Students in top 10% of their class by GPA");
                    studentOps.top10ByGpa().forEach(System.out:: println);
                    break;
                case 13:
                    System.out.println("Students with phone numbers from specific area codes");
                    studentOps.StudentAreaCode().forEach(System.out:: println);
                    break;
                case 14:
                    System.out.println("Find students born in specific months");
                   // StudentOps studentOps = new StudentOps();

                    // Find students born in January
                    List<Student> students = List.of();
                    List<Student> januaryStudents = studentOps.StudentBornInSpecificMonth(students, Month.JANUARY);

                    // Print results
                    januaryStudents.forEach(System.out::println);
                    break;
                    //List<Student> januaryStudents = new studentOps.StudentBornInSpecificMonth();

                    // Print results


                    //Month month = null;
                    //studentOps.StudentBornInSpecificMonth(students, month).forEach(System.out:: println);

                case 15:
                    System.out.println("Identify students near graduation (within 2 years)");
                    studentOps.StudentNearGraduation().forEach(System.out:: println);
                    break;
                case 16:
                    System.out.println("Calculate total number of students in political science: ");
                    studentOps.StudentAmountByPoliticalScience();
                    break;
                case 17:
                    System.out.println("Find average GPA by major");
                    studentOps.AverageGpaByMajor().forEach(System.out:: println);
                    break;
                case 18:
                    System.out.println("Determine percentage of international students");
                    studentOps.internationalPercentage().forEach(System.out:: println);
                    break;
                case 19:
                    System.out.println("Calculate average age of students");
                    studentOps.studentAverageAge().forEach(System.out:: println);
                    break;
                case 20:
                    System.out.println("Find total credit hours across all students");
                    studentOps.studentsTotalCreditHours();
                    break;
                            //.forEach(System.out:: println);
                case 21:
                    System.out.println("Compute median GPA");
                    studentOps.studentsMedianGpa();
                            //.forEach(System.out:: println);
                    break;
                case 22:
                    System.out.println("Find the youngest and oldest students");
                    studentOps.findOldestAndYoungestStudents();
                            //.forEach(System.out:: println);
                    break;
                case 23:
                    System.out.println("Calculate scholarship distribution percentage");
                    studentOps.ScholarshipPercentage();
                            //.forEach(System.out:: println);
                    break;
                case 24:
                    System.out.println("Determine gender ratio in different majors");
                    studentOps.genderRatioByMajor();
                            //.forEach(System.out:: println);
                    break;
                case 25:
                    System.out.println("Find universities with highest average GPA");
                    studentOps.universitiesHighestAverageGpa();
                            //.forEach(System.out:: println);
                    break;
                case 26:
                    System.out.println("Identify students matching multiple criteria");
                    studentOps.studentsCriteria();//
                            //.forEach(System.out:: println);
                    break;
                case 27:
                    System.out.println("Create a comprehensive student profile ranking system");
                    studentOps.studentRankingSystem();
                            //.forEach(System.out:: println);
                    break;
                case 28:
                    System.out.println("Develop a predictive model for scholarship likelihood");
                    studentOps.scholarshipLikelihood();
                            //.forEach(System.out:: println);
                    break;
                case 29:
                    System.out.println("Analyze correlation between age and academic performance");
                    studentOps.performanceMetrics();
                            //.forEach(System.out:: println);
                    break;
                case 30:
                    System.out.println("Group students by complex multi-dimensional criteria");
                    studentOps.groupStudentsByCriteria();
                            //.forEach(System.out:: println);
                    break;

                default:
                    System.out.println("Please select an option from the menu");
            }



        }




    }
}