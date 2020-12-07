package com.stroganov.exeptions;

public class LackStudentInGroupException extends Exception {

    public LackStudentInGroupException() {

        super("Отсутствие студентов в группе");
    }
}
