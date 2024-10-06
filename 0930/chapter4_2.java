package report3;

class Cube{
	int rkfh;
	int tpfh;
	int shvdl;
	
	public Cube(int rkfh,int tpfh, int shvdl) {
		this.rkfh = rkfh;
		this.tpfh = tpfh;
		this.shvdl = shvdl;
	}
	public int getVolume() {
		return rkfh*tpfh*shvdl;
	}
	public void increase(int rkfh1, int tpfh1, int shvdl1) {
		this.rkfh += rkfh1;
		this.tpfh += tpfh1;
		this.shvdl += shvdl1;
	}
	public boolean isZero() {
		return getVolume()==0;
	}
}

public class chapter4_2 {
	public static void main(String[] args) {
		Cube cube = new Cube(1,2,3); // 가로 세로 높이
		System.out.println("큐브의 부피는 "+cube.getVolume());
		cube.increase(1,2,3); // 각각 1,2,3,씩증가
		System.out.println("큐브의 부피는" +cube.getVolume());
		if(cube.isZero())
			System.out.println("큐브의 부피는 0");
		else
			System.out.println("큐브의 부피는 0이 아님");
	}
}
