package report4;

// Circle class implementing the Shape interface
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("반지름이 " + radius + "인 원");
    }

    @Override
    public double getArea() {
        return PI * radius * radius; // Area of the circle
    }
}

// Oval class implementing the Shape interface
class Oval implements Shape {
    private double width, height;

    public Oval(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println(width + "x" + height + "에 내접하는 타원");
    }

    @Override
    public double getArea() {
        return PI * (width / 2) * (height / 2); // Area of the oval
    }
}

// Rect class implementing the Shape interface
class Rect implements Shape {
    private double width, height;

    public Rect(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println(width + "x" + height + "크기의 사각형");
    }

    @Override
    public double getArea() {
        return width * height; // Area of the rectangle
    }
}

// Main class
public class chapter5_15 {
    public static void main(String[] args) {
        Shape[] list = new Shape[3];  // Array to hold Shape references
        list[0] = new Circle(5);       // Circle with radius 5
        list[1] = new Oval(20, 30);    // Oval with dimensions 20x30
        list[2] = new Rect(10, 40);     // Rectangle with dimensions 10x40

        for (Shape shape : list) {
            shape.redraw(); // Redraw each shape
        }
        
        for (Shape shape : list) {
            System.out.println("면적은 " + shape.getArea()); // Print area of each shape
        }
    }
}
