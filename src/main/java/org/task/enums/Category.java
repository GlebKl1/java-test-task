package org.task.enums;

public enum Category {
    CALLS("вызовы"), SMS("смс"), INTERNET("интернет");

    public final String label;

    Category(String label) {
        this.label = label;
    }
}
