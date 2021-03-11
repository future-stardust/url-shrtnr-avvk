package edu.kpi.testcourse.bigtable;

import edu.kpi.testcourse.models.User;
import edu.kpi.testcourse.models.UserLink;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BigTableImplTest {

  @Test
  void checkUserSaving() {
    BigTableImpl bigTable = new BigTableImpl();
    String email = "user@email.com";
    String passHash = "21982fsadfj";
    bigTable.putUser(email, passHash);
    User user = bigTable.getUser(email);

    assertThat(user.getUserPassHash()).isEqualTo(passHash);
  }

  @Test
  void checkAliasSaving() {
    BigTableImpl bigTable = new BigTableImpl();
    int userId = 1;
    String alias = "5zT3bGQ";
    String link = "http://google.com";
    bigTable.putAlias(userId, alias, link);

    UserLink linkObj = bigTable.getLink(alias);
    assertThat(linkObj.getRedirectLink()).isEqualTo(link);
  }
}
