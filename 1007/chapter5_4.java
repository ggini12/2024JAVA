package report4;

class BasePoint {  // Point 클래스를 BasePoint로 이름 변경
    private int x;
    private int y;

    public BasePoint() {
        this.x = 0;
        this.y = 0;
    }

    public BasePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getDistance(BasePoint other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}

class ColorPoint2 extends BasePoint {  // 상속받는 클래스 이름도 변경
    private String color;

    public ColorPoint2() {
        super(); // 기본 좌표 (0, 0)
        this.color = "WHITE"; // 기본 색상
    }

    public ColorPoint2(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    public ColorPoint2(int x, int y) {
        super(x, y);
        this.color = "WHITE"; // 기본 색상
    }

    public void set(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color + "색의 (" + getX() + "," + getY() + ")의 점";
    }
}

public class chapter5_4 {
    public static void main(String[] args) {
        ColorPoint2 zeroPoint = new ColorPoint2();
        System.out.println(zeroPoint.toString() + "입니다.");
        
        ColorPoint2 cp = new ColorPoint2(10, 10, "RED");
        cp.set("BLUE");
        cp.set(10, 20); // 좌표를 (10, 20)으로 설정
        System.out.println(cp.toString() + "입니다.");

        ColorPoint2 thresholdPoint = new ColorPoint2(100, 100);
        System.out.println("cp에서 임계점까지의 거리는 " + cp.getDistance(thresholdPoint));
    }
}
