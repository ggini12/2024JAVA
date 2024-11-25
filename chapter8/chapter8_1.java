package report7;

import java.util.Scanner;
import java.util.Vector;

public class chapter8_1 {
    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // Vector<Integer> 객체 생성
        Vector<Integer> numbers = new Vector<>();

        System.out.println("정수 입력(-1이면 입력끝)>>>");

        // 사용자로부터 입력을 받음
        while (true) {
            int input = scanner.nextInt();

            // -1 입력 시 종료
            if (input == -1) {
                break;
            }

            // 입력값이 -1이 아니면 Vector에 추가
            numbers.add(input);
        }

        // Vector가 비어있지 않다면, 가장 작은 수를 출력
        if (!numbers.isEmpty()) {
            int min = numbers.get(0);  // 첫 번째 값을 최소값으로 초기화

            // 벡터를 순회하며 가장 작은 값 찾기
            for (int num : numbers) {
                if (num < min) {
                    min = num;
                }
            }

            // 가장 작은 값 출력
            System.out.println("제일 작은 수는 " + min);
        } else {
            System.out.println("입력된 값이 없습니다.");
        }

        // Scanner 객체 닫기
        scanner.close();
    }
}
