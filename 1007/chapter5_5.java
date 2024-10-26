package report4;

class Point2D {
    private int x;
    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y +  ")";
    }
}

class Point3D extends Point2D {
    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void moveUp(int distance) {
        z += distance;
    }

    public void moveDown(int distance) {
        z -= distance;
    }

    public void move(int x, int y) {
        super.move(x, y);
    }

    public void move(int x, int y, int z) {
        super.move(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return super.toString() + "," + z + "의 점";
    }
}

public class chapter5_5 {
    public static void main(String[] args) {
        Point3D p = new Point3D(3, 2, 1);
        System.out.println(p.toString() + "입니다.");
        
        p.moveUp(3); // z축으로 3 이동
        System.out.println(p.toString() + "입니다.");
        p.moveDown(2); // z축으로 -2 이동
        System.out.println(p.toString() + "입니다.");
        p.move(5, 5); // x=5, y=5로 이동 
        System.out.println(p.toString() + "입니다.");
        p.move(100, 200, 300); // (100, 200, 300)으로 이동
        System.out.println(p.toString() + "입니다.");
    }
}
