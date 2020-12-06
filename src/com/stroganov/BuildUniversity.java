package com.stroganov;

import java.util.ArrayList;
import java.util.Arrays;

public class BuildUniversity {

    private static University university;

    private BuildUniversity() {

    }

    public static University getNewUniversity(String nameUniversity) {

        AcademicSubject mathematics = new AcademicSubject(1, "Математика", "Ильясов Д.В.", 440);
        AcademicSubject physics = new AcademicSubject(1, "Физика", "Гагарин Б.М.", 440);
        AcademicSubject programming = new AcademicSubject(1, "Программирование", "Блинов В.Г.", 440);
        AcademicSubject logic = new AcademicSubject(1, "Логика", "Свердлов А.Н.", 440);

        Student studentIvanov = new Student(1, "Иванов", "Михаил", "Семенович",
                new ArrayList<AcademicSubject>(Arrays.asList(mathematics, physics, programming, logic)));

        studentIvanov.addAcademicSubjectGradeMap(mathematics, 5);
        studentIvanov.addAcademicSubjectGradeMap(physics, 8);
        studentIvanov.addAcademicSubjectGradeMap(programming, 10);
        studentIvanov.addAcademicSubjectGradeMap(programming, 7);

        Student studentPetrov = new Student(1, "Петров", "Аркадий", "Валентинович",
                new ArrayList<AcademicSubject>(Arrays.asList(mathematics, physics, programming, logic)));

        studentPetrov.addAcademicSubjectGradeMap(mathematics, 7);
        studentPetrov.addAcademicSubjectGradeMap(physics, 9);
        studentPetrov.addAcademicSubjectGradeMap(programming, 8);
        studentPetrov.addAcademicSubjectGradeMap(programming, 7);

        Group bestGroup = new Group(12, "Первая Группа", new ArrayList<>(Arrays.asList(studentIvanov, studentPetrov)));

        Faculty bestFaculty = new Faculty(1, "Автоматизация систем");
        bestFaculty.setFacultyGroups(new ArrayList<>(Arrays.asList(bestGroup)));

        return university = new University(nameUniversity, new ArrayList<>(Arrays.asList(bestFaculty)));

    }

}

