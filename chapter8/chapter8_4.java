package report7;

import java.util.HashMap;
import java.util.Scanner;

public class chapter8_4 {
    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 상품 목록과 가격을 HashMap에 저장
        HashMap<String, Integer> productPrices = new HashMap<>();
        productPrices.put("고추장", 3000);
        productPrices.put("만두", 500);
        productPrices.put("새우깡", 1500);
        productPrices.put("콜라", 600);
        productPrices.put("참치캔", 2000);
        productPrices.put("치약", 1000);
        productPrices.put("연어", 2500);
        productPrices.put("삼겹살", 2500);

        // 쇼핑 비용 계산 시작
        System.out.println("쇼핑 비용을 계산해드립니다. 구입 가능 물건과 가격은 다음과 같습니다.");
        System.out.println("[고추장, 3000] [만두, 500] [새우깡, 1500] [콜라, 600] [참치캔, 2000] [치약, 1000] [연어, 2500] [삼겹살, 2500]");

        while (true) {
            System.out.print("물건과 개수를 입력하세요>> ");
            String input = scanner.nextLine();

            // "그만" 입력 시 종료
            if (input.equals("그만")) {
                break;
            }

            String[] items = input.split(" ");  // 물건과 개수를 공백으로 구분
            int totalCost = 0;  // 전체 비용 초기화
            boolean invalidItem = false;  // 잘못된 물건이 있는지 여부 체크

            for (int i = 0; i < items.length; i += 2) {
                String product = items[i];  // 물건 이름
                int quantity = Integer.parseInt(items[i + 1]);  // 물건 개수

                // 상품이 목록에 있는지 확인
                if (productPrices.containsKey(product)) {
                    // 가격을 찾아서 총 비용에 추가
                    totalCost += productPrices.get(product) * quantity;
                } else {
                    // 목록에 없는 상품일 경우
                    System.out.println(product + "은(는) 없는 상품입니다!");
                    invalidItem = true;
                    break;  // 잘못된 상품이 있으면 더 이상 계산하지 않음
                }
            }

            // 잘못된 상품이 없으면 전체 비용 출력
            if (!invalidItem) {
                System.out.println("전체비용은 " + totalCost + "원입니다.");
            }
        }

        // Scanner 닫기
        scanner.close();
    }
}
