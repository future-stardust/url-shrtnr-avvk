package edu.kpi.testcourse.bigtable;

import com.google.gson.Gson;
import edu.kpi.testcourse.models.AuthToken;
import edu.kpi.testcourse.models.User;
import edu.kpi.testcourse.models.UserLink;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

class BigTableImpl implements BigTable {

  private final String jsonFileExtension = ".json";
  private final String userFileExtension = ".usr";
  private final String rootPath = "./.data";
  private static int userId = 0;

  public BigTableImpl() {
    createDirectory(rootPath);
  }

  @Override
  public int putUser(String email, String passHash) {
    User user = new User(userId++, email, passHash);
    var userDir = getUserDirectory(user.getEmail());
    userDir.mkdir();
    var userFile = getUserFile(user.getEmail());
    saveToFile(user, userFile);

    return user.getUserId();
  }

  @Override
  public User getUser(String email) {
    var file = getUserFile(email);
    return readFromJsonFile(file, User.class);
  }

  @Override
  public String getUserId(String authToken) {
    return null;
  }

  @Override
  public void putToken(String userId, String authToken) {

  }

  @Override
  public AuthToken getToken(String userId) {
    return null;
  }

  @Override
  public void deleteToken(String authToken) {

  }

  @Override
  public void putAlias(int userId, String alias, String link) {
    UserLink userLink = new UserLink(userId, alias, link);
    var userDir = getUserDirectory(String.valueOf(userLink.getUserId()));
    if (!userDir.exists()) {
      userDir.mkdir();
    }
    var file = getAliasFile(userLink.getShortenedLink(), String.valueOf(userLink.getUserId()));
    saveToFile(userLink, file);
  }

  @Override
  public UserLink getLink(String alias) {
    var file = getAliasFile(alias);
    if (file == null) {
      return null;
    }
    return readFromJsonFile(file, UserLink.class);
  }

  @Override
  public boolean deleteAlias(String alias) {
    var file = getAliasFile(alias);
    if (file == null) {
      return false;
    }
    file.delete();
    return true;
  }

  @Override
  public List<UserLink> getAllUserLinks(String userId) {
    var userDir = getUserDirectory(userId);
    var userFiles = userDir.listFiles(new FilenameFilter() {
      @Override
      public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(jsonFileExtension);
      }
    });
    var userUrls = new ArrayList<UserLink>();
    if (userFiles != null) {
      for (File file : userFiles) {
        var urlAlias = readFromJsonFile(file, UserLink.class);
        userUrls.add(urlAlias);
      }
    }

    return userUrls;
  }

  public void clear() {
    var rootDir = new File(rootPath);
    var userDirs = rootDir.listFiles();
    if (userDirs != null) {
      for (var userDir : userDirs) {
        clearDirectory(userDir);
        userDir.delete();
      }
    }
  }

  private void clearDirectory(File dir) {
    File[] allContents = dir.listFiles();
    if (allContents != null) {
      for (File file : allContents) {
        file.delete();
      }
    }
  }

  private void createDirectory(String path) {
    var dir = new File(path);
    if (!dir.exists()) {
      dir.mkdir();
    }
  }

  private boolean saveToFile(Object src, File dest) {
    var g = new Gson();
    try {
      if (dest.createNewFile()) {
        var writer = new FileWriter(dest);
        writer.write(g.toJson(src));
        writer.flush();
        writer.close();
        return true;
      } else {
        return false;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return false;
  }

  public <T> T readFromJsonFile(File src, Class<T> classOfT) {
    if (src.exists()) {
      try {
        var str = new String(Files.readAllBytes(src.toPath()));
        var g = new Gson();
        return g.fromJson(str, classOfT);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return null;
  }

  private File getUserDirectory(String email) {
    return new File(String.join("/", rootPath, email));
  }

  private File getUserFile(String email) {
    return new File(String.join("/", rootPath, email, email + userFileExtension));
  }

  private File getAliasFile(String alias, String user) {
    return new File(String.join("/", rootPath, user, alias + jsonFileExtension));
  }

  private File getAliasFile(String alias) {
    var rootDir = new File(rootPath);
    var users = rootDir.list();
    if (users != null) {
      for (var user : users) {
        var aliasFile = getAliasFile(alias, user);
        if (aliasFile.exists()) {
          return aliasFile;
        }
      }
    }
    return null;
  }
}
