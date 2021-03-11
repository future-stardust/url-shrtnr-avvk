package edu.kpi.testcourse.rest;

import edu.kpi.testcourse.logic.Logic;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import javax.inject.Inject;

/**
 * REST API controller that provides logic for Micronaut framework.
 */
@Controller
public class ApiController {

  @Inject
  private final Logic logic;

  public ApiController(Logic logic) {
    this.logic = logic;
  }

  @Post(value = "/users/signup")
  public HttpResponse<String> signUp(String email, String password) {
    // ToDo implement
    return HttpResponse.status(HttpStatus.NOT_IMPLEMENTED);
  }

  @Post(value = "/login")
  public HttpResponse<String> login(String email, String password) {
    // ToDo implement
    return HttpResponse.status(HttpStatus.NOT_IMPLEMENTED);
  }

  @Post(value = "/urls/shorten")
  public HttpResponse addAlias(String url, Optional<String> alias) {
    // ToDo implement
    return HttpResponse.status(HttpStatus.NOT_IMPLEMENTED);
  }

  @Get(value = "/urls")
  public HttpResponse<String> getUserUrls() {
    // ToDo implement
    return HttpResponse.status(HttpStatus.NOT_IMPLEMENTED);
  }

  @Delete(value = "urls/{alias}")
  public HttpResponse<String> deleteAlias(String alias) {
    // ToDo implement
    return HttpResponse.status(HttpStatus.NOT_IMPLEMENTED);
  }

  @Get(value = "/r/{alias}")
  public HttpResponse<String> redirect(String alias) {
    // ToDo implement
    return HttpResponse.status(HttpStatus.NOT_IMPLEMENTED);
  }
}
