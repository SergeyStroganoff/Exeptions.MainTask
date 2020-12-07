package com.stroganov;

import com.stroganov.exeptions.LackStudentInGroupException;

import java.util.List;
import java.util.Objects;

public class Group implements GetMediumGrade {

    Faculty faculty;
    private int ID;
    private String groupName;
    private List<Student> studentList;

    public Group(int ID, String groupName, List<Student> studentList) throws LackStudentInGroupException {

        if (studentList.isEmpty()) {
            throw new LackStudentInGroupException();
        }
        this.ID = ID;
        this.groupName = groupName;
        this.studentList = studentList;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) throws LackStudentInGroupException {

        if (studentList.isEmpty()) {
            throw new LackStudentInGroupException();
        }
        this.studentList = studentList;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Group{" +
                "ID=" + ID +
                ", groupName='" + groupName + '\'' +
                ", studentList=" + studentList +
                ", faculty=" + faculty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return ID == group.ID &&
                Objects.equals(groupName, group.groupName) &&
                studentList.equals(group.studentList) &&
                Objects.equals(faculty, group.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, groupName, studentList, faculty);
    }

    @Override
    public int getMediumGrade(AcademicSubject currentSubject) {
        int studentGrade = 0;
        int sumGrade = 0;
        int count = 0;

        for (Student currentStudent : studentList) {

            studentGrade = currentStudent.getSubjectGrade(currentSubject);
            if (studentGrade > 0) {
                sumGrade += studentGrade;
                count++;
            }
        }
        if (count > 0) {

            return sumGrade / count;
        } else return -1;
    }
}
