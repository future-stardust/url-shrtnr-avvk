package edu.kpi.testcourse.logic;

public interface Logic {
  void createUser(String email, String pass);
  String signInUser(String email, String pass);
  void createAlias(String link, String alias);
  String createAlias(String link);
  void deleteAlias(String alias);
  String redirect(String alias);
  String[] userAliases();
}
