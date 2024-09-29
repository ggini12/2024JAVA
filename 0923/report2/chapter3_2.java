// 배열의 길이를 계산해서 양의 정수중에 4의 배수만 출력하는 프로그램
package report2;

public class chapter3_2 {
	public static void main(String[] args) {
// ForLoopArray 클래스
//		int n[]= {1,-2,6,20,5,72,-16,256};
//		for(int i=0;i<n.length;i++) {
//			if(n[i] > 0 && n[i]%4==0) {
//				System.out.println(n[i]+" ");
//			}
//		}
// WhileLoopArray 클래스
//		int n[]= {1,-2,6,20,5,72,-16,256};
//		int i=0;
//		while(i<n.length) {
//			if(n[i]>0&&n[i]%4==0) {
//				System.out.println(n[i]+" ");
//			}
//			i++;
//		}
// DoWhileArray 클래스
		int n[] = {1, -2, 6, 20, 5, 72, -16, 256};
        int i = 0;

        do {
            if (n[i] > 0 && n[i] % 4 == 0) {
                System.out.println(n[i]+" ");
            }
            i++; // 인덱스 증가
        } while (i < n.length);
	}
}