package my.tests.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.stream.IntStream.*;

public class ThreadTest {
  public void calculate() {
    try {
      System.out.println("No synchronized test: ");
      ExecutorService exec = Executors.newFixedThreadPool(2);

      Calculator calculator = new Calculator();

      range(0, 1000).forEach(i -> exec.submit(calculator::syncAdd));
      exec.awaitTermination(1000, TimeUnit.MILLISECONDS);

      System.out.println("Sum result: " + calculator.getSum());
      exec.shutdownNow();
      if (calculator.getSum() != 1000) {
        throw new RuntimeException("result should be 1000 but was " + calculator.getSum());
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
