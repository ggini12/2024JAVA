package report4;

import java.util.Scanner;

interface IStack {
    int capacity();  // Returns the capacity of the stack
    int length();    // Returns the current number of elements in the stack
    boolean push(String val);  // Pushes a string onto the stack; returns true if successful
    String pop();    // Pops the string from the top of the stack; returns null if empty
}

class StringStack implements IStack {
    private String[] stack;
    private int top;

    public StringStack(int capacity) {
        stack = new String[capacity];
        top = 0;  // Initialize top index
    }

    @Override
    public int capacity() {
        return stack.length;  // Return the total capacity of the stack
    }

    @Override
    public int length() {
        return top;  // Return the number of elements currently in the stack
    }

    @Override
    public boolean push(String val) {
        if (top < stack.length) {
            stack[top++] = val;  // Add the value and increment the top index
            return true;  // Push was successful
        }
        return false;  // Stack is full
    }

    @Override
    public String pop() {
        if (top > 0) {
            return stack[--top];  // Decrement the top index and return the value
        }
        return null;  // Stack is empty
    }
}

public class chapter5_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("스택 용량 >>> ");
        int capacity = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        StringStack stack = new StringStack(capacity);

        while (true) {
            System.out.print("문자열입력 >>> ");
            String input = scanner.nextLine();
            if (input.equals("그만")) {
                break;  // Exit the loop if user types "그만"
            }
            if (!stack.push(input)) {
                System.out.println("스택이 꽉 차서 " + input + " 저장 불가");
            }
        }

        System.out.print("스택에 저장된 문자열 팝 : ");
        while (stack.length() > 0) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();  // New line after popping all elements

        scanner.close();
    }
}
