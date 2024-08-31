package com.myschool.component;

import com.myschool.component.models.CollegeStudent;
import com.myschool.component.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ApplicationExampleTest {
    @Value("${info.school.name}")
    private String schoolName;
    @Value("${info.app.name}")
    private String appName;
    @Value("${info.app.description}")
    private String appDescription;
    @Value("${info.app.version}")
    private String appVersion;
    @Autowired
    CollegeStudent collegeStudent;
    @Autowired
    StudentGrades studentGrades;
    @BeforeEach
    void beforeEach(){
        System.out.println("Testing "+appName+" with version "+appVersion);
        collegeStudent.setFirstname("John");
        collegeStudent.setLastname("Cook");
        collegeStudent.setEmailAddress("john@hotmail.com");
        studentGrades.setMathGradeResults(List.of(98.00d, 87.00d, 76.00d, 53.00d));
        collegeStudent.setStudentGrades(studentGrades);
    }
    @Test
    void test_addGradeResultsForSingleClass(){
        assertEquals(314.0,studentGrades.addGradeResultsForSingleClass(
                collegeStudent.getStudentGrades().getMathGradeResults()),
                "Grades should sum to 314.0"
        );
    }
}
