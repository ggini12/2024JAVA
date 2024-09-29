package report2;

import java.util.Scanner;

public class chapter3_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("양의 정수 입력 (세로 줄 수): ");
        int n = scanner.nextInt();
        System.out.print("양의 정수 입력 (가로 별 수): ");
        int m = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
	}
}
