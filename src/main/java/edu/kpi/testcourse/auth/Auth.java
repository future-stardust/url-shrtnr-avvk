package edu.kpi.testcourse.auth;

public interface Auth {
  void createUser(String email, String pass);

  boolean userExist(String email);

  String userLogin(String email, String pass);

  boolean userLogined(String email);
}
