package report2;

import java.util.Scanner;

public class chapter3_13 {
	public static void main(String[] args) {
		String course [] = {"C","C++","Python","Java","HTML5"};
		String grade [] = {"A","B+","B","A+","D"};
		Scanner scanner = new Scanner(System.in);
		while(true) {
		System.out.print("종료하려면 그만 입력/ 과목>>");
		String cour = scanner.next();
		
		if(cour.equals("그만")) {
			System.out.println("프로그램을 종료합니다.");
			break;
		}
		int index = -1;
        for (int i = 0; i < course.length; i++) {
            if (course[i].equals(cour)) {
                index = i;
                break;
            }
        }
		
        // 결과 출력
        if (index != -1) {
            System.out.println(cour + "의 학점은 " + grade[index] + "입니다.");
        } else {
            System.out.println(cour + "은 없는 과목입니다.");
        }
    }
	}
}
