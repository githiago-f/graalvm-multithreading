package my.tests;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.stream.IntStream.*;

public class App
{
  public static void main( String[] args ) throws InterruptedException {
    System.out.println("No synchronized test: ");
    ExecutorService exec = Executors.newFixedThreadPool(2);

    Calculator calculator = new Calculator();

    range(0, 1000).forEach(i -> exec.submit(calculator::syncAdd) );
    exec.awaitTermination(1000, TimeUnit.MILLISECONDS);

    System.out.println("Sum result: " + calculator.getSum());
    exec.shutdownNow();
    if(calculator.getSum() != 1000) {
      throw new RuntimeException("result should be 1000 but was " + calculator.getSum());
    }
  }
}
