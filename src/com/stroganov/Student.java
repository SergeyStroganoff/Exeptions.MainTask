package com.stroganov;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Student {
    Map<AcademicSubject, Integer> academicSubjectGradeMap = new HashMap<>();
    List<AcademicSubject> academicSubjects;
    private int ID;
    private String surname;
    private String firstName;
    private String secondName;
    private Group group;

    public Student(int ID, String surname, String firstName, String secondName, List<AcademicSubject> academicSubjects) {
        this.ID = ID;
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.academicSubjects = academicSubjects;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<AcademicSubject> getAcademicSubjects() {
        return academicSubjects;
    }

    public void setAcademicSubjects(List<AcademicSubject> academicSubjects) {
        this.academicSubjects = academicSubjects;
    }


    public Map<AcademicSubject, Integer> getAcademicSubjectGradeMap() {
        return academicSubjectGradeMap;
    }

    public void addAcademicSubjectGradeMap(AcademicSubject subject, Integer grade) {

        if (grade > 0 && grade < 11) {
            academicSubjectGradeMap.put(subject, grade);
        } else throw new IllegalArgumentException("Неверный аргумент");

    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", group=" + group +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return ID == student.ID &&
                surname.equals(student.surname) &&
                firstName.equals(student.firstName) &&
                Objects.equals(secondName, student.secondName) &&
                group.equals(student.group) &&
                Objects.equals(academicSubjects, student.academicSubjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, surname, firstName, secondName, group, academicSubjects);
    }

    public int getMediumGrade() {

        int mediumGrade = 0;
        int numberSubject = 0;

        for (Map.Entry<AcademicSubject, Integer> entry : academicSubjectGradeMap.entrySet()) {

            mediumGrade += entry.getValue();
            numberSubject++;

        }
        return mediumGrade / numberSubject;
    }

    public int getSubjectGrade(AcademicSubject subject) throws IllegalArgumentException {

        if (academicSubjectGradeMap.get(subject) != null) {
            return academicSubjectGradeMap.get(subject);
        } else {
            throw new IllegalArgumentException("У студента нет запрашиваемого предмета");
        }
    }


}
