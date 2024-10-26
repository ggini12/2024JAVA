package report4;

class Point3DColor {
    private int x;
    private int y;
    private int z;
    private String color;

    // 생성자
    public Point3DColor(int x, int y, int z, String color) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.color = color;
    }

    // 이동 메소드
    public void move(Point3DColor other) {
        this.x = other.x;
        this.y = other.y;
        this.z = other.z;
        this.color = other.color;
    }

    // equals 메소드
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point3DColor that = (Point3DColor) obj;
        return x == that.x && y == that.y && z == that.z && color.equals(that.color);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", 0)" + color + "점"; // z 값을 0으로 출력
    }
}

public class chapter5_7 {
    public static void main(String[] args) {
        Point3DColor p = new Point3DColor(10, 20, 30, "RED");
        System.out.println(p.toString() + "입니다.");

        Point3DColor q = new Point3DColor(1, 2, 3, "BLUE");
        p.move(q); // 점 p의 위치를 q로 이동

        System.out.println(p.toString() + "입니다.");

        // r의 색상을 BLUE로 변경
        Point3DColor r = new Point3DColor(1, 2, 3, "BLUE"); 
        if (p.equals(r)) System.out.println("예 같은 위치 같은 색깔의 점입니다.");
        else System.out.println("아니오");
    }
}
