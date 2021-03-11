package edu.kpi.testcourse.models;

public class UserLink {

  private int userId;
  private String shortenedLink;
  private String redirectLink;

  public UserLink(int userId, String shortenedLink, String redirectLink) {
    this.userId = userId;
    this.shortenedLink = shortenedLink;
    this.redirectLink = redirectLink;
  }

  public int getUserId() {
    return userId;
  }

  public String getShortenedLink() {
    return shortenedLink;
  }

  public String getRedirectLink() {
    return redirectLink;
  }
}
