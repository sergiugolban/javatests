import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ApplicationTest {

  @ParameterizedTest
  @CsvSource(value = {
      "12:00|It's Midday",
      "00:00|It's Midnight",
      "21:34|It's twenty one thirty four",
      "23:48|It's twenty three forty eight",
      "19:19|It's nineteen nineteen",
      "05:05|It's five zero five"},
      delimiter = '|')
  void validTimes(String time, String expected) {
    Application test = new Application();
    Assertions.assertEquals(expected, test.convertTimeToWordFormat(time));
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "00:0", "99:99", "22:99", "24:05", "aa:bb"})
  void invalidTimes(String time) {
    Application test = new Application();
    RuntimeException e = Assertions.assertThrows(RuntimeException.class, () -> {
      test.convertTimeToWordFormat(time);
    });
    Assertions.assertEquals("Invalid format", e.getMessage());
  }
}
