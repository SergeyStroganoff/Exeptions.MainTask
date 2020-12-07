package com.stroganov;

import com.stroganov.exeptions.LackFacultyInUniversityException;

import java.util.List;
import java.util.Objects;

public class University {

    private String universityName;
    private List<Faculty> facultyList;

    public University(String universityName, List<Faculty> facultyList) {

        if (facultyList.isEmpty() || facultyList == null) {
            try {
                throw new LackFacultyInUniversityException();
            } catch (LackFacultyInUniversityException e) {
                e.printStackTrace();
            }
        }
        this.universityName = universityName;
        this.facultyList = facultyList;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(List<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    @Override
    public String toString() {
        return "Университет :" + universityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return universityName.equals(that.universityName) &&
                facultyList.equals(that.facultyList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(universityName, facultyList);
    }

    public int getMediumGradeByUniversity(AcademicSubject subject) {
        int mediumGrade = 0;
        int count = 0;
        for (Faculty faculty : facultyList
        ) {
            mediumGrade += faculty.getMediumGrade(subject);
            count++;
        }
        return mediumGrade / count;

    }

}
