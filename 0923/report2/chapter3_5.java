package report2;

import java.util.Scanner;

public class chapter3_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int [] number = new int[10];
		System.out.println("양의 정수 10개 입력 >>> ");
		for(int i=0;i<10;i++) {
			number[i]=scanner.nextInt();
		}
		for(int three : number) {
			if(three%3==0) {
				System.out.print(three+" ");
			}
		}
	}
}
