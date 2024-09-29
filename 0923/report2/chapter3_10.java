package report2;

import java.util.Random;
import java.util.Scanner;

public class chapter3_10 {
	public static void main(String[] args) {
		int [][] array = new int[4][4];
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				array[i][j] = random.nextInt(256);
			}
		}
		System.out.println("초기 2차원 배열");
		printArray(array);
		
		System.out.println("임계값을 입력하세요 : ");
		int dlarP = scanner.nextInt();
		
		for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[i][j] > dlarP) {
                    array[i][j] = 255; // 임계값보다 크면 255로 수정
                } else {
                    array[i][j] = 0; // 임계값보다 작으면 0으로 수정
                }
            }
        }

        // 수정된 배열 출력
        System.out.println("수정된 2차원 배열:");
        printArray(array);

        scanner.close();
		
	}
	public static void printArray(int[][] array) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(array[i][j] + "\t"); //  \t는 열의 정렬하기위해필요
            }
            System.out.println(); // 줄 바꿈
        }
    }
}
