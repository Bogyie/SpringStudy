package com.spring.ex01;

public class Calculator2 {
    public int fibonacci(int x) {
        if (x == 1) {
            return 0;
        }
        if (x == 2) {
            return 1;
        }
        return fibonacci(x - 1) + fibonacci(x - 2);
    }

    public int factorial(int x) {
        if (x <= 1) {
            return 1;
        }
        return x * factorial(x - 1);
    }
}
