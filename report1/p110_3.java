//분식점 가격 계산 프로그램 만들기 떡볶이는 1인분 2000원, 김말이 1인분은 1000원 쫄면 1인분은 3000원이고
//각각 몇인분씩 주문햇는지 입력받고 최종 가격을 출력하는 프로그램 작성
package report1;

import java.util.Scanner;

public class p110_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("**** 자바 분식입니다. 주문하면 금액을 알려드립니다. ****");
		System.out.print("떡볶이 몇 인분 : ");
		int dduck = scanner.nextInt();
		System.out.print("김말이 몇 인분 : ");
		int gim = scanner.nextInt();
		System.out.print("쫄면 몇 인분 : ");
		int zzol = scanner.nextInt();
		int money = (dduck*2000)+(gim*1000)+(zzol*3000);
		System.out.println("전체 금액은 : "+money+" 원입니다.");
	}
}
