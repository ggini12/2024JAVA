// 자동차 상태입력 >>> 139
// 자동차는 달리는 상태이고 에어컨은 꺼진 상태이고 온도는 11도이다.
package report2;

import java.util.Scanner;

public class p114_12 {
public static void main(String[] args) {
   Scanner scanner = new Scanner(System.in);
   
   // 문자열 형태로 입력받은 후 이진수로 변환한다
   String str = scanner.next();
   // 문자열 00001010을 2진수로 만들어 바이트 타입의 정수 status 저장
   byte status = Byte.parseByte(str, 2);
   
   if((status & 00000001)!= 0) System.out.println("전원이 켜져 있음");
   else System.out.println("전원이 꺼져 있음");
   
   if((status & 00000010)!= 0) System.err.println("문이 닫혀 있음");
   else System.out.println("문이 열려 있음");
   
   if((status & 00000100)!= 0) System.out.println("전구 정상 작동");
   else System.out.println("전구가 손상 된 상태");
   
   if((status & 00001000)!= 0) System.out.println("3도 미만");
   else System.out.println("3도 이상");
   
   scanner.close();
}
}

