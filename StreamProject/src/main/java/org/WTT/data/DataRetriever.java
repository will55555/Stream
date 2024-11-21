package org.WTT.data;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.WTT.entity.Car;
import org.WTT.entity.Student;
import org.WTT.wrapper.CarWrapper;
import org.WTT.wrapper.StudentWrapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DataRetriever {
    public static List<Student> getStudents() {
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file
            StudentWrapper studentDataWrapper = objectMapper.readValue(
                    new File("src/main/java/org/WTT/student_data.json"),
                    StudentWrapper.class
            );

            // Get the list of students
            List<Student> students = studentDataWrapper.getStudents();
            return students;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Car> getCars() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file
            CarWrapper carDataWrapper = objectMapper.readValue(
                    new File("src/main/java/org/WTT/car_data.json"),
                    CarWrapper.class
            );

            // Get the list of cars
            return carDataWrapper.getCars();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
