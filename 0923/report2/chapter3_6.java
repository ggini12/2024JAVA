package report2;

import java.util.Scanner;

public class chapter3_6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] number = new int[10];
		System.out.println("양의 정수 10개를 입력하세요:");
        for (int i = 0; i < 10; i++) {
            number[i] = scanner.nextInt();
        }

        for (int s : number) {
            if (Sum(s) == 9) {
                System.out.print(s+" ");
            }
        }

        scanner.close();
    }

    public static int Sum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
	}
}
