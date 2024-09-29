//냉장고 상태입력 >> 00001101
//전원켜져잇음.문열려있음.전구정상작동.냉장고 온도 3도미만.
package report2;

import java.util.Scanner;

public class p113_11 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("냉장고 상태 입력 >>> ");
		String str = scanner.next();
		byte status = Byte.parseByte(str,2);
		if((status & 0b00000001)!=0) System.out.println("전원 켜져있음.");
		else System.out.println("전원 꺼져 있음.");
		if((status & 0b00000010)!=0) System.out.println("문 닫혀있음.");
		else System.out.println("문 열려 있음.");
		if((status & 0b0000100)!=0) System.out.println("전구 정상작동.");
		else System.out.println("전구 손상.");
		if((status & 0b0001000)!=0) System.out.println("냉장고 온도 3도 미만.");
		else System.out.println("냉장고 온도 3도 이상.");
		scanner.close();
	}
	
}
