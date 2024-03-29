package com.simultechnology.array;

import java.util.Arrays;

public class MyStack {

    private Object stack[];
    private int stackSize;
    private int sp;

    private static final int DEFAULT_STACK_SIZE = 100;

    public MyStack() {
        this(DEFAULT_STACK_SIZE);
    }

    public MyStack(int size) {
        stack = new Object[size];
        stackSize = size;
        sp = 0;
    }

    public void clear() {
        Arrays.fill(stack, 0, sp, null);
    }

    public void push(Object x) {
        if (sp >= stackSize) {
            throw new IllegalStateException("Stack overflow");
        }
        stack[sp++] = x;
    }

    public static void main(String[] args) {
        System.out.println("start!");
    }
}
