package report3;

class Rectangle{
	int x;
	int y;
	int width;
	int height;
	
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public void show() {
		System.out.println("("+x+","+y+")에서 크기가 "+width+"x"+height+"인 사각형");
	}
	public boolean isSquare() {
		return width == height;
	}
	public boolean contains(Rectangle other) {
		return (this.x<=other.x && 
				this.y<=other.y && 
				(this.x+this.width)>=(other.x+other.width)&&
				(this.y+this.height)>=(other.y+other.height));
	}
}

public class chapter4_6 {
	public static void main(String[] args) {
		Rectangle a = new Rectangle(3,3,6,6);  // (3,3) 점에서 6x6 크기의 사각형
		Rectangle b = new Rectangle(4,4,2,3);  // (4,4) 점에서 2x3 크기의 사각형
		
		a.show();
		if(a.isSquare()) System.out.println("a는 정사각형입니다.");
		else System.out.println("a는 직사각형입니다.");
		if(a.contains(b)) System.out.println("a는 b를 포함합니다.");
	}
}
