package edu.kpi.testcourse.logic;

import edu.kpi.testcourse.auth.AuthImpl;
import edu.kpi.testcourse.bigtable.BigTable;
import edu.kpi.testcourse.models.UserLink;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
class LogicImpl implements Logic {
  @Inject
  private final BigTable bigtable;

  @Inject
  private AuthImpl auth;

  int defaultUserId = 1;

  public LogicImpl(BigTable bigtable){
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
    else{
    return "";}
  }

  public void createAlias(String link, String alias){
    this.bigtable.putAlias(defaultUserId, link, alias);
  }

  public void createAlias(String link){
    String alias = new LinkGenerator().generate();
    this.bigtable.putAlias(defaultUserId, link, alias);
  }

  public void deleteAlias(String alias){
    this.bigtable.deleteAlias(alias);
  }

  public String redirect(String alias){
    UserLink link = this.bigtable.getLink(alias);
    return link.getRedirectLink();
  }
}
