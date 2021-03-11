package edu.kpi.testcourse;

import edu.kpi.testcourse.logic.LinkGenerator;
import java.util.Random;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LinkGeneratorTest {
  @Test
  void testDefaultLinkLength() {
    LinkGenerator generator = new LinkGenerator();
    int defaultLen = 8;
    assertThat(generator.generate().length()).isEqualTo(defaultLen);
  }
  @Test
  void testCustomLinkLength() {
    LinkGenerator generator = new LinkGenerator();
    int customLen = 22;
    assertThat(generator.generate(customLen).length()).isEqualTo(customLen);
  }
}
