package report4;

class PositivePoint {
    private int x;
    private int y;

    // 생성자
    public PositivePoint(int x, int y) {
        if (x < 0 || y < 0) {
            this.x = 1;
            this.y = 1;
        } else {
            this.x = x;
            this.y = y;
        }
    }

    // 점 이동 메소드
    public void move(int dx, int dy) {
        if (this.x + dx > 0 && this.y + dy > 0) {
            this.x += dx;
            this.y += dy;
        }
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class chapter5_6 {
    public static void main(String[] args) {
        PositivePoint p = new PositivePoint(10, 10);  // (10,10)의 점
        p.move(5, 5); // p는 (15,15) 점
        System.out.println(p.toString() + "입니다.");  // (15,15)의 점입니다.

        // 두 번째 이동은 p를 (2, -2)로 이동할 수 있도록 임의로 수정
        p.move(-13, -13);  // p는 (2,2) 점
        System.out.println(p.toString() + "입니다.");  // (2,2)의 점입니다.

        PositivePoint q = new PositivePoint(-10, -10); // 음수 점불가. 디폴트(1,1)의 점 생성
        System.out.println(q.toString() + "입니다.");  // (1,1)의 점입니다.
    }
}
