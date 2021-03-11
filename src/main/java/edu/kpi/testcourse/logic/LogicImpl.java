package edu.kpi.testcourse.logic;

import edu.kpi.testcourse.auth.Auth;
import edu.kpi.testcourse.bigtable.BigTable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Logic {
  @Inject
  private final BigTable bigtable;

  @Inject
  private Auth auth;

  int defaultUserId = 1;

  public Logic(BigTable bigtable){
    this.bigtable = bigtable;
  }

  public void createUser(String email, String pass){
    if (!this.auth.userExist(email)){
      this.auth.createUser(email, pass);
    }
  }

  public String signInUser(String email, String pass){
    if (!this.auth.userLogined(email)){
      return this.auth.userLogin(email, pass);
    }
    return "";
  }

  public void createAlias(String link, String alias){
    this.bigtable.putAlias(defaultUserId, link, alias);
  }

  public String createAlias(String link){
    String alias = new LinkGenerator().generate();
    this.bigtable.putAlias(defaultUserId, link, alias);
    return alias;
  }

  public void deleteAlias(String alias){
    this.bigtable.deleteAlias(defaultUserId, alias);
  }

  public String redirect(String alias){
    String link = this.bigtable.getLink(alias);
    return link;
  }

  public String[] userAliases(){
    return this.bigtable.getAllUserLinks();
  }
}
