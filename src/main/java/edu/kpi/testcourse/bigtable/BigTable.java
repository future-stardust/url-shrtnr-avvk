package edu.kpi.testcourse.bigtable;


// ⚠️ Please, pay attention, that you should not use any 3rd party persistence library (e.g. data
// ⚠️ base, implementation of key-value storage, etc)
import com.google.gson.JsonObject;
import edu.kpi.testcourse.models.AuthToken;
import edu.kpi.testcourse.models.User;
import edu.kpi.testcourse.models.UserLink;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;

/**
 * BigTable is a key-value storage...
 */
public interface BigTable {

  int putUser(String email, String passHash);
  User getUser(String email);
  String getUserId(String authToken);

  void putToken(String userId, String authToken);
  AuthToken getToken(String userId);
  void deleteToken(String authToken);

  void putAlias(int userId, String alias, String link);
  boolean deleteAlias(String alias);
  UserLink getLink(String alias);
  List<UserLink> getAllUserLinks(String userId);
}
