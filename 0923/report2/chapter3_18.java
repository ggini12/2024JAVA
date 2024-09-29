package report2;

import java.util.Scanner;

public class chapter3_18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] studentIds = new int[10];
        int[] scores = new int[10];

        // 학생 학번과 점수 입력 받기
        System.out.println("10명의 학생의 학번과 점수 입력");
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + ">> ");
            studentIds[i] = scanner.nextInt();
            scores[i] = scanner.nextInt();
        }

        // 메뉴 반복
        while (true) {
            System.out.print("학번으로 검색 : 1, 점수로 검색 2, 끝내려면 3>> ");
            int choice = scanner.nextInt();

            if (choice == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if (choice == 1) { // 학번 검색
                System.out.print("학번>> ");
                int id = scanner.nextInt();
                boolean found = false;

                for (int i = 0; i < studentIds.length; i++) {
                    if (studentIds[i] == id) {
                        System.out.println(id + "번 학생은 " + scores[i] + "점입니다.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println(id + "번 학생은 없습니다.");
                }
            } else if (choice == 2) {
                System.out.print("점수>> ");
                int score = scanner.nextInt();
                StringBuilder studentsWithScore = new StringBuilder();
                // 문자열을 변경할수있는 클래스 ex)studentsWithScore.append("내용변경"); 이것도 뒤에 내용이 붙는형식
                // String은 불가능함. 할려면 ex)str=str+"내용"; 으로 더 붙이기만 가능.

                for (int i = 0; i < scores.length; i++) {
                    if (scores[i] == score) {
                        if (studentsWithScore.length() > 0) {  //studentswithscore에 참 값 추가
                            studentsWithScore.append(" ");
                        }
                        studentsWithScore.append(studentIds[i]);
                    }
                }
                if (studentsWithScore.length() > 0) {
                    System.out.println("점수가 " + score + "인 학생은 " + studentsWithScore + "입니다.");
                } else {
                    System.out.println("점수가 " + score + "인 학생은 없습니다.");
                }
            } else {
                System.out.println("잘못된 선택입니다.");
            }
        }

        scanner.close();
    }
}

