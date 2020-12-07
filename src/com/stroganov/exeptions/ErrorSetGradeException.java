package com.stroganov.exeptions;

import com.stroganov.AcademicSubject;

public class ErrorSetGradeException extends Exception {
    public ErrorSetGradeException(AcademicSubject subject) {
        super("Оценка по предмету: " + subject + " находится вне допустимых значений");
    }
}
