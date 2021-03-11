package edu.kpi.testcourse.auth;

import edu.kpi.testcourse.bigtable.BigTable;
import javax.inject.Inject;

public class AuthImpl implements Auth{


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
