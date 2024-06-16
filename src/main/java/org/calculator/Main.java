package org.calculator;

public class Main {

  public static void main(String[] args) {
    try {
      StringCalculator calculator = new StringCalculator();
      System.out.println(calculator.add(""));
      System.out.println(calculator.add("1"));
      System.out.println(calculator.add("1,2"));
      System.out.println(calculator.add("1\n2,3"));
      System.out.println(calculator.add("//;\n1;2"));
      System.out.println(calculator.add("2,1001"));
      System.out.println(calculator.add("//[***]\n1***2***3"));
      System.out.println(calculator.add("//[*][%]\n1*2%3"));
      System.out.println(calculator.add("//[**][%%]\n1**2%%3"));
      System.out.println(calculator.add("1,-2,3"));
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }
}