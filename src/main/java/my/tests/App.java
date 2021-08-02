package my.tests;

import my.tests.thread.ThreadTest;

public class App
{
  public static void main(String[] args) {
    ThreadTest t = new ThreadTest();
    System.out.println("LOGGED HERE");
    t.calculate();
  }
}
