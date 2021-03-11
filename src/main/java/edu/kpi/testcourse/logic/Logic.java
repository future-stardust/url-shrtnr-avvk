package edu.kpi.testcourse.logic;

public class Logic {

  public void createUser(String email, String pass) {
  }

  public void signInUser(String email, String pass) {
  }

  public void signOutUser(String tokenAuth) {
  }

  public void createAlias(String authToken, String link, String alias) {
  }

  public void createAlias(String authToken, String link) {
  }

  public void deleteAlias(String authToken, String alias) {
  }

  public String redirect(String alias) {
    return "";
  }

  public String[] userAliases(String authToken) {
    return null;
  }
}
