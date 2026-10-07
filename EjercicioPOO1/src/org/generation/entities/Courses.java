package org.generation.entities;

import java.util.ArrayList;

public class Courses {
    String courseName;
    String professorName;
    int year;
    ArrayList<Student> students;

    public Courses(String courseName, String professorName, int year){
        this.courseName = courseName.toUpperCase();
        this.professorName = professorName.toUpperCase();
        this.year = year;
        this.students = new ArrayList<>();
    }// constructor Courses

    public void enroll(Student student){
        this.students.add(student);
    }// enroll

    public void enroll(Student[] students){
        for(Student student: students){
            this.enroll(student);
        }// forEach
    }// enroll

    public void unEnroll(Student student){
        //TODO remove this student from the collection
        // Hint: check if that really is this student
        Student tempStudent = student;

        for(Student std: students){
            if(tempStudent.equals(std)){
                tempStudent = std;
                break;
            }// if
        }// forEach

        this.students.remove(tempStudent);

    }// unEnroll

    public int countStudents(){
        return this.students.size();
    }// countStudents

    public int bestGrade(){
        int max = 0;

        for(Student student: this.students){
            if(student.grade > max){
                max = student.grade;
            }// if
        }// forEach

        return max;
    }// bestGrade
    public double average(){
        if(this.students.isEmpty()){
            return 0;
        }
        double sum = 0;
        for(Student s : this.students){
            sum += s.grade;
        }
        return sum / this.students.size();
    }// average
    public void ranking(){
        ArrayList<Student> sorted = new ArrayList<>(this.students);
        sorted.sort((a, b) -> b.grade - a.grade);

        System.out.println("\n--- Ranking " + this.courseName + " ---");
        int pos = 1;
        for(Student s : sorted){
            System.out.println(pos + ". " + s.firstName + " " + s.lastName + " - " + s.grade);
            pos++;
        }
    }

    public void isAboveAverage(){
        double avg = average();
        System.out.println("\n--- Promedio: " + avg + " ---");
        for(Student s : this.students){
            if(s.grade > avg){
                System.out.println(s.firstName + " - " + s.grade + " -> ENCIMA");
            } else {
                System.out.println(s.firstName + " - " + s.grade + " -> debajo");
            }
        }
    }



    @Override
    public String toString() {
        return "Courses{" +
                "courseName='" + courseName + '\'' +
                ", professorName='" + professorName + '\'' +
                ", year=" + year +
                ", students=" + students +
                '}';
    }// toString
}// class Courses
