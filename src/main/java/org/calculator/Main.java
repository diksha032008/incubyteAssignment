package org.calculator;

public class Main {

  public static void main(String[] args) {
    StringCalculator calculator = new StringCalculator();
    System.out.println(calculator.add(""));
    System.out.println(calculator.add("1"));
    System.out.println(calculator.add("1,2"));
    System.out.println(calculator.add("1\n2,3"));
  }
}