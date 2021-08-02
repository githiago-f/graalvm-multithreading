package my.tests.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {
  public static Logger log = LogManager.getLogger("Class Calculator");

  private int sum;

  public synchronized void syncAdd() {
    setSum(getSum() + 1);
  }

  public int getSum() {
    log.info("getting sum = " + sum);
    return sum;
  }

  public void setSum(int sum) {
    log.info("setting sum = " + sum);
    this.sum = sum;
  }
}
