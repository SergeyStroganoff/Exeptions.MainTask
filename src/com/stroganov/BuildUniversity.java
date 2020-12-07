package com.stroganov;

import com.stroganov.exeptions.ErrorSetGradeException;
import com.stroganov.exeptions.LackGroupInFacultyException;
import com.stroganov.exeptions.LackOfSubjectException;
import com.stroganov.exeptions.LackStudentInGroupException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BuildUniversity {

    private static University university;

    private BuildUniversity() {

    }

    public static University getNewUniversity(String nameUniversity) {

        AcademicSubject mathematics = new AcademicSubject(1, "Математика", "Ильясов Д.В.", 440);
        AcademicSubject physics = new AcademicSubject(1, "Физика", "Гагарин Б.М.", 440);
        AcademicSubject programming = new AcademicSubject(1, "Программирование", "Блинов В.Г.", 440);
        AcademicSubject logic = new AcademicSubject(1, "Логика", "Свердлов А.Н.", 440);

        Student studentIvanov = null;
        Student studentPetrov = null;
        try {
            studentIvanov = new Student(1, "Иванов", "Михаил", "Семенович",
                    new ArrayList<>(Arrays.asList(mathematics, physics, programming, logic)));

            studentPetrov = new Student(1, "Петров", "Аркадий", "Валентинович",
                    new ArrayList<>(Arrays.asList(mathematics, physics, programming, logic)));

        } catch (LackOfSubjectException e) {
            e.printStackTrace();
        }

        assert studentIvanov != null;
        assert studentPetrov != null;

        try {

            studentIvanov.addAcademicSubjectGradeMap(mathematics, 5);
            studentIvanov.addAcademicSubjectGradeMap(physics, 8);
            studentIvanov.addAcademicSubjectGradeMap(programming, 10);
            studentIvanov.addAcademicSubjectGradeMap(programming, 7);

            studentPetrov.addAcademicSubjectGradeMap(mathematics, 7);
            studentPetrov.addAcademicSubjectGradeMap(physics, 9);
            studentPetrov.addAcademicSubjectGradeMap(programming, 8);
            studentPetrov.addAcademicSubjectGradeMap(programming, 7);
        } catch (ErrorSetGradeException e) {

            e.getMessage();
        }
        Group bestGroup = null;
        try {
            bestGroup = new Group(12, "Первая Группа", new ArrayList<>(Arrays.asList(studentIvanov, studentPetrov)));
        } catch (LackStudentInGroupException e) {
            e.printStackTrace();
        }

        Faculty bestFaculty = new Faculty(1, "Автоматизация систем");
        try {
            bestFaculty.setFacultyGroups(new ArrayList<>(Collections.singletonList(bestGroup)));
        } catch (LackGroupInFacultyException e) {
            e.printStackTrace();
        }

        return university = new University(nameUniversity, new ArrayList<>(Collections.singletonList(bestFaculty)));

    }

}

