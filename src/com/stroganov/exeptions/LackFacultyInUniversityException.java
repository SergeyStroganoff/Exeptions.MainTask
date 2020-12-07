package com.stroganov.exeptions;

public class LackFacultyInUniversityException extends Exception {

    public LackFacultyInUniversityException() {
        super("Ошибка. В университете не могут отсутствовать факультеты. Должен быть хотя бы один");
    }
}
