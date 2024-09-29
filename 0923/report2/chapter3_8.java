package report2;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class chapter3_8 {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int count = scanner.nextInt();
		HashSet<Integer> onlynumber = new HashSet<>();  //hashset은 중복되지않는 숫자를 저장할수잇는 것
		while(onlynumber.size()<count) {       
			int randomnumber = random.nextInt(100)+1;  // 숫자 0부터 100까지
			onlynumber.add(randomnumber); // 중복된 숫자 불가능
		}
		Integer[] number = onlynumber.toArray(new Integer[0]); // 배열로 바꾸기
		
		double sum = 0;
		for(int n : number) {   // number의 값을 n으로 옮기고
			sum += n;     // n의 값을 sum에 합친다.
		}
		double avg = sum/number.length;  // sum의 값을 number배열의 길이만큼 나누기
		
		System.out.print("저장된 정수들 : ");
		for(int n : number) {    // number 배열의 값을 n에 for문을 사용하여 차례대로 옮김.
			System.out.print(n+" ");
		}
		System.out.println("\n평균 "+avg);
	}
}
