package edu.kpi.testcourse.models;

public class AuthToken {
  private int userId;
  private String authToken;

  public AuthToken(int userId, String authToken) {
    this.userId = userId;
    this.authToken = authToken;
  }

  public int getUserId() {
    return userId;
  }

  public String getAuthToken() {
    return authToken;
  }
}
