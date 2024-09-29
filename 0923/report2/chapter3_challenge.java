package report2;

import java.util.Random;
import java.util.Scanner;

public class chapter3_challenge{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            int number = random.nextInt(100);
            System.out.println("0부터 99까지의 수를 맞춰보세요!");
            int min = 0;
            int max = 99;

            while (true) {
                System.out.print("숫자를 입력하세요: ");
                int i = scanner.nextInt();

                if (i < number) {
                    System.out.println("더 높게");
                    min = i;
                } else if (i > number) {
                    System.out.println("더 낮게");
                    max = i;
                } else {
                    System.out.println("정답입니다!");
                    break;
                }
                System.out.printf("현재 범위: %d - %d\n", min, max);
            }

            System.out.print("다시 하시겠습니까? (y/n): ");
            char r = scanner.next().charAt(0);
            if (r != 'y') {
                System.out.println("게임을 종료합니다");
                break;
            }
        }

        scanner.close();
    }
}
