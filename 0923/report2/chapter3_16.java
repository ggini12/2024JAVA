package report2;

import java.util.Scanner;

public class chapter3_16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("양의 정수를 입력하세요. -1은 입력끝 >> ");

        double sum = 0; // 양수의 합
        int count = 0;  // 양수의 개수

        while (true) {
            String input = scanner.nextLine();

            // 공백을 기준으로 분리
            String[] numbers = input.split(" ");
            for (String numStr : numbers) {
                try {
                    int num = Integer.parseInt(numStr);
                    
                    // -1 입력 시 종료
                    if (num == -1) {
                        break; // for 루프 종료
                    }
                    
                    // 양수인 경우에만 합산
                    if (num > 0) {
                        sum += num;
                        count++;
                    } else {
                        // 음수일 때 메시지 출력
                        System.out.println(num + "은 제외");
                    }
                } catch (NumberFormatException e) {   //numberforamtexception은 문자열을 정수로변환할때 유효한지아닌지 검사
                    // 정수가 아닌 경우 무시
                    System.out.println(numStr + "은 제외");
                }
            }

            // -1이 입력된 경우 while 루프 종료
            if (input.contains("-1")) {
                break;
            }
        }

        // 평균 계산 및 출력
        if (count > 0) {
            double average = sum / count;
            System.out.printf("평균은 %.0f\n", average);
        } else {
            System.out.println("입력한 양수가 없습니다.");
        }

    }
}
