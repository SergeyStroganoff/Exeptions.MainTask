package com.stroganov;

public class Run {
    public static void main(String[] args) {

        AcademicSubject mathematics = new AcademicSubject(1, "Математика", "Ильясов Д.В.", 440);

        University myFirstUniversity = BuildUniversity.getNewUniversity("Зубцовский политех");
        System.out.println(myFirstUniversity.getMediumGradeByUniversity(myFirstUniversity.getFacultyList().get(0).getFacultyGroups().get(0).getStudentList().get(0).getAcademicSubjects().get(0)));
        System.out.println(myFirstUniversity.getMediumGradeByUniversity(mathematics));

    }
}
