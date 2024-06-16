# String Calculator

## Overview

The `StringCalculator` class provides a method to add numbers represented as strings. It supports various delimiters, handles edge cases such as negative numbers and numbers greater than 1000, and allows for flexible input formats.

## Features

- Handles an empty string and returns `0`.
- Handles a single number and returns its value.
- Handles two numbers separated by a comma and returns their sum.
- Handles an unknown number of numbers separated by commas or new lines.
- Supports custom delimiters defined in the format `//[delimiter]\n[numbers...]`.
- Supports multiple delimiters of varying lengths.
- Throws an exception for negative numbers with an appropriate message.
- Ignores numbers greater than 1000.

## Usage

### Method

#### `int add(String numbers)`

- **Parameters**:
    - `numbers` (String): A string containing numbers separated by delimiters.
- **Returns**:
    - `int`: The sum of the numbers.
- **Throws**:
    - `IllegalArgumentException`: If negative numbers are included in the input string.

### Example

```java
public class Main {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        
        try {
            System.out.println(calculator.add(""));           // Output: 0
            System.out.println(calculator.add("1"));          // Output: 1
            System.out.println(calculator.add("1,2"));        // Output: 3
            System.out.println(calculator.add("1\n2,3"));     // Output: 6
            System.out.println(calculator.add("//;\n1;2"));   // Output: 3
            System.out.println(calculator.add("//[***]\n1***2***3")); // Output: 6
            System.out.println(calculator.add("//[*][%]\n1*2%3")); // Output: 6
            System.out.println(calculator.add("//[**][%%]\n1**2%%3")); // Output: 6
            System.out.println(calculator.add("2,1001"));     // Output: 2
            System.out.println(calculator.add("//;\n1;-2"));  // Throws exception
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());              // Output: Negatives not allowed: [-2]
        }
    }
}
