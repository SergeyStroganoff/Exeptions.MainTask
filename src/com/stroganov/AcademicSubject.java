package com.stroganov;

import java.util.Objects;

public class AcademicSubject {

    private int ID;
    private String subjectName;
    private String teacherName;
    private int numberHours;

    public AcademicSubject(int ID, String subjectName, String teacherName, int numberHours) {
        this.ID = ID;
        this.subjectName = subjectName;
        this.teacherName = teacherName;
        this.numberHours = numberHours;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getNumberHours() {
        return numberHours;
    }

    public void setNumberHours(int numberHours) {
        this.numberHours = numberHours;
    }

    @Override
    public String toString() {
        return "AcademicSubject{" +
                "ID=" + ID +
                ", subjectName='" + subjectName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", numberHours=" + numberHours +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcademicSubject that = (AcademicSubject) o;
        return ID == that.ID &&
                numberHours == that.numberHours &&
                subjectName.equals(that.subjectName) &&
                Objects.equals(teacherName, that.teacherName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, subjectName, teacherName, numberHours);
    }
}
