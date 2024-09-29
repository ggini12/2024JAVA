package report2;

import java.util.Random;
import java.util.Scanner;

public class chapter3_11 {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		int wrongcount = 0;
		int maxwrong = 3;
		
		while(wrongcount<maxwrong) {
			int one = random.nextInt(8)+2;  // 원래0~7인데 +2를해서 2~9
			int two = random.nextInt(9)+1;  // 원래0~8인데 +1를해서 1~9
			
			int answer = one*two;
			
			System.out.printf("%d x %d = ",one,two);
			int useranswer = scanner.nextInt();
			
			if(useranswer == answer) {
				System.out.println("정답입니다.");
			}
			else {
				wrongcount++;
				System.out.printf("오답입니다 틀린횟수 : %d\n",wrongcount);
			}
			if(wrongcount==maxwrong) {
				System.out.println("3번 틀렸습니다.");
				System.out.println("게임종료");
				break;
			
			}
		}
	}
}
