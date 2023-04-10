package org.example.util;

public final class Queries {

    public static String FIND_ALL_USERS = "SELECT e FROM User e";
    public static String FIND_USER_BY_USERNAME = "SELECT e FROM User e WHERE e.username = ?1";
    public static String FIND_USER_BY_USERNAME_SECOND_METHOD = "SELECT e FROM User e WHERE e.username = :username";

    private Queries() {}
}
