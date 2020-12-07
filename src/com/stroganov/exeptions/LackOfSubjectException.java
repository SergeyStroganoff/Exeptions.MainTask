package com.stroganov.exeptions;

public class LackOfSubjectException extends Exception {

    public LackOfSubjectException () {
        super("У студента должен быть хотя бы один предмет");
    }
}
