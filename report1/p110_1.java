//scanner 클래스를 사용하여 달러를 입력받아 원화로 바꾸는 프로그램 작성 1$=1200원
package report1;

import java.util.Scanner;

public class p110_1 {
	public static void main(String[] args) {
		int one;
		int doll;
		Scanner scanner = new Scanner(System.in);
		System.out.println("1$=1200원입니다. 달러를 입력하세요 >>>");
		doll = scanner.nextInt();
		one = doll*1200;
		System.out.println("$"+doll+"는 "+one+" 원입니다.");
	}
}
