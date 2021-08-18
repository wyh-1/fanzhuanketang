package com.fanzhuanketang.service;

public interface LoginService {
    boolean loginTeacher(String username, String password);
    boolean loginStudent(String username, String password);
    boolean loginAdmin(String username, String password);
}
