package com.stroganov;

import com.stroganov.exeptions.LackGroupInFacultyException;

import java.util.List;
import java.util.Objects;

public class Faculty implements GetMediumGrade {

    private int ID;
    private String facultyName;
    private List<Group> facultyGroups;

    private University university;

    public Faculty(int ID, String facultyName) {
        this.ID = ID;
        this.facultyName = facultyName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public List<Group> getFacultyGroups() {
        return facultyGroups;
    }

    public void setFacultyGroups(List<Group> facultyGroups) throws LackGroupInFacultyException {
        if (facultyGroups.isEmpty() || facultyGroups == null) {

            throw new LackGroupInFacultyException();
        }
        this.facultyGroups = facultyGroups;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "ID=" + ID +
                ", facultyName='" + facultyName + '\'' +
                ", facultyGroups=" + facultyGroups +
                ", university=" + university +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return ID == faculty.ID &&
                facultyName.equals(faculty.facultyName) &&
                Objects.equals(facultyGroups, faculty.facultyGroups) &&
                Objects.equals(university, faculty.university);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, facultyName, facultyGroups, university);
    }

    @Override
    public int getMediumGrade(AcademicSubject currentSubject) {
        int mediumGrade = 0;
        int count = 0;
        for (Group currentGroup : facultyGroups) {

            mediumGrade += currentGroup.getMediumGrade(currentSubject);
            //  System.out.println(mediumGrade);
            count++;
        }
        return mediumGrade / count;
    }


}
