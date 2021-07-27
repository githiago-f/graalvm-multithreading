package my.tests;

public class Calculator {
  private int sum;

  public synchronized void syncAdd() {
    setSum(getSum() + 1);
  }

  public int getSum() {
    return sum;
  }

  public void setSum(int sum) {
    this.sum = sum;
  }
}
