package array;

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

    public static void main(String[] args) {
        System.out.println("start!");
    }
}
