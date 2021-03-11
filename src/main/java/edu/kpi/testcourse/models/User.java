package edu.kpi.testcourse.models;

public class User {

  private int userId;
  private String email;
  private String userPassHash;

  public User(int userId, String email, String userPassHash) {
    this.email = email;
    this.userPassHash = userPassHash;
  }

  public int getUserId() {
    return userId;
  }

  public String getEmail() {
    return email;
  }

  public String getUserPassHash() {
    return userPassHash;
  }

}
