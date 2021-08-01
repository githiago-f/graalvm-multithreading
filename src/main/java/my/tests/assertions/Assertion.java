package my.tests.assertions;

public class Assertion {
  public void testAssertKeyword(String notNullableString) {
    assert notNullableString != null : "notNullableString should not be null";
  }
}
