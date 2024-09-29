//1. 무엇을계산하는 코드인가? = 1부터 3씩증가하는 숫자의 합을 구하는 코드
//2. 위코드를 main()메소드로 만들고 whileloop클래스로 완성하라.
//3. for 문을 이용하여 동일하게 실행되는 forLoop 클래스를 작성하라.
//4. do-while문을 이용하여 동일하게 실행되는 dowhileloop클래스를 작성하라.

package report2;



public class chapter3_1_WhileLoop {
//	public static void main(String[] args) {
//		int sum = 0, i = 1;
//        while (true) {
//            if (i > 50)
//                break;
//            sum = sum + i;
//            i += 3;
//        }
//        System.out.println(sum);
//	}
//-------------------------------------------------------
//	public static void main(String[] args) {
//		int sum=0;
//		for(int i=1;i<50;i+=3) {
//			sum+=i;
//		}
//		System.out.println(sum);
//	}
//-------------------------------------------------------
	public static void main(String[] args) {
		
	
	int sum = 0, i = 1;
    do {
        if (i > 50)
            break;
        sum += i;
        i += 3;
    } while (true);
    System.out.println(sum);
}
}
