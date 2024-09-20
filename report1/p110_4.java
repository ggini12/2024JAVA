//여행경비를 계산하는 프로그램을 작성 방 하나에는 2명까지 투숙 가능1명만 투숙해도 1방의 비용을 지불

package report1;

import java.util.Scanner;

public class p110_4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("여행지 >>>");
		String place = scanner.nextLine();
		
		System.out.print("인원수 >>>");
		int person = scanner.nextInt();
		
		System.out.print("숙박일 >>>");
		int day = scanner.nextInt();
		
		System.out.print("1인당 항공료 >>>");
		int airplane = scanner.nextInt();
		
		System.out.print("1방 숙박비 >>>");
		int day_money = scanner.nextInt();
		int room = (person + 1) / 2; 
        
        int totalairplanecost = airplane * person;
        int totalroomcost = day_money * room * day; 
        int totalcost = totalairplanecost + totalroomcost;
        
		System.out.println(person+" 명의 "+place+day+" 박"+(day+1)+" 일 여행에는 방이 "+room+"개 필요하며 경비는 "+ totalcost+"원 입니다.");
	}
}
