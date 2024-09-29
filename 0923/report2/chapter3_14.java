package report2;
import java.util.Random;
import java.util.Scanner;

public class chapter3_14 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("엔터키를 입력 >> ");
            scanner.nextLine();

            // 랜덤 숫자 생성
            int sum1 = random.nextInt(3);
            int sum2 = random.nextInt(3);
            int sum3 = random.nextInt(3);
            
            System.out.println(sum1 + ", " + sum2 + ", " + sum3);
            
            // 성공 여부 판단
            if (sum1 == sum2 && sum2 == sum3) {
                System.out.println("성공 대박!!");
                String continueInput;
                
                while (true) {
                    System.out.print("계속 하시겠습니까? (yes/no): ");
                    continueInput = scanner.nextLine();
                    
                    if (continueInput.equals("yes")) {
                        break;
                    } else if (continueInput.equals("no")) {
                        System.out.println("종료합니다.");
                        return;
                    } else {
                        System.out.println("잘못된 입력입니다. 'yes' 또는 'no'를 입력하세요.");
                    }
                }
            }
        }
        
    }
}
