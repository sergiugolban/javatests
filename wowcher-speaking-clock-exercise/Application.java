import java.util.regex.Pattern;

public class Application {

  public static void main(String[] args) {
    Application app = new Application();
    System.out.println(app.convertTimeToWordFormat("09:09"));
  }

  public String convertTimeToWordFormat(String time) {
    validateFortam(time);

    String hourFormat;
    String minFormat = "";
    String timeWordNames[] = {"zero", "one", "two", "three", "four",
        "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen",
        "fourteen", "fifteen", "sixteen", "seventeen",
        "eighteen", "nineteen", "twenty", "thirty", "forty", "fifty"
    };

    if ("00:00".equals(time)) {
      return "It's Midnight";
    }

    if ("12:00".equals(time)) {
      return "It's Midday";
    }

    if (Integer.parseInt(time.substring(0, 2)) > 20) {
      hourFormat = timeWordNames[20] + " " + timeWordNames[Integer.parseInt(time.substring(1, 2))];
    } else {
      hourFormat = timeWordNames[Integer.parseInt(time.substring(0, 2))];
    }

    if (Integer.parseInt(time.substring(3, 5)) > 20) {
      minFormat = timeWordNames[Integer.parseInt(time.substring(3, 4)) + 18] + " "
          + timeWordNames[Integer.parseInt(
          time.substring(4, 5))];
    } else {
      if (time.charAt(3) == '0') {
        minFormat = timeWordNames[0] + " ";
      }
      minFormat += timeWordNames[Integer.parseInt(time.substring(3, 5))];
    }

    return "It's " + hourFormat + " " + minFormat;
  }

  private void validateFortam(String time) {
    Pattern pattern = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]");

    if (time == null || !pattern.matcher(time).matches()) {
      throw new RuntimeException("Invalid format");
    }
  }
}
