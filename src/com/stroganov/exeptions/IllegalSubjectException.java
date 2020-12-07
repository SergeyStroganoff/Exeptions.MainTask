package com.stroganov.exeptions;


import com.stroganov.AcademicSubject;
import com.stroganov.Student;

public class IllegalSubjectException extends Exception {

    public IllegalSubjectException(Student student, AcademicSubject subject) {
        super("Ошибка: У студента " + student + " отсутствует предмет: " + subject);
    }
}


