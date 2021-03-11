package edu.kpi.testcourse.auth;

public class AuthImpl implements Auth{
  // todo

  public void createUser(String email, String pass){ }

  public boolean userExist(String email) {
    return false;
  }

  public String userLogin(String email, String pass){
    return "token";
  }

  public boolean userLogined(String email){
    return false;
  }

}
