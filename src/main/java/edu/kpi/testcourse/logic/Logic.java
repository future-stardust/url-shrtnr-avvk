package edu.kpi.testcourse.logic;

public interface Logic {

  public void createUser(String email, String pass);

  public String signInUser(String email, String pass);

  public void createAlias(String link, String alias);

  public void createAlias(String link);

  public void deleteAlias(String alias);

  public String redirect(String alias);
}
