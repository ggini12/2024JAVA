package report4;
import java.util.Scanner;

// Abstract class with common fields and methods
abstract class Calc {
    protected String errorMsg; // Error message field
    protected int a, b;        // Operands

    // Method to set the operands
    public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    // Abstract method to perform the calculation
    abstract int calculate();
}

// Class for addition
class Add extends Calc {
    @Override
    int calculate() {
        return a + b;
    }
}

// Class for subtraction
class Sub extends Calc {
    @Override
    int calculate() {
        return a - b;
    }
}

// Class for multiplication
class Mul extends Calc {
    @Override
    int calculate() {
        return a * b;
    }
}

// Class for division
class Div extends Calc {
    @Override
    int calculate() {
        if (b == 0) {
            errorMsg = "0으로 나눌 수 없음."; // Set error message if division by zero
            throw new ArithmeticException(errorMsg);
        }
        return a / b;
    }
}

// Class for calculator operations
public class chapter5_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("두 정수와 연산자를 입력하시오 >> ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            String operator = scanner.next();

            Calc calc;

            switch (operator) {
                case "+":
                    calc = new Add();
                    break;
                case "-":
                    calc = new Sub();
                    break;
                case "*":
                    calc = new Mul();
                    break;
                case "/":
                    calc = new Div();
                    break;
                default:
                    System.out.println("지원하지 않는 연산자입니다.");
                    continue;
            }

            calc.setValue(a, b);

            try {
                int result = calc.calculate();
                System.out.println("계산 결과 " + result);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage() + " 프로그램 종료");
                break; // Exit the loop if an error occurs
            }
        }

        scanner.close();
    }
}
