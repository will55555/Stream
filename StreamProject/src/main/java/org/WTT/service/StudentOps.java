package org.WTT.service;

import org.WTT.data.DataRetriever;
import org.WTT.entity.Student;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class StudentOps {
    private final List<Student> students = DataRetriever.getStudents();




    public Integer getStudentCount() {
        return students.size();
    }
    //Find all students with GPA above 3.5
    public  List<Student> getStudentsAboveGpa(){

        return students.stream().filter(student -> student.getGpa() > 3.5).toList();
    }
    //List students under 20 years old
    public  List<Student> getStudentsUnder20(){

        return students.stream().filter(student -> student.getAge() > 30).toList();
    }
    //Identify all international students
    public List<Student> isInternational(){
        return students.stream().filter(Student::isInternational).toList();
    }
    //Find students in Computer Science major
    public List<Student> getMajor(){
        return students.stream().filter(student-> Objects.equals(student.getMajor(), "Computer Science")).toList();
    }
    //List students from specific universities
    // input required
    public List<Student> getUniversity(){
        return students.stream().filter(student-> Objects.equals(student.getUniversity(), "Northern College")).toList();
    }
    //Identify students with scholarship
    public List<Student> isScholarshipRecipient(){
        return students.stream().filter(Student::isScholarshipRecipient).toList();
    }
    //Filter students by graduation year
    //make user input
    public List<Student> graduationYear(){
        return students.stream().filter(student -> Objects.equals(student.getGraduationYear(), 2028)).toList();
    }
    //Find students with exactly 60 credit hours
    public List<Student> creditHours(){
        return students.stream().filter(student -> Objects.equals(student.getCreditHours(), 60)).toList();
    }
    //Students with GPA between 3.0 and 3.5
    public List<Student> gpaBetween3and3point5(){


       return students.stream().filter(student -> student.getGpa()>=3.0 && student.getGpa()<=3.5).toList();

    }
    //International students in STEM majors
    public List<Student> internationStemStudents(){

        //pull out list of majors
        Set<Student> allMajors = new HashSet<>(getMajor());//
        //return students.stream().filter(student -> stemMajors.contains(student.getMajor())).toList();
        //categorize them (STEM)
        Set<String> stemMajors = new HashSet<>(List.of("Engineering", "Physics"));
         /*return students.stream()
                .filter(student -> stemMajors.contains(student.getMajor())).toList();*/

        return students.stream()
                .filter(student -> {
                   if(student.isInternational()){
                    //System.out.println("Checking student major: " + student.getMajor());
                       //return allMajors.addAll(student.getMajor());
                       return stemMajors.contains(student.getMajor());}

                   return allMajors.addAll(Set.of());

                })
                .toList();

    }
    public List<Student> scholarshipWithHighCreditHours(){
        //make baseline for high credit hours 50
        return students.stream().filter(student -> student.getCreditHours()>100).toList();
        //if credit hours >50 and is scholarship recipient show list


        //return List.of();
    }
    public List<Student> top10ByGpa(){
        //To calculate the top 10% of a class by GPA,
        // you need to gather all the students' GPAs,
        //Set<Student> allGpa = new HashSet<>(getGpa());

        // list them from highest to lowest, and
        // then identify the students whose GPA falls within the top 10% of the list;
        // this means your GPA would need to be higher than 90% of your classmates to be in the top 10% of the class.


        //math for top10% by gpa

        //if top 10 display student/s


       return List.of();
    }

    public List<Student> StudentAreaCode(){


        return List.of();
    }
    public List<Student> StudentBornInSpecificMonth(List<Student> students, Month targetMonth) {
        // Return students born in the specified month
        return students.stream()
                .filter(student -> {
                    try {
                        // Parse the dateOfBirth if not null
                        LocalDate dob = LocalDate.parse(student.getDateOfBirth());
                        // Check if the month matches
                        return dob.getMonth() == targetMonth;
                    } catch (Exception e) {
                        // Skip students with invalid or null dateOfBirth
                        return false;
                    }
                })
                .collect(Collectors.toList());
    }
    public List<Student> StudentNearGraduation(){
        //Identify students near graduation (within 2 years)

        //if graduation year = within 2 years, then list those students
        return students.stream().filter(student -> student.getGraduationYear() >= 2024 && student.getGpa() <= 2026).toList();


       // return List.of();
    }
    public void StudentAmountByPoliticalScience(){
        //show list of major to choose from
        long count = students.stream()
                .filter(student -> "Political Science".equalsIgnoreCase(student.getMajor()))
                .count();

        // Print the total number of students majoring in Political Science
        System.out.println("Number of students majoring in Political Science: " + count);

        // Optionally, list all students in Political Science
        students.stream()
                .filter(student -> "Political Science".equalsIgnoreCase(student.getMajor()))
                .toList(); // Adjust depending on how you access name
    }
    //chatgpt
    public List<Student> AverageGpaByMajor(){
        //show list of major to choose from
        //if major = imput show average gpa in said major
        // Get unique majors from the student list
        Set<String> majors = students.stream()
                .map(Student::getMajor)
                .collect(Collectors.toSet());

        // Display majors for the user to choose from
        System.out.println("Available majors:");
        majors.forEach(System.out::println);

        // User input for the desired major
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the major:");
        String inputMajor = scanner.nextLine();

        // Filter students by the input major
        List<Student> studentsInMajor = students.stream()
                .filter(student -> student.getMajor().equalsIgnoreCase(inputMajor))
                .collect(Collectors.toList());

        // Check if any students were found for the given major
        if (studentsInMajor.isEmpty()) {
            System.out.println("No students found for the major: " + inputMajor);
            return List.of();
        }

        // Calculate the average GPA for the selected major
        double averageGpa = studentsInMajor.stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);

        System.out.println("Average GPA for " + inputMajor + ": " + averageGpa);
        return studentsInMajor;
    }
    public List<Student> internationalPercentage(){
        //do math for international student percentage
        // Print the total number of students majoring in Political Science
        // Filter international students
        List<Student> internationalStudents = students.stream().filter(Student::isInternational).collect(Collectors.toList());
        double percentage = (double) internationalStudents.size() / students.size() * 100;

        // Display the result
        System.out.println("Percentage of international students: " + String.format("%.2f", percentage) + "%");

        // Return the list of international students
        return internationalStudents;
    }

    public List<Student> studentAverageAge(){
        //do math for average student age
        //display said students


        double ageAverage = students.stream()
                .mapToDouble(Student::getAge)
                .average()
                .orElse(0.0);
        // Filter students whose age is equal to or close to the average age
        List<Student> studentList = students.stream()
                .filter(student -> Math.abs(student.getAge() - ageAverage) <= 0.5) // Optional logic to match average-age students
                .toList();

        // Display the result
        System.out.println("Average age of students: " + String.format("%.2f", ageAverage));
        //System.out.println("Students: " + studentList);

        // Return the list of students (optionally filtered, or the full list)
        return students; // Alternatively, return `studentList` if you're filtering by average age.

    }
    public void studentsTotalCreditHours(){
        //do math for  total credit hours across all students
        int totalCreditHours= students.stream().mapToInt(Student::getCreditHours).sum();
        // Display the result
        System.out.println("Total credit hours across all students: " + totalCreditHours);
        // Return the list of students
        //display result





        //return List.of();
    }
    public void studentsMedianGpa(){
        //do math for median gpa
        //display result
        //TBD ask the setup for this
        List<Student> sortedStudents = students.stream()
                .sorted(Comparator.comparingDouble(Student::getGpa))
                .toList();

        // Calculate the median GPA
        int size = sortedStudents.size();
        if (size == 0) {
            System.out.println("No students in the list.");
            //return 0.0; // Return 0 if there are no students
        }

        double median;
        if (size % 2 == 1) {
            // Odd number of students: median is the middle element
            median = sortedStudents.get(size / 2).getGpa();
        } else {
            // Even number of students: median is the average of the two middle elements
            median = (sortedStudents.get(size / 2 - 1).getGpa() +
                    sortedStudents.get(size / 2).getGpa()) / 2.0;
        }

        // Display the result
        System.out.println("Median GPA: " + String.format("%.2f", median));

        // Return the median GPA
        //find who is the oldest and the youngest student
        //display result


    }
    public void findOldestAndYoungestStudents(){
        //TBD ask the setup for this
        // Sort the students by their date of birth
        List<Student> sortedStudents = students.stream()
                .filter(student -> {
                    try {
                        // Ensure the dateOfBirth is valid
                        LocalDate.parse(student.getDateOfBirth());
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                })
                .sorted((s1, s2) -> {
                    LocalDate dob1 = LocalDate.parse(s1.getDateOfBirth());
                    LocalDate dob2 = LocalDate.parse(s2.getDateOfBirth());
                    return dob1.compareTo(dob2); // Sort by date
                })
                .toList();

        if (sortedStudents.isEmpty()) {
            System.out.println("No valid date of birth records found.");
            return;
        }

        // Get the oldest and youngest students
        Student oldestStudent = sortedStudents.getFirst();
        Student youngestStudent = sortedStudents.getLast();

        // Display the results
        System.out.println("Oldest Student: " + oldestStudent);
        System.out.println("Youngest Student: " + youngestStudent);

        // Return them as a list


    }
    public void ScholarshipPercentage(){
        //do math for percentage of student getting scholarships.
        //display result
        List<Student> scholarshipStudents = students.stream()
                .filter(Student::isScholarshipRecipient)
                .toList();

        double percentage = (double) scholarshipStudents.size() / students.size() * 100;
        System.out.println("Percentage of students receiving scholarships: " + String.format("%.2f", percentage) + "%");


    }
    public void genderRatioByMajor(){
        //display major from list
        //group all by major
        //group by gender hashmap within hashmaps
        //do math for gender ration in selected major
        //or
        //since different major, do math for each and list ration for each major?
        //display result
        // Group students by major and then by gender
        Map<String, Map<String, Long>> genderRatio = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getMajor, // Group by major
                        Collectors.groupingBy(
                                Student::getGender, // Further group by gender
                                Collectors.counting() // Count the number of students
                        )
                ));

        // Display results
        genderRatio.forEach((major, genderMap) -> {
            System.out.println("Major: " + major);
            long total = genderMap.values().stream().mapToLong(Long::longValue).sum();
            genderMap.forEach((gender, count) -> {
                double percentage = (double) count / total * 100;
                System.out.printf("  Gender: %s, Count: %d, Percentage: %.2f%%\n", gender, count, percentage);
            });
        });

    }
    public List<Student> universitiesHighestAverageGpa(){
        // sort by university?
        //filter universities






       return List.of();
    }
    public void studentsCriteria(){
        //example of all criterias needing to be met to show said students

        // Set of STEM majors
        Set<String> stemMajors = new HashSet<>(List.of("Engineering", "Physics"));

        // Filter students based on the criteria:
        List<Student> filteredStudents = students.stream()
                .filter(student -> student.getGpa() > 3.7 // GPA > 3.7
                        && student.isInternational()      // International student
                        && stemMajors.contains(student.getMajor()) // STEM major
                        && student.isScholarshipRecipient()) // Scholarship recipient
                .toList();
        // Display results
        if (filteredStudents.isEmpty()) {
            System.out.println("No students meet the criteria.");
        } else {
            System.out.println("Students meeting the criteria:");
            filteredStudents.forEach(System.out::println);
        }
    }

    public List<String> studentRankingSystem(){
        //TBD
        //pull universities
        // rank by gpa and improvise
        //university with best average gpa
        //university with most international students
        //display results
        // Step 1: Rank universities by average GPA


        return List.of();
    }
    public void scholarshipLikelihood(){
        //TBD
        //if gpa > ...
        System.out.println("Students most likely to get scholarship");

        //display results
        students.stream().filter(student -> student.getGpa() > 3.7).toList();

    }
    public List<Student> performanceMetrics(){
        //TBD
        //if gpa > ...
        //
        //
        //


        //display results





        return List.of();
    }
    public List<Student> groupStudentsByCriteria(){
        //TBD
        //if gpa > ...
        //
        //
        //


        //display results





        return List.of();
    }



}
