package report2;

import java.util.Random;

public class chapter3_9 {
	public static void main(String[] args) {
		int [][] array = new int[4][4];
		Random random = new Random();
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				array[i][j] = random.nextInt(256);
			}
		}
		System.out.println("생성된 2차원 배열");
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(array[i][j]+"\t");  //   \t는 깔끔하게 열을 정렬하기위해 사용
			}
			System.out.println();
		}
	}
}