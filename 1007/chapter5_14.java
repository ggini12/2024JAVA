package report4;

import java.util.Scanner;

// Abstract class for shapes
abstract class Shape {
    private Shape next;

    public Shape() {
        next = null;
    }

    public void setNext(Shape obj) {
        next = obj; // Link to the next shape
    }

    public Shape getNext() {
        return next; // Get the next shape
    }

    public abstract void draw(); // Abstract method for drawing the shape
}

// Concrete shape classes
class Line extends Shape {
    @Override
    public void draw() {
        System.out.println("Line");
    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("Rect");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

// Manager class to handle shapes
class ShapeManager {
    private Shape head; // Head of the linked list
    private int count;  // Number of shapes

    public ShapeManager() {
        head = null;
        count = 0;
    }

    public void insertShape(int shapeType) {
        Shape newShape = null;
        switch (shapeType) {
            case 1: newShape = new Line(); break;
            case 2: newShape = new Rect(); break;
            case 3: newShape = new Circle(); break;
            default: System.out.println("Invalid shape type."); return;
        }

        if (head == null) {
            head = newShape; // Insert as the first shape
        } else {
            Shape current = head;
            while (current.getNext() != null) {
                current = current.getNext(); // Traverse to the end
            }
            current.setNext(newShape); // Link the new shape
        }
        count++;
        System.out.println("Shape inserted.");
    }

    public void deleteShape(int position) {
        if (position < 1 || position > count) {
            System.out.println("삭제할 수 없습니다."); // Out of bounds
            return;
        }

        if (position == 1) {
            head = head.getNext(); // Remove the head
        } else {
            Shape current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.getNext(); // Find the previous shape
            }
            Shape toDelete = current.getNext(); // Shape to delete
            current.setNext(toDelete.getNext()); // Bypass the shape
            if (toDelete != null) {
                System.out.println("Shape deleted.");
            }
        }
        count--;
    }

    public void displayShapes() {
        if (head == null) {
            System.out.println("No shapes to display.");
            return;
        }
        Shape current = head;
        int position = 1;
        while (current != null) {
            System.out.print(position + ": ");
            current.draw(); // Draw the shape
            current = current.getNext();
            position++;
        }
    }
}

// Main class for the graphic editor
public class chapter5_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShapeManager shapeManager = new ShapeManager();

        while (true) {
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>> ");
            int command = scanner.nextInt();
            if (command == 4) {
                System.out.println("Beauty Graphic Editor를 종료합니다.");
                break;
            }

            switch (command) {
                case 1: // Insert shape
                    System.out.print("Line(1), Rect(2), Circle(3)>> ");
                    int shapeType = scanner.nextInt();
                    shapeManager.insertShape(shapeType);
                    break;
                case 2: // Delete shape
                    System.out.print("삭제할 도형의 위치>> ");
                    int position = scanner.nextInt();
                    shapeManager.deleteShape(position);
                    break;
                case 3: // Display shapes
                    shapeManager.displayShapes();
                    break;
                default:
                    System.out.println("지원하지 않는 명령입니다.");
            }
        }

        scanner.close();
    }
}
