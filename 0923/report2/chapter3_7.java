package report2;

import java.util.Random;
import java.util.Scanner;

public class chapter3_7 {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		int[] numbers = new int[10];
		
		for (int i = 0; i < numbers.length; i++) {
        numbers[i] = random.nextInt(9) + 11; // 0~8 범위의 정수에 11을 더해 11~19 범위의 정수 생성
		}
		// 평균계산
        double sum = 0;
        for (int number : numbers) {
            sum += number; // 각 요소의 합을 계산
        }
        double average = sum / numbers.length; // 각 요소의 합 나누기 배열의 길이 만큼
        System.out.print("랜덤한 정수들 : ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println("\n평균: " + average);
    }
}
