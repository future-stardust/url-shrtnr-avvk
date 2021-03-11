package edu.kpi.testcourse;

import edu.kpi.testcourse.auth.HashGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HashGeneratorTest {


  @Test
  void testHashMd5() {
    String password = "12345";
    String md5Hash = "827ccb0eea8a706c4c34a16891f84e7b";
    HashGenerator hashGenerator = new HashGenerator();
    assertThat(hashGenerator.generate(password)).isEqualTo(md5Hash);
  }
}
