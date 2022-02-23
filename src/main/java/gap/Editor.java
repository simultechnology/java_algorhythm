package gap;

import java.util.Scanner;

class Editor {
    private final GapBuffer buf;
    private int cursor = 0;

    private Editor(String text) {
        buf = new GapBuffer(text);
    }
    
    private void run() {
        Display.output(buf, cursor);
        char ch;
        while ((ch = CharReader.get()) != CharReader.EOF) {
            switch (ch) {
                case CharReader.MOVE_FORWARD:
                    moveCursor(1);
                    break;
                case CharReader.MOVE_BACKWARD:
                    moveCursor(-1);
                    break;
                case CharReader.DELETE:
                    if (cursor < buf.length()) {
                        buf.delete(cursor);
                    }
                    break;
                default:
                    buf.insert(cursor++, ch);
                    break;
            }
            Display.output(buf, cursor);
        }
    }

    private void moveCursor(int n) {
        int newCursor = cursor + n;
        if (newCursor >= 0 && newCursor <= buf.length()) {
            cursor = newCursor;
        }
    }

    public static void main(String[] args) {
        Editor editor = new Editor(args[0]);
        editor.run();
    }
}

class Display {
    static void output(GapBuffer gapBuffer, int cursor) {
        System.out.println("cursor: " + cursor);
        gapBuffer.debug();
    }
}

class CharReader {

    static final char EOF = 'Q';
    static final char MOVE_FORWARD = 'F';
    static final char MOVE_BACKWARD = 'B';
    static final char DELETE = 'D';

    static char get() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a character: ");
        char value = scanner.next().charAt(0);
        System.out.println("Character: " + value);
        return value;
    }
}
