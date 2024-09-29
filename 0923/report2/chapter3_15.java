package report2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class chapter3_15 {
	public static void main(String[] args) {
		int n,m=0;
		Scanner scanner = new Scanner(System.in);
		while(true) {
			try {
		System.out.print("곱하고자 하는 정수 2개 입력 >> ");
		n =	scanner.nextInt();
		m =	scanner.nextInt();
		break;
		}
			catch(InputMismatchException e){   // inputmismatchexception은 입력을 받을때 예상타입과 다른지 검사
				System.out.println("정수가아닙니다 다시입력해주세요");
				scanner.nextLine();
			}
		}
		System.out.println(n+" x "+m+" = "+n*m);
	}
}
