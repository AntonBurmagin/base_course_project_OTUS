package exceptions;

public class MonthNotFoundException extends RuntimeException {
  public MonthNotFoundException(String month) {
    super(String.format("%s month is not found!", month));
  }
}
