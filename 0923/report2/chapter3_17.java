package report2;

import java.util.Scanner;

public class chapter3_17 {
    public static void main(String[] args) {
        String[] coffee = {"핫아메리카노", "아이스아메리카노", "카푸치노", "라떼"};
        int[] price = {3000, 3500, 4000, 5000};

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("주문 >> ");
            String order = scanner.nextLine();

            if (order.equals("그만")) {
                System.out.println("종료합니다.");
                break;
            }

            String[] parts = order.split(" ");  // 공백을 기준으로 order에 글을 parts라는 배열로 반환함.
            if (parts.length < 2) {
                System.out.println("주문 형식이 잘못되었습니다. 예: 아이스아메리카노 2");
                continue;
            }

            String coffeeName = parts[0];
            int quantity;

            
            try {
                quantity = Integer.parseInt(parts[1]);  //integer.parseint는 문자열(integer)을 정수로
                if (quantity <= 0) {
                    System.out.println("잔 수는 양의 정수로 입력해주세요!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("잔 수는 양의 정수로 입력해주세요!");
                continue;
            }

            
            int index = -1;
            for (int i = 0; i < coffee.length; i++) {
                if (coffee[i].equals(coffeeName)) {
                    index = i;
                    break;
                }
            }

            // 가격 계산
            if (index != -1) {
                int totalPrice = price[index] * quantity;
                System.out.printf("가격은 %d원입니다.\n", totalPrice);
            } else {
                System.out.printf("%s는 없는 메뉴입니다.\n", coffeeName);
            }
        }
        
    }
}
