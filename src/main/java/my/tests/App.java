package my.tests;

import my.tests.assertions.Assertion;

public class App
{
  public static void main(String[] args) {
    Assertion a = new Assertion();
    a.testAssertKeyword("");
    a.testAssertKeyword(null);
  }
}
