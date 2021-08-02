package my.tests.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import static java.util.stream.IntStream.*;

public class ThreadTest {
  private Logger logger = LogManager.getLogger("ThreadTest");
  private Marker marker = MarkerManager.getMarker("Error at ThreadTest: ");

  public void calculate() {
    try {
      logger.info("No synchronized test: ");
      ExecutorService exec = Executors.newFixedThreadPool(2);

      Calculator calculator = new Calculator();

      range(0, 1000).forEach(i -> exec.submit(calculator::syncAdd));
      exec.awaitTermination(1000, TimeUnit.MILLISECONDS);

      logger.info("Sum result: " + calculator.getSum());
      exec.shutdownNow();
      if (calculator.getSum() != 1000) {
        String message = "result should be 1000 but was " + calculator.getSum();
        logger.debug(marker, message);
        throw new RuntimeException(message);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
