//생년월일을 입력하면 알아서 나눠서 출력해라 ex) 20010125 == 2001년 1월 25일
package report1;

import java.util.Scanner;

public class p110_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("생일을 입력하세요 >>>");
		int birth = scanner.nextInt();
		int year = birth / 10000; 
        int month = (birth / 100) % 100;     
        int day = birth % 100;
        System.out.println(year+"년 "+month+"월 "+day+"일");
        
		
	}
}
